package cgresearch.studentprojects.proceduralcars.Generator;

import cgresearch.studentprojects.proceduralcars.directions.BoxPosition;

public class Alignment {

    public static final Alignment CENTER = new Alignment(BoxPosition.CENTER, AlignMode.FLOAT);

    private AlignMode mode;
    private BoxPosition pivot;

    public Alignment(BoxPosition pivot, AlignMode mode)
    {
        this.pivot = pivot;
        this.mode = mode;
    }

    public AlignMode getMode() {
        return mode;
    }

    public BoxPosition getPivot() {
        return pivot;
    }
}
