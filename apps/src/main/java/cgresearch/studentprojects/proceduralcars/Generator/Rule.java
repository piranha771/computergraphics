package cgresearch.studentprojects.proceduralcars.Generator;

import cgresearch.studentprojects.proceduralcars.Generator.Functions.Function;

import java.util.ArrayList;
import java.util.List;

public class Rule {
    private CarGenerator gen;

    private String name;
    private List<Function> functions = new ArrayList<>();

    public Rule(CarGenerator gen, String name, List<Function> functions) {
        this.gen = gen;
        this.name = name;
        this.functions = functions;
    }

    public void Call() {
        for (Function func : functions){
            func.Call();
        }
    }

    public String getName() {
        return name;
    }
}
