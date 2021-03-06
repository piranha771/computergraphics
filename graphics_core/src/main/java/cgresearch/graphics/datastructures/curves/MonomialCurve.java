/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package cgresearch.graphics.datastructures.curves;

import cgresearch.core.math.Vector;
import cgresearch.core.math.VectorFactory;

/**
 * Implementation of a monomial curve of arbitrary degree.
 * 
 * @author Philipp Jenke
 * 
 */
public class MonomialCurve extends ICurve {

    /**
     * Constructor.
     * 
     * @param degree
     *            Degree of the polynomial
     */
    public MonomialCurve(int degree) {
        init(degree);
    }

    /**
     * Initialize the curve to a given degree.
     * 
     * @param degree
     *            Degree of the curve.
     */
    private void init(int degree) {
        controlPoints = new Vector[degree + 1];
    }

    /**
     * Constructor.
     * 
     * @param p0
     *            First control point.
     * @param p1
     *            Second control point.
     * @param p2
     *            Third control point.
     * @param p3
     *            Forth control point.
     */
    public MonomialCurve(Vector p0, Vector p1, Vector p2, Vector p3) {
        controlPoints = new Vector[4];
        controlPoints[0] = p0;
        controlPoints[1] = p1;
        controlPoints[2] = p2;
        controlPoints[3] = p3;
    }

    /*
     * (nicht-Javadoc)
     * 
     * @see edu.cg1.exercises.curves.ICurve#eval(double)
     */
    @Override
    public Vector eval(double t) {
        Vector result = VectorFactory.createVector3(0, 0, 0);
        for (int i = 0; i < getDegree() + 1; i++) {
            result = result.add(controlPoints[i].multiply(Math.pow(t, i)));
        }
        return result;
    }

    /*
     * (nicht-Javadoc)
     * 
     * @see edu.cg1.exercises.curves.ICurve#derivative(double)
     */
    @Override
    public Vector derivative(double t) {
        Vector result = VectorFactory.createVector3(0, 0, 0);
        for (int i = 1; i < getDegree() + 1; i++) {
            result = result.add(controlPoints[i].multiply(Math.pow(t, i - 1)
                    * i));
        }
        return result;
    }

    /**
     * Create polynomial of degree 1 to interpolate p0 at parameter value 0 and
     * p1 at parameter value 1.
     */
    public static MonomialCurve interpolate(Vector p0, Vector p1) {

        MonomialCurve curve = new MonomialCurve(1);
        Vector c0 = VectorFactory.createVector(p0);
        Vector c1 = p1.subtract(p0);
        curve.setControlPoint(0, c0);
        curve.setControlPoint(1, c1);
        return curve;
    }

    /**
     * Create polynomial of degree 1 to interpolate p0 at parameter value .00,
     * p1 at parameter value 0.5 and p2 at parameter value 1.0.
     */
    public static MonomialCurve interpolate(Vector p0, Vector p1,
            Vector p2) {
        MonomialCurve curve = new MonomialCurve(2);
        Vector c0 = VectorFactory.createVector(p0);
        Vector h1 = p1.subtract(p0);
        Vector h2 = p2.subtract(p0);
        Vector c1 = h1.multiply(4).add(h2.multiply(-1));
        Vector c2 = h1.multiply(-4).add(h2.multiply(2));
        curve.setControlPoint(0, c0);
        curve.setControlPoint(1, c1);
        curve.setControlPoint(2, c2);
        return curve;
    }
}
