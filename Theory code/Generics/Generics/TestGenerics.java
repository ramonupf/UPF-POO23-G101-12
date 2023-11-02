
public class TestGenerics {
    public static void main(String[] args) throws Exception {
    	// To create an instance of "GenericsClass", we have to
    	//   instantiate the generic type with a *concrete* type
    
    	// Generic type instantiated with "String"
        GenericsClass<String> myvar;
        myvar = new GenericsClass<String>("Hello");
        System.out.println(myvar.getAttr());

		// Generic type instantiated with "Integer"
        GenericsClass<Integer> othervar;
        othervar = new GenericsClass<Integer>(Integer.valueOf(5));
        System.out.println(othervar.getAttr());
    }    
}
