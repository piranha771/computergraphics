package smarthomevis.groundplan;

import cgresearch.AppLauncher.RenderSystem;
import cgresearch.AppLauncher.UI;
import cgresearch.JoglAppLauncher;
import cgresearch.core.assets.ResourcesLocator;
import cgresearch.graphics.bricks.CgApplication;
import smarthomevis.groundplan.config.Converter;
import smarthomevis.groundplan.config.GPDataType;

public class GroundPlan extends CgApplication {

	private void run() {
		// renderProjektHORA();
		renderHaus02();
	}

	private void renderProjektHORA() {
		Converter converter = new Converter();
		GPDataType renderData = converter.importData("dxf/4H-HORA Projekt1.dxf", "dxf/4H-HORA Projekt1.xml");

		GPRenderer renderer = new GPRenderer(renderData);
		// getCgRootNode().addChild(renderer.render2DViewFromGPDataType());
		// getCgRootNode().addChild(renderer.render3DGridViewFromGPDataType());
		getCgRootNode().addChild(renderer.render3DMeshViewFromGPDataType());
	}

	private void renderHaus02() {
		Converter converter = new Converter();
		GPDataType renderData = converter.importData("dxf/Grundriss_Haus_02.dxf", "dxf/Grundriss_Haus_02.xml");

		GPRenderer renderer = new GPRenderer(renderData);
		// getCgRootNode().addChild(renderer.render2DViewFromGPDataType());
		// getCgRootNode().addChild(renderer.render3DGridViewFromGPDataType());
		getCgRootNode().addChild(renderer.render3DMeshViewFromGPDataType());
	}

	public GroundPlan() {

	}

	public static void main(String[] args) {
		ResourcesLocator.getInstance().parseIniFile("resources.ini");
		JoglAppLauncher appLauncher = JoglAppLauncher.getInstance();
		GroundPlan plan = new GroundPlan();
		appLauncher.create(plan);
		appLauncher.setRenderSystem(RenderSystem.JOGL);
		appLauncher.setUiSystem(UI.JOGL_SWING);

		plan.run();
	}

}
