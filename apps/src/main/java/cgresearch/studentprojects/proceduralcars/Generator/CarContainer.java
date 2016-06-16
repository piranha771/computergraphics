package cgresearch.studentprojects.proceduralcars.Generator;

import cgresearch.core.math.Vector;
import cgresearch.core.math.VectorFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Logical container, that can contain other containers
 */
public class CarContainer {

    private CarContainer parent;

    private List<CarContainer> children = new ArrayList<>();

    private double width = -1.0;
    private double height = -1.0;
    private double length = -1.0;

    private Alignment alignment;

    /**
     * Creates a new root container. With position at zero.
     * @param width Width of the container.
     * @param height Height of the container.
     * @param length Length of the container.
     */
    public CarContainer(float width, float height, float length)
    {
        setParent(null);
        this.width = width;
        this.height = height;
        this.length = length;
        this.alignment = Alignment.CENTER;
    }

    /**
     * Creates a child container with size same as parent container.
     * @param parent The parent container.
     */
    public CarContainer(CarContainer parent)
    {
        setParent(parent);
        this.alignment = Alignment.CENTER;
    }

    /**
     * Creates a child container with given size and alignment
     * @param parent The parent container.
     * @param width Width of the container.
     * @param height Height of the container.
     * @param length Length of the container.
     * @param alignment The alignment of the container.
     */
    public CarContainer(CarContainer parent, float width, float height, float length, Alignment alignment)
    {
        setParent(parent);
        this.width = width;
        this.height = height;
        this.length = length;
        this.alignment = alignment;
    }

    /**
     * Returns the world position
     */
    public Vector getPosition()
    {
        //TODO: Calculate position based on container tree
        return VectorFactory.createVector3(0,0,0);
    }

    /**
     * Sets the parent and adds itself to parents children.
     * @param newParent The parent to attach to. null to remove parent;
     */
    private void setParent(CarContainer newParent)
    {
        // Check if the parent should be removed
        if (newParent == null)
        {
            //TODO: Keep in mind that unparenting means that the size cant be relative anymore!
            if (this.parent != null)
            {
                this.parent.children.remove(this);
            }
            this.parent = null;
            return;
        }

        // If parent exists: remove from old add to new
        if (this.parent != null)
        {
            this.parent.children.remove(this);
        }

        this.parent = newParent;
        this.parent.children.add(this);
    }
}
