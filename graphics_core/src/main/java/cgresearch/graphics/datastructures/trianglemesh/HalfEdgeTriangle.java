package cgresearch.graphics.datastructures.trianglemesh;

import cgresearch.core.logging.Logger;
import cgresearch.core.math.IVector3;

/**
 * A facet has a reference to one of oits half edges. This datastructure
 * represents a general mesh (triangle, quad, ...). However, we only use
 * triangle meshes here.
 * 
 * @author Philipp Jenke
 *
 */
public class HalfEdgeTriangle implements ITriangle {

  /**
   * One of the half edges around the facet.
   */
  private HalfEdge halfEdge;

  /**
   * Facet normal
   */
  private IVector3 normal;

  public HalfEdge getHalfEdge() {
    return halfEdge;
  }

  public void setHalfEdge(HalfEdge halfEdge) {
    this.halfEdge = halfEdge;
  }

  @Override
  public String toString() {
    return "Triangular Facet";
  }

  public IVector3 getNormal() {
    return normal;
  }

  public void setNormal(IVector3 normal) {
    this.normal = normal;
  }

  /**
   * Compute the area of the facet. Area of the facet.
   * 
   * @return Area of the triangle.
   */
  public double getArea() {
    IVector3 v0 = halfEdge.getStartVertex().getPosition();
    IVector3 v1 = halfEdge.getNext().getStartVertex().getPosition();
    IVector3 v2 = halfEdge.getNext().getNext().getStartVertex().getPosition();
    return v1.subtract(v0).cross(v2.subtract(v0)).getNorm() / 2.0;
  }

  /**
   * Compute the centroid (center of mass) of the triangle.
   * 
   * @return Centroid of the triangle.
   */
  public IVector3 getCentroid() {
    IVector3 v0 = halfEdge.getStartVertex().getPosition();
    IVector3 v1 = halfEdge.getNext().getStartVertex().getPosition();
    IVector3 v2 = halfEdge.getNext().getNext().getStartVertex().getPosition();
    return (v0.add(v1).add(v2)).multiply(1.0 / 3.0);
  }

  @Override
  public int getA() {
    Logger.getInstance().error("Not implemented yet");
    return -1;
  }

  @Override
  public int getB() {
    Logger.getInstance().error("Not implemented yet");
    return -1;
  }

  @Override
  public int getC() {
    Logger.getInstance().error("Not implemented yet");
    return -1;
  }

  @Override
  public int getTextureCoordinate(int index) {
    Logger.getInstance().error("Not implemented yet");
    return -1;
  }

  @Override
  public int get(int i) {
    Logger.getInstance().error("Not implemented yet");
    return -1;
  }
}