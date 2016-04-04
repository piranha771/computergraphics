package cgresearch.studentprojects.proceduralcars;

import cgresearch.AppLauncher;
import cgresearch.JoglAppLauncher;
import cgresearch.core.assets.ResourcesLocator;
import cgresearch.core.math.VectorFactory;
import cgresearch.graphics.bricks.CgApplication;
import cgresearch.graphics.scenegraph.LightSource;

import java.io.IOException;
import java.util.Observable;

/**
 * Procedural Cars
 *
 * @author David Asmuth
 */
public class ProceduralCars extends CgApplication {
    public ProceduralCars() {
        //loadCollada();

        LightSource light = new LightSource(LightSource.Type.POINT);
        light.setPosition(VectorFactory.createVector3(5, 5, 5));
        light.setDirection(VectorFactory.createVector3(-1, -1, -1));
        light.setColor(VectorFactory.createVector3(1, 1, 1));
        // light.setSpotOpeningAngle(20);
        getCgRootNode().addLight(light);

        LightSource light2 = new LightSource(LightSource.Type.POINT);
        light2.setPosition(VectorFactory.createVector3(-5, -5, -5));
        light2.setDirection(VectorFactory.createVector3(-1, -1, -1));
        light2.setColor(VectorFactory.createVector3(1, 1, 1));
        // light2.setSpotOpeningAngle(20);
        getCgRootNode().addLight(light2);
    }

    public static void main(String[] args) throws IOException {
        ResourcesLocator.getInstance().parseIniFile("resources.ini");
        CgApplication app = new ProceduralCars();
        JoglAppLauncher appLauncher = JoglAppLauncher.getInstance();
        appLauncher.create(app);
        appLauncher.setRenderSystem(AppLauncher.RenderSystem.JOGL);
        appLauncher.setUiSystem(AppLauncher.UI.JOGL_SWING);
        MorphKeyGUI gui = new MorphKeyGUI(app.getCgRootNode());
        appLauncher.addCustomUi(gui);
    }



    @Override
    public void update(Observable o, Object arg) {

    }
}
