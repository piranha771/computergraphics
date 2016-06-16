package cgresearch.studentprojects.proceduralcars.Generator.Functions;

import cgresearch.studentprojects.proceduralcars.Generator.CarGenerator;
import cgresearch.studentprojects.proceduralcars.Generator.Rule;

import java.util.ArrayList;
import java.util.List;

public abstract class Function<T> {
    protected CarGenerator gen;
    protected Rule rule;

    protected List<Function> parameters = new ArrayList<>();

    protected Function(CarGenerator gen, Rule rule, List<Function> parameters) {
        this.gen = gen;
        this.rule = rule;
        this.parameters = parameters;
    }

    public abstract T Call();

 /*

 Die parameter sind wieder ne list von Functions
 Eine Function kann auch nur eine ValueFunction sein die nur ein Wert trägt. Einfach wie bei Cloon umsetzen

 Wenn der Baum auifgebaut wird, ergeben sich die Parameter. EZ PZ.

 Achja. von hier noch irgendwie rausbekommen können was die Vater rule ist

 Im generator der Container ist da wo das ergebnis rein kommt. Von allem. Ist also schon result.

  */
}
