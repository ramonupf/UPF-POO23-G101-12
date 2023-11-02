
// Doctor: a class that *inherits* from Person
// All instance members (attributes and methods) are inherited

public class Doctor extends Person {
    private int noPatients;

    public Doctor(String n, int a, int p) {
    	// super refers to the constructor of Person
        super(n, a);
        
        noPatients = p;
    }
    
    // override method getName from Person
    @Override
    public String getName() {
    	// keyword super allows calling getName in Person
        return "Dr. " + super.getName();
    }

    public int getNoPatients() {
        return noPatients;
    }
}
