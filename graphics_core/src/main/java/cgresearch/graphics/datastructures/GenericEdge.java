package cgresearch.graphics.datastructures;

import cgresearch.core.math.IVector3;

/**
 * Generic parent interface for edges, used to put name in shared container.
 * 
 * @author Philipp Jenke
 */
public interface GenericEdge {

  /**
   * Sets the color of the edge (used for debugging).
   */
  public void setColor(IVector3 color);

  /**
   * Returns the first vertex of the edge.
   */
  public GenericVertex getStartVertex();

  /**
   * Returns the other vertex of the edge.
   */
  public GenericVertex getEndVertex();

}
