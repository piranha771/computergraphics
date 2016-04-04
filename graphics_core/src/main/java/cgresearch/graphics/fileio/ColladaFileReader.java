package cgresearch.graphics.fileio;

import cgresearch.core.math.Vector;
import cgresearch.graphics.datastructures.trianglemesh.ITriangleMesh;
import cgresearch.graphics.datastructures.trianglemesh.TriangleMesh;
import cgresearch.graphics.datastructures.trianglemesh.Vertex;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

/**
 * This class provides functionality to read 3D meshes from Collada (.dae) files.
 *
 */
public class ColladaFileReader {

    private ColladaHeader header;
    private HashMap<String, ColladaModel> meshes;





    private ColladaFileReader(String filename) {
        this.header = new ColladaHeader();
        this.header.setFilename(filename);
        this.meshes = new HashMap<>();
    }

    public static ColladaFileReader ReadFile(String filename) {
        ColladaFileReader dae = new ColladaFileReader(filename);
        dae.load();
        return dae;
    }

    private void load() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(header.getFilename());

            loadHeader(doc);
            loadGeometry(doc);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadHeader(Document doc) {

        Element collada = doc.getDocumentElement();

        header.setSchemaVersion(collada.getAttribute("version"));

        NodeList authors = collada.getElementsByTagName("author");
        for (int i = 0; i < authors.getLength(); i++) {
            if (i > 0) {
                header.setAuthor(header.getAuthor() + ", "  +  authors.item(i).getTextContent());
            } else {
                header.setAuthor(authors.item(i).getTextContent());
            }
        }
        NodeList authoring_tools = collada.getElementsByTagName("authoring_tool");
        for (int i = 0; i < authoring_tools.getLength(); i++) {
            if (i > 0) {
                header.setAuthoringTool(header.getAuthoringTool() + ", " +  authoring_tools.item(i).getTextContent());
            } else {
                header.setAuthoringTool(authoring_tools.item(i).getTextContent());
            }
        }

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        try {
            header.setDateCreated(format.parse(getElement(collada, "created").getTextContent()));
            header.setDateModified(format.parse(getElement(collada, "modified").getTextContent()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        header.setUnitName(getElement(collada, "unit").getAttribute("name"));
        header.setUnitScale(Float.parseFloat(getElement(collada, "unit").getAttribute(header.getUnitName())));

        // TODO: read up_axis
    }

    private void loadGeometry(Document doc) {
        Element collada = doc.getDocumentElement();


        Element sceneLib = getElement(collada, "library_visual_scenes");

        /** We go through each scene  **/
        NodeList scenes = sceneLib.getElementsByTagName("visual_scene");
        for (int i = 0; i < scenes.getLength(); i++) {
            if (scenes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element scene = (Element) scenes.item(i);

                /** In each scene we collect all meshes, and skip all non-mesh nodes **/
                NodeList nodes = scene.getElementsByTagName("node");
                for (int j = 0; j < nodes.getLength(); j++) {
                    if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {

                        Element node = (Element)nodes.item(j);
                        NodeList geos = node.getElementsByTagName("instance_geometry");
                        if (geos.getLength() == 1) {
                            addMeshes(doc, node);
                        }

                        //TODO: Apply matrix for the node?!
                    }
                }
            }
        }
    }

    private Element getElement(Element parent, String tagName) {
        NodeList list = parent.getElementsByTagName(tagName);
        if (list.getLength() != 1) {
            throw new IllegalArgumentException("Collada parse error: " + tagName + " was found more or less than once! (" + list.getLength() + ")");
        }
        if (list.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new IllegalArgumentException("Collada parse error: " + tagName + " is not a XML element!");
        }
        return (Element)list.item(0);
    }

    private void addMeshes(Document doc, Element meshNode) {
        ColladaModel model = new ColladaModel();
        Element iGeo = getElement(meshNode, "instance_geometry");
        model.setName(iGeo.getAttribute("name"));

        /** The URL contains the name of the mesh in the geometry section, but starts with '#' **/
        String url = iGeo.getAttribute("url").substring(1);
        /** Read additional morph keys from controller library
         * so we can apply them later on the existing model **/
        String[] morphKeys = readMorphKeys(url, doc);

        Element geoLib = getElement(doc.getDocumentElement(), "library_geometries");
        NodeList geometries = geoLib.getElementsByTagName("geometry");
        for (int i = 0; i < geometries.getLength(); i++) {
            if (geometries.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element geometry = (Element)geometries.item(i);
                String id = geometry.getAttribute("id");

                /** We only process the geometry if this the actual one we are looking for... **/
                if ( id != null && id.equals(url)) {
                    readMeshData(model.getTriangleMesh(), geometry);
                }
                /** Or this is a morph geometry. We check for all morph keys for this model **/
                for (String morphKey: morphKeys) {
                    if (id != null && id.equals(morphKey)) {
                        // Create new sub mesh for this morph key
                        ITriangleMesh morphMesh = new TriangleMesh();
                        /** The real, non-global morph key name, is in attr. 'name'! **/
                        model.getMorphs().put(geometry.getAttribute("name"), morphMesh);

                        readMeshData(morphMesh, geometry);
                    }
                }



            }
        }

        meshes.put(model.getName(), model);
    }

    /***
     * Reads vertex normal and indice data from a given geometry node and adds them to a given mesh
     * @param mesh The mesh the read data is added to
     * @param geometry The collada geometry node containing the mesh data
     */
    private void readMeshData(ITriangleMesh mesh, Element geometry) {

        // Read verices and normals
        NodeList sources = geometry.getElementsByTagName("source");
        for (int j = 0; j < sources.getLength(); j++) {
            if (sources.item(j).getNodeType() == Node.ELEMENT_NODE) {
                Element source = (Element) sources.item(j);
                String id = source.getAttribute("id");

                Vector[] vectors = readFloatData(getElement(source, "float_array"));

                // Vertices
                if (id.endsWith("-positions")) {
                    for (int i = 0; i < vectors.length; i++) {
                        mesh.addVertex(new Vertex(vectors[i]));
                    }
                }
                // Normals
                if (id.endsWith("-normals")) {
                    // TODO: Apply face normals to mesh here
                }
            }
        }

        // Read indices
        readIndexData(mesh, getElement(geometry, "polylist"));

        // TODO: Supported vertices per poly is only 3!
    }

    /***
     * Reads the indices from a give polylist node and applies them on a mesh
     * @param mesh The mesh the indices to apply to
     * @param polylist The node containing the indices
     */
    private void readIndexData(ITriangleMesh mesh, Element polylist) {
        String[] indicesString =  getElement(polylist, "p").getTextContent().split("\\s+");
        for (int i = 0; i < indicesString.length; i+=6) {
            mesh.addTriangle( // TODO: Implement correct interleaving here!
                    Integer.parseInt(indicesString[i]),
                    Integer.parseInt(indicesString[i+2]),
                    Integer.parseInt(indicesString[i+4]));
        }
    }

    /***
     * reads a sequence of float values from a text node and returns them as vectors
     * @param floatNode the 'float_array'-node containing the float array text
     * @return The float values as 3d-vectors
     */
    private Vector[] readFloatData(Element floatNode) {
        int length = Integer.parseInt(floatNode.getAttribute("count"));
        String[] stringArray = floatNode.getTextContent().split("\\s+");
        Vector[] result = new Vector[length/3]; // Todo: for quads we need to check the poly list!

        int x = 0;
        for (int i = 0; i < stringArray.length; i+=3) {
            result[x++] = new Vector(Float.parseFloat(stringArray[i]),
                                    Float.parseFloat(stringArray[i+1]),
                                    Float.parseFloat(stringArray[i+2]));
        }
        return result;
    }


    /***
     * Reads all morph keys for a specific mesh
     * @param url The url of the mesh to look up morph keys
     * @param doc The model document
     * @return All morph keys for this mesh as an array
     */
    private String[] readMorphKeys(String url, Document doc) {
        Element collada = doc.getDocumentElement();

        Element ctrlLib = getElement(collada, "library_controllers");
        NodeList morphs = ctrlLib.getElementsByTagName("morph");

        /** We check every morph if it fits our base model url **/
        for (int i = 0; i < morphs.getLength(); i++) {
            if (morphs.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element morph = (Element)morphs.item(i);

                if (morph.getAttribute("source").equals('#'+url)) {
                    /** We extract now all morph keys from the target array **/
                    Element ref = getElement(morph, "IDREF_array");
                    return ref.getTextContent().split("\\s+");
                }
            }
        }
        return new String[0];
    }

    public ColladaHeader getHeader() {
        return header;
    }

    public HashMap<String, ColladaModel> getMeshes() {
        return meshes;
    }
}
