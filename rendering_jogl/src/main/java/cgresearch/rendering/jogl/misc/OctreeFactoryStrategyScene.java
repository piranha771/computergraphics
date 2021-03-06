package cgresearch.rendering.jogl.misc;

import java.util.ArrayList;

import cgresearch.core.math.BoundingBox;
import cgresearch.core.math.Vector;
import cgresearch.graphics.datastructures.tree.IOctreeFactoryStrategy;
import cgresearch.graphics.datastructures.tree.OctreeNode;
import cgresearch.graphics.scenegraph.CgNode;

public class OctreeFactoryStrategyScene implements IOctreeFactoryStrategy<Integer> {

  /**
   * Elemente des Nodes
   */
  private ArrayList<CgNode> leafNodes = new ArrayList<CgNode>();

  /**
   * Constant fields.
   */
  private final static int X = 0;
  private final static int Y = 1;
  private final static int Z = 2;

  public OctreeFactoryStrategyScene(ArrayList<CgNode> objects) {
    this.leafNodes = objects;
  }

  /**
   * gibt die BoundingBox der kompletten Szene zurueck
   */
  @Override
  public BoundingBox getBoundingBox() {
    Vector tmpLl, tmpUr, ll = null, ur = null;
    for (int i = 0; i < leafNodes.size(); ++i) {
      tmpLl = leafNodes.get(i).getBoundingBox().getLowerLeft();
      tmpUr = leafNodes.get(i).getBoundingBox().getUpperRight();
      if (ll == null) {
        ll = tmpLl;
      }
      if (ur == null) {
        ur = tmpUr;
      }
      ll.set(X, tmpLl.get(X) < ll.get(X) ? tmpLl.get(X) : ll.get(X));
      ll.set(Y, tmpLl.get(Y) < ll.get(Y) ? tmpLl.get(Y) : ll.get(Y));
      ll.set(Z, tmpLl.get(Z) < ll.get(Z) ? tmpLl.get(Z) : ll.get(Z));

      ur.set(X, tmpUr.get(X) > ur.get(X) ? tmpUr.get(X) : ur.get(X));
      ur.set(Y, tmpUr.get(Y) > ur.get(Y) ? tmpUr.get(Y) : ur.get(Y));
      ur.set(Z, tmpUr.get(Z) > ur.get(Z) ? tmpUr.get(Z) : ur.get(Z));
    }
    if (ll != null && ur != null) {
      return new BoundingBox(ll, ur);
    } else {
      return null;
    }
  }

  @Override
  public int getNumberOfElements() {
    return leafNodes.size();
  }

  @Override
  public boolean elementFitsInNode(int elementIndex, OctreeNode<Integer> node) {
    BoundingBox cur = leafNodes.get(elementIndex).getBoundingBox();
    Vector nodeUpperRight = node.getBoundingBox().getUpperRight();

    if (cur.getUpperRight().get(X) < node.getLowerLeft().get(X)) {
      return false;
    }
    if (cur.getLowerLeft().get(X) > nodeUpperRight.get(X)) {
      return false;
    }
    if (cur.getUpperRight().get(Y) < node.getLowerLeft().get(Y)) {
      return false;
    }
    if (cur.getLowerLeft().get(Y) > nodeUpperRight.get(Y)) {
      return false;
    }
    if (cur.getUpperRight().get(Z) < node.getLowerLeft().get(Z)) {
      return false;
    }
    if (cur.getLowerLeft().get(Z) > nodeUpperRight.get(Z)) {
      return false;
    }

    return true;

  }
}
