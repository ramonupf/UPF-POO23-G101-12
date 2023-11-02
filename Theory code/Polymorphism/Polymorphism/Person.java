
// Person: a simple class representing persons

// If no superclass is specified, by default the superclass is Object!
public class Person {

	// private attributes are *not* visible in subclasses
	// protected attributes *are* visible in subclasses
    protected String name;
    protected int age;
    
    // a static constant
    public static final int MAXAGE = 130;

    public Person(String n, int a) {
    	// if super is not called, by default the call super() is added
        super();
        
        name = n;
        age = a;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
