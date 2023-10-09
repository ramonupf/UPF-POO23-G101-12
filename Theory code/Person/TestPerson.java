
class TestPerson {

	// main method (always this exact syntax
    public static void main(String[] args) {
    	// create an instance of Person
        Person p1 = new Person("John", 20, 1.82F, 65.2F, 0);
        
        // call methods to test program
        p1.celebrateBirthday();
        System.out.println(p1.getAge());

        p1.setAge(55);
    }
}
