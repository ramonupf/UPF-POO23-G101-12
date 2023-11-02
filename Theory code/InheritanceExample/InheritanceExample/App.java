public class App {
    public static void main(String[] args) throws Exception {
    	// create an instance of the Student class
        Student s = new Student("John", 20, 5);
        
        // we can call methods in the student class
        System.out.println(s.getNoCourses());
        
        // we can also call methods inherited from Person
        System.out.println(s.getName());
        System.out.println(s.getAge());
        
        // we can also call methods inherited from Object
        System.out.println(s.toString());

		// apparently static members are also "inherited"
        System.out.println(Person.MAXAGE);
        System.out.println(Student.MAXAGE);
    }
}
