
public class ExampleClass {

    private int attr;
    
    public ExampleClass(int a) {
        attr = a;
    }
    
    public int getAttr() {
        return attr;
    }
    
    // override method "equals" from Object
    // indicate what it means for an instance of ExampleClass
    //   to be equal to another instance
    @Override
    public boolean equals(Object o) {
    	// check if the other instance is also of type ExampleClass
        if (o instanceof ExampleClass) {
        	// if so, check if the attribute is equal
            ExampleClass e = (ExampleClass)o;
            return attr == e.attr;
        }
        // else return false
        return false;
    }
}
