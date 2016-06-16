package cgresearch.studentprojects.proceduralcars;

import cgresearch.AppLauncher;
import cgresearch.JoglAppLauncher;
import cgresearch.core.assets.ResourcesLocator;
import cgresearch.core.math.VectorFactory;
import cgresearch.graphics.bricks.CgApplication;
import cgresearch.graphics.scenegraph.LightSource;
import cgresearch.studentprojects.proceduralcars.Generator.*;
import cgresearch.studentprojects.proceduralcars.Generator.Parser;
import cgresearch.studentprojects.proceduralcars.dsl.ShapeGrammarBaseListener;
import cgresearch.studentprojects.proceduralcars.dsl.ShapeGrammarLexer;
import cgresearch.studentprojects.proceduralcars.dsl.ShapeGrammarListener;
import cgresearch.studentprojects.proceduralcars.dsl.ShapeGrammarParser;
import cgresearch.studentprojects.shapegrammar.grammar.ShapeGrammar;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.Trees;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        Parser parser = new Parser("studentprojects\\proceduralcars\\rules\\car.rule");
        CarGenerator carGenerator = parser.parse();
        /*
        CgApplication app = new ProceduralCars();
        JoglAppLauncher appLauncher = JoglAppLauncher.getInstance();
        appLauncher.create(app);
        appLauncher.setRenderSystem(AppLauncher.RenderSystem.JOGL);
        appLauncher.setUiSystem(AppLauncher.UI.JOGL_SWING);
        MorphKeyGUI gui = new MorphKeyGUI(app.getCgRootNode());
        appLauncher.addCustomUi(gui);*/
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

