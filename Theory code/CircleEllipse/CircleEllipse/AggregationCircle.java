
// AggregationCircle: reuses the Ellipse class using *aggregation*

public class AggregationCircle {

	// delegate all methods to an attribute of type Ellipse
    private Ellipse ellipse;

    public AggregationCircle(double radius) {
    	// initialize the ellipse using the given radius
        ellipse = new Ellipse(radius, radius);
    }

    public double getArea() {
    	// use the ellipse to compute the area
        return ellipse.getArea();
    }

    public double getCircumference() {
    	// use the ellipse to compute the circumference
        return ellipse.getCircumference();
    }
    
}

