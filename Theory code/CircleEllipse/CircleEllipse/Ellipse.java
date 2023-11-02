
// Ellipse: a class for computing the area and circumference of ellipses

public class Ellipse {
    protected double xAxis;
    protected double yAxis;

    public Ellipse(double x, double y) {
        xAxis = x;
        yAxis = y;
    }

    public double getArea() {
        return Math.PI * xAxis * yAxis;
    }

    // getCircumference: approximates the circumference of an ellipse
    public double getCircumference() {
        double part = 10 * xAxis * yAxis + 3 * (xAxis * xAxis + yAxis * yAxis);
        return Math.PI * (3 * (xAxis + yAxis) - Math.sqrt(part));
    }
}
