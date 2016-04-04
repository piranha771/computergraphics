package cgresearch.studentprojects.proceduralcars;

import cgresearch.core.assets.ResourcesLocator;
import cgresearch.core.math.Vector;
import cgresearch.graphics.datastructures.trianglemesh.ITriangleMesh;
import cgresearch.graphics.datastructures.trianglemesh.TriangleMesh;
import cgresearch.graphics.datastructures.trianglemesh.Vertex;
import cgresearch.graphics.fileio.ColladaFileReader;
import cgresearch.graphics.fileio.ColladaModel;
import cgresearch.graphics.material.Material;
import cgresearch.graphics.scenegraph.CgNode;
import cgresearch.graphics.scenegraph.CgRootNode;
import cgresearch.ui.IApplicationControllerGui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Morph Key GUI for procedural cars
 *
 * @author David Asmuth
 */
public class MorphKeyGUI  extends IApplicationControllerGui implements ActionListener, ChangeListener {

    public static final String ACTION_COMMAND_FOPEN = "ACTION_COMMAND_FOPEN";
    public static final String ACTION_COMMAND_MODEL_SELECT = "ACTION_COMMAND_MODEL_SELECT";

    private CgRootNode root;
    private String colladaFile;
    private ColladaFileReader cfr;

    private JComboBox<String> modelBox;
    private JPanel morphPanel;
    private Map<String, JSlider> morphSlider;

    private boolean isRefreshing;

    public MorphKeyGUI(CgRootNode root) {
        this.root = root;
        this.morphSlider = new HashMap<>();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton browseButton = new JButton("Browse");
        browseButton.addActionListener(this);
        browseButton.setActionCommand(ACTION_COMMAND_FOPEN);
        add(browseButton);

        modelBox = new JComboBox<String>();
        modelBox.setMaximumSize(new Dimension(100,30));
        add(modelBox);
        morphPanel = new JPanel();
        morphPanel.setLayout(new BoxLayout(morphPanel, BoxLayout.Y_AXIS));
        morphPanel.setSize(100, 300);
        add(morphPanel);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ACTION_COMMAND_FOPEN)) {
            actionCommandFOpen();
        }
        if (e.getActionCommand().equals(ACTION_COMMAND_MODEL_SELECT)) {
            refreshMorphPanel(cfr);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Object src = e.getSource();
        if (src instanceof  JSlider) {
            if (!isRefreshing) {
                refreshModel();
            }
        }
    }

    @Override
    public String getName() {
        return "Morph Key GUI";
    }

    private void actionCommandFOpen() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(ResourcesLocator.getInstance().getPathToResource("studentprojects\\proceduralcars")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "COLLADA Files", "dae");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(getParent());
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            this.colladaFile = chooser.getSelectedFile().getAbsolutePath();
            loadCollada();
        }
    }

    private void loadCollada() {
        cfr = ColladaFileReader.ReadFile(colladaFile);
        refreshModelList(cfr);




    }

    private void refreshModelList(ColladaFileReader cfr) {
        modelBox.removeAllItems();
        for (String key : cfr.getMeshes().keySet()) {
            modelBox.addItem(key);
        }
        modelBox.addActionListener(this);
        modelBox.setActionCommand(ACTION_COMMAND_MODEL_SELECT);

        if (modelBox.getItemCount() > 0) {
            modelBox.setSelectedIndex(0);
        }
    }

    private void refreshMorphPanel(ColladaFileReader cfr) {
        morphPanel.removeAll();
        morphSlider.clear();

        String modelKey = (String)modelBox.getSelectedItem();
        for (String key : cfr.getMeshes().get(modelKey).getMorphs().keySet()) {
            morphPanel.add(new JLabel(key));
            JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
            slider.setMajorTickSpacing(20);
            slider.setMinorTickSpacing(1);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            slider.addChangeListener(this);
            morphPanel.add(slider);
            morphSlider.put(key, slider);
        }

        refreshModel();
    }

    private void refreshModel() {
        isRefreshing = true;
        resetModel();

        // Retrieve base model
        String modelKey = (String)modelBox.getSelectedItem();
        ColladaModel model = ColladaFileReader.ReadFile(colladaFile).getMeshes().get(modelKey);


        ITriangleMesh baseMesh = model.getTriangleMesh();
        ITriangleMesh currentMesh = new TriangleMesh(baseMesh);

        // Iterate through all morphKeys and apply them
        for (Map.Entry<String, JSlider> keyValue : morphSlider.entrySet()) {
            ITriangleMesh morphMesh = model.getMorphs().get(keyValue.getKey());
            JSlider currentSlider = keyValue.getValue();
            currentMesh = calculateMorphedMesh(baseMesh, morphMesh, currentMesh, (float)currentSlider.getValue() / (float)currentSlider.getMaximum());
        }

        currentMesh.computeTriangleNormals();
        currentMesh.computeVertexNormals();
        currentMesh.getMaterial().setShaderId(Material.SHADER_PHONG_SHADING);
        currentMesh.getMaterial().addShaderId(Material.SHADER_WIREFRAME);
        currentMesh.getMaterial().setReflectionAmbient(Material.PALETTE1_COLOR2);
        currentMesh.getMaterial().setReflectionDiffuse(Material.PALETTE1_COLOR2);


        CgNode testModelNode = new CgNode(currentMesh, "morphMesh");
        root.addChild(testModelNode);
        isRefreshing = false;
    }


    private void resetModel(){
        int count = getRootNode().getNumChildren();
        for (int i = 0; i < count; i++) {
            CgNode temp = getRootNode().getChildNode(i);
            if (temp.getName().equals("morphMesh")) {
                getRootNode().getChildNode(i).deleteNode();
            }
        }
    }

    private ITriangleMesh calculateMorphedMesh(ITriangleMesh baseMesh, ITriangleMesh morphMesh, ITriangleMesh currentMesh, float weight) {

        ITriangleMesh result = new TriangleMesh();

        /** For all morphed vertices the offset relative to the base vertices are added onto the current mesh**/
        int vCount = baseMesh.getNumberOfVertices();
        for (int i = 0; i < vCount; i++) {
            Vector base = baseMesh.getVertex(i).getPosition();
            Vector morph = morphMesh.getVertex(i).getPosition();
            Vector current = currentMesh.getVertex(i).getPosition();

            Vector maxOffset = morph.subtract(base);

            Vector currentOffset = lerp(new Vector(0,0,0), maxOffset, weight);

            Vector newVector = new Vector(current.get(0) + currentOffset.get(0),current.get(1) + currentOffset.get(1),current.get(2) + currentOffset.get(2));
            result.addVertex(new Vertex(newVector));
        }

        int triCount = baseMesh.getNumberOfTriangles();
        for (int i = 0; i < triCount; i++) {
            result.addTriangle(baseMesh.getTriangle(i));
        }

        return result;
    }

    private Vector lerp(Vector vStart, Vector vEnd, float percent) {
        return new Vector(lerp(vStart.get(0), vEnd.get(0), percent),
                lerp(vStart.get(1), vEnd.get(1), percent),
                lerp(vStart.get(2), vEnd.get(2), percent));
    }

    private double lerp(double start, double end, float percent) {
        return start + percent * (end - start);
    }


}


