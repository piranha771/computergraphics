/**
 * Prof. Philipp Jenke
 * Hochschule f�r Angewandte Wissenschaften (HAW), Hamburg
 * CG1: Educational Java OpenGL framework with scene graph.
 */

package cgresearch.rendering.jogl.camera;

import cgresearch.core.math.BoundingBox;
import cgresearch.core.math.Vector;
import cgresearch.graphics.camera.Camera;
import cgresearch.graphics.camera.CameraController;

/**
 * This class accepts user inputs and uses them to control the camera movement.
 * 
 * @author pjenke
 * 
 */
public class InspectionCameraController extends CameraController {

	/**
	 * Speed of the camera movement.
	 */
	private static final double SPEED = 0.03f;
	private static final double FIT_FACTOR = 1.5;

	/**
	 * Constructor.
	 */
	public InspectionCameraController() {
	}

	@Override
	public void mouseDeltaXLeftButton(final float deltaX) {
		Camera.getInstance().rotateEyeVertically(deltaX * SPEED);
	}

	@Override
	public void mouseDeltaYLeftButton(final float deltaY) {
		Camera.getInstance().rotateEyeHorizontally(-deltaY * SPEED);
	}

	@Override
	public void mouseDeltaYRightButton(final float deltaY) {
		Camera.getInstance().zoom(-deltaY * SPEED);
	}

	@Override
	public void fitToBoundingBox(BoundingBox bbox) {
		if (!bbox.isInitialized()) {
			return;
		}
		Camera.getInstance().setRef(bbox.getCenter());

		final double diameter = bbox.getDiameter();
		Vector eyeRef = Camera.getInstance().getRef()
				.subtract(Camera.getInstance().getEye()).getNormalized();
		eyeRef = eyeRef.multiply(diameter * FIT_FACTOR);
		Camera.getInstance().setEye(
				Camera.getInstance().getRef().subtract(eyeRef));
	}
}
