public class App {
    public static void main(String[] args) throws Exception {
    	// create and test an instance of InheritanceCircle
        InheritanceCircle c1 = new InheritanceCircle(2);
        System.out.println(c1.getArea());
        System.out.println(c1.getCircumference());

    	// create and test an instance of AggregationCircle
        AggregationCircle c2 = new AggregationCircle(2);
        System.out.println(c2.getArea());
        System.out.println(c2.getCircumference());
    }
}
