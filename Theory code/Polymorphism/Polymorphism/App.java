public class App {
    public static void main(String[] args) throws Exception {
    	// create an instance of Student
        Student s1 = new Student("Mary", 18, 4);
        
        // upcast: store instance of Student in variable of type Person
        Person p1 = s1;
        
        // polymorphism calls version of getName in Student
        System.out.println(p1.getName());

		// cannot store instance of superclass in variable of subclass!
		//Student s2 = new Person("Andy", 30);

		// can do upcast on the same line that the instance is created
        Person p2 = new Doctor("Olga", 35, 42);
        
        // polymorphism calls version of getName in Doctor
        System.out.println(p2.getName());

		// to access methods of the Student class, need *downcast*
		// can fail if the instance is *not* of type Student
		// can use "instanceof" to check if downcast is safe
        if (p1 instanceof Student) {
        	// downcast: write the name of the subclass in parentheses
            Student s3 = (Student)p1;
            System.out.println(s3.getNoCourses());
        }

		// treat many instances as if they had the same type Person
        Person[] persons = new Person[5];
        persons[0] = new Doctor("A", 36, 1);
        persons[1] = new Student("B", 20, 2);
        persons[2] = new Doctor("C", 37, 3);
        persons[3] = new Student("D", 21, 4);
        persons[4] = new Doctor("E", 38, 5);
 
 		// printing the name of all instances is extremely easy
        // due to polymorphism, each name is printed in a different way!
        for (int i = 0; i < 5; ++i)
            System.out.println(persons[i].getName());
    }
}
