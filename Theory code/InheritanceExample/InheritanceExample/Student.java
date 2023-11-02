
// Student: a class that *inherits* from Person
// All instance members (attributes and methods) are inherited

public class Student extends Person {
    private int noCourses;

    public Student(String n, int a, int c) {
    	// super refers to the constructor of Person
        super(n, a);
        
        noCourses = c;
    }

    public int getNoCourses() {
        return noCourses;
    }
}
