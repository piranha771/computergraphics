/**
 * Chris Michael Marquardt
 * Hochschule f�r Angewandte Wissenschaften (HAW), Hamburg
 * Bachelorarbeit 2014
 */
package cgresearch.studentprojects.brickbuilder.brickcloud;

import java.util.List;

import cgresearch.core.math.IVector3;
import cgresearch.graphics.datastructures.trianglemesh.ITriangleMesh;
import cgresearch.studentprojects.brickbuilder.math.IVectorInt3;

/**
 * Interface for every usable brick in the algorithm.
 * 
 * @author Chris Michael Marquardt
 */
public interface IBrick {
	/**
	 * Get the dimensions of the brick as a vector.
	 * @return
	 */
	public IVector3 getDimensions();
	
	/**
	 * Get the 3d-model of the brick.
	 * @return
	 */
	public ITriangleMesh getModel();
	
	/**
	 * Get the type of the brick.
	 * @return
	 */
	public BrickType getBrickType();
	
	/**
	 * Get the rootbrick resolution.
	 * For special bricks its the max length for each axiz.
	 * @return
	 */
	public IVectorInt3 getResolution();
	
	/**
	 * Get the brick unit positions.
	 * @return
	 */
	public List<IVectorInt3> getUnitPositions();
}