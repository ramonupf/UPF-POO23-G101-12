
// InheritanceCircle: reuses the Ellipse class using *inheritance*

public class InheritanceCircle extends Ellipse {

    public InheritanceCircle(double radius) {
    	// call the constructor of Ellipse with xAxis = yAxis = radius
        super(radius, radius);
    }
    
    // methods for computing the area and circumference are inherited!
}
