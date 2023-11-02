public class App {
    public static void main(String[] args) throws Exception {
        ExampleClass e1 = new ExampleClass(1);
        ExampleClass e2 = new ExampleClass(1);
        
        // operator "==" compares memory addresses!
        System.out.println(e1 == e2);
        
        // method equals can be overridden to define what equality means
        System.out.println(e1.equals(e2));

		// create a vector with 5 elements
        MyVector vec = new MyVector(5);
        
        // can store any instance of any class in the vector
        vec.addElem("Hello");
        vec.addElem(e1);
        vec.addElem(Integer.valueOf(7));
        vec.addElem(new MyVector(8));
        vec.addElem(new java.util.LinkedList<String>());
        
        // check if the vector contains some instances
        // classes that override "equals" define equality in their own way
        System.out.println(vec.contains("Bye"));
        System.out.println(vec.contains("Hello"));
        System.out.println(vec.contains(e2));
        System.out.println(vec.contains(Integer.valueOf(4)));
        System.out.println(vec.contains(Integer.valueOf(7)));
    }
}
