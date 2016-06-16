package cgresearch.studentprojects.proceduralcars.Generator;

import java.util.HashMap;

/**
 * Generator to create procedural cars.
 */
public class CarGenerator {

    private String startRule;

    private HashMap<String, Attribute<Integer>> intAttr = new HashMap<>();
    private HashMap<String, Attribute<Float>> floatAttr = new HashMap<>();
    private HashMap<String, Attribute<Boolean>> boolAttr = new HashMap<>();

    private HashMap<String, String> modelRes = new HashMap<>();
    private HashMap<String, String> textureRes = new HashMap<>();

    private HashMap<String, Rule> rules = new HashMap<>();


    private CarContainer rootContainer;

    public CarGenerator() {

    }

    public void addIntAttribute(Attribute<Integer> attr) {
        intAttr.put(attr.getName(), attr);
    }

    public void addFloatAttribute(Attribute<Float> attr) {
        floatAttr.put(attr.getName(), attr);
    }

    public void addBoolAttribute(Attribute<Boolean> attr) {
        boolAttr.put(attr.getName(), attr);
    }

    public void addModelRessource(String name, String path) {
        modelRes.put(name, path);
    }

    public void addTextureRessource(String name, String path) {
        textureRes.put(name, path);
    }

    public void setStartRule(String startRule) {
        this.startRule = startRule;
    }

    public void setRule(Rule rule) {
        this.rules.put(rule.getName(), rule);
    }

}
