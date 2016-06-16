package cgresearch.studentprojects.proceduralcars.Generator;

public class Attribute<T> {
    private String name;
    private T value;
    private boolean hasRange;
    private T minValue;
    private T maxValue;

    public Attribute(String name)
    {
        this.name = name;
        this.hasRange = false;
    }

    public Attribute(String name, T minValue, T maxValue)
    {
        this.name = name;
        this.hasRange = minValue != null && maxValue != null;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    public boolean getHasRange() {
        return hasRange;
    }

    public T getMinValue() {
        return minValue;
    }

    public T getMaxValue() {
        return maxValue;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
