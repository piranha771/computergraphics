package cgresearch.studentprojects.proceduralcars.Generator.Functions;


import cgresearch.studentprojects.proceduralcars.Generator.CarGenerator;
import cgresearch.studentprojects.proceduralcars.Generator.Rule;

import java.util.List;

public class FuncContainer extends Function<Void> {

    public FuncContainer(CarGenerator gen, Rule rule, List<Function> parameters) {
        super(gen, rule, parameters);
    }

    @Override
    public Void Call() {
        // TODO: Create Container
        return null;
    }
}
