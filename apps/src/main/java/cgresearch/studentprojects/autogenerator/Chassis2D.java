package cgresearch.studentprojects.autogenerator;

import java.util.ArrayList;
import java.util.List;

import cgresearch.core.math.Vector;
import cgresearch.core.math.VectorMatrixFactory;
import cgresearch.graphics.datastructures.curves.BezierCurve;
import cgresearch.graphics.datastructures.primitives.Line3D;

public class Chassis2D {
	
	private final int carVektor = 28;

	private Vector center;

	private Vector A;
	private Vector B;
	private Vector C;
	private Vector D;

	private Line3D AB;
	private Line3D BC;
	private Line3D CD;
	private Line3D DA;

	private BezierCurve left;
	private BezierCurve top;
	private BezierCurve right;
	private BezierCurve bottom;

	private double hoehe;
	private double laenge;

	private int degree;

	private Line3D[] lines = new Line3D[4];
	private List<BezierCurve> curves = new ArrayList<BezierCurve>();

	public Chassis2D(Vector center, double hoehe, double laenge, int degree,
			int chassisv, int chassish) {
		setCenter(center);
		setA(center, hoehe, laenge);
		setB(center, hoehe, laenge);
		setC(center, hoehe, laenge);
		setD(center, hoehe, laenge);
		setAB();
		setBC();
		setCD();
		setDA();
		setHoehe(hoehe);
		setLaenge(laenge);
		setLines();
		setDegree(degree);
		setLeft(chassisv, A, B);
		// setTop(B, C);
		setRight(chassish, C, D);
		setBottom(chassisv, chassish, D, A);
		setCurves(left, right, bottom);
	}

	public Vector getCenter() {
		return center;
	}

	public void setCenter(Vector center) {
		this.center = center;
	}

	public Vector getA() {
		return A;
	}

	public void setA(Vector center, double hoehe, double laenge) {
		double x = center.get(0) - laenge / 2;
		double y = center.get(1) - hoehe / 2;
		A = VectorMatrixFactory.newVector(x, y, 0);
	}

	public Vector getB() {
		return B;
	}

	public void setB(Vector center, double hoehe, double laenge) {
		double x = center.get(0) - laenge / 2;
		double y = center.get(1) + hoehe / 2;
		B = VectorMatrixFactory.newVector(x, y, 0);
	}

	public Vector getC() {
		return C;
	}

	public void setC(Vector center, double hoehe, double laenge) {
		double x = center.get(0) + laenge / 2;
		double y = center.get(1) + hoehe / 2;
		C = VectorMatrixFactory.newVector(x, y, 0);
	}

	public Vector getD() {
		return D;
	}

	public void setD(Vector center, double hoehe, double laenge) {
		double x = center.get(0) + laenge / 2;
		double y = center.get(1) - hoehe / 2;
		D = VectorMatrixFactory.newVector(x, y, 0);
	}

	public Line3D getAB() {
		return AB;
	}

	public void setAB() {
		AB = new Line3D(this.A, this.B);
	}

	public Line3D getBC() {
		return BC;
	}

	public void setBC() {
		BC = new Line3D(this.B, this.C);
		;
	}

	public Line3D getCD() {
		return CD;
	}

	public void setCD() {
		CD = new Line3D(this.C, this.D);
		;
	}

	public Line3D getDA() {
		return DA;
	}

	public void setDA() {
		DA = new Line3D(this.D, this.A);
	}

	public BezierCurve getLeft() {
		return left;
	}

	public void setLeft(int chassisv, Vector... points) {

		double x = this.laenge * chassisv / 100;

		BezierCurve curve = new BezierCurve(degree);

		curve.setControlPoint(
				0,
				VectorMatrixFactory.newVector(points[0].get(0) + x,
						points[0].get(1), 0));

		// for (int i = 1; i < degree; i++) {
		// curve.setControlPoint(i, VectorMatrixFactory.newVector(x + i * xx,
		// y + i*yy, 0));
		// }

		// curve.setControlPoint(1, VectorMatrixFactory.newVector(
		// points[1].get(0) - 0.2, points[1].get(1) - 0.4, 0));
		//
		// curve.setControlPoint(
		// 2,
		// VectorMatrixFactory.newVector(points[1].get(0),
		// points[1].get(1) - 0.2, 0));

		curve.setControlPoint(
				1,
				VectorMatrixFactory.newVector(points[0].get(0),
						points[0].get(1), 0));

		curve.setControlPoint(
				2,
				VectorMatrixFactory.newVector(points[1].get(0),
						points[1].get(1), 0));

		this.left = curve;
	}

	public BezierCurve getTop() {
		return top;
	}

	public void setTop(Vector... points) {
		int degree = points.length - 1;
		int i = 0;
		BezierCurve curve = new BezierCurve(degree);
		for (Vector p : points) {
			curve.setControlPoint(
					i,
					VectorMatrixFactory.newVector(p.get(0), p.get(1),
							p.get(2)));
			i++;
		}
		this.top = curve;
	}

	public BezierCurve getRight() {
		return right;
	}

	public void setRight(int chassish, Vector... points) {

		double x = this.laenge * chassish / 100;

		BezierCurve curve = new BezierCurve(degree);

		curve.setControlPoint(
				0,
				VectorMatrixFactory.newVector(points[0].get(0),
						points[0].get(1), 0));

		// for (int i = 1; i < degree; i++) {
		// curve.setControlPoint(i, VectorMatrixFactory.newVector(x + i * xx,
		// y + i*yy, 0));
		// }

		// curve.setControlPoint(1, VectorMatrixFactory.newVector(
		// points[1].get(0) - 0.2, points[1].get(1) - 0.4, 0));
		//
		// curve.setControlPoint(
		// 2,
		// VectorMatrixFactory.newVector(points[1].get(0),
		// points[1].get(1) - 0.2, 0));

		curve.setControlPoint(
				1,
				VectorMatrixFactory.newVector(points[1].get(0),
						points[1].get(1), 0));

		curve.setControlPoint(
				2,
				VectorMatrixFactory.newVector(points[1].get(0) - x,
						points[1].get(1), 0));

		this.right = curve;
	}

	public BezierCurve getBottom() {
		return bottom;
	}

	public void setBottom(int chassisv, int chassish, Vector... points) {

		double x1 = this.laenge * chassish / 100;
		double x2 = this.laenge * chassisv / 100;

		BezierCurve curve = new BezierCurve(1);

		curve.setControlPoint(0, VectorMatrixFactory.newVector(
				points[0].get(0) - x1, points[0].get(1), 0));

		// for (int i = 1; i < degree; i++) {
		// curve.setControlPoint(i, VectorMatrixFactory.newVector(x + i * xx,
		// y + i*yy, 0));
		// }

		// curve.setControlPoint(1, VectorMatrixFactory.newVector(
		// points[1].get(0) - 0.2, points[1].get(1) - 0.4, 0));
		//
		// curve.setControlPoint(
		// 2,
		// VectorMatrixFactory.newVector(points[1].get(0),
		// points[1].get(1) - 0.2, 0));

		curve.setControlPoint(1, VectorMatrixFactory.newVector(
				points[1].get(0) + x2, points[1].get(1), 0));

		this.bottom = curve;
	}

	public double getHoehe() {
		return hoehe;
	}

	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}

	public double getLaenge() {
		return laenge;
	}

	public void setLaenge(double laenge) {
		this.laenge = laenge;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public Line3D[] getLines() {
		return lines;
	}

	public void setLines() {
		this.lines[0] = AB;
		this.lines[1] = BC;
		this.lines[2] = CD;
		this.lines[3] = DA;
	}

	public List<BezierCurve> getCurves() {
		return curves;
	}

	public void setCurves(BezierCurve... curves) {
		for (BezierCurve c : curves) {
			this.curves.add(c);
		}
	}

}
