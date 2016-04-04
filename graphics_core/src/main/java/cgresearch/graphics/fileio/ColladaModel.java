package cgresearch.graphics.fileio;

import cgresearch.graphics.datastructures.trianglemesh.ITriangleMesh;
import cgresearch.graphics.datastructures.trianglemesh.TriangleMesh;

import java.util.HashMap;
import java.util.Map;

/**
 * Model of a Collada file
 *
 * @author: David Asmuth
 */
public class ColladaModel {

    private String name;
    private ITriangleMesh mesh;
    private Map<String, ITriangleMesh> morphs;

    public ColladaModel() {
        this.mesh = new TriangleMesh();
        this.morphs = new HashMap<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ColladaModel{" +
                "name='" + name + '\'' +
                '}';
    }

    public ITriangleMesh getTriangleMesh() {
        return mesh;
    }

    // TODO: Encapsulate the map?!
    public Map<String, ITriangleMesh> getMorphs() {
        return morphs;
    }
}


