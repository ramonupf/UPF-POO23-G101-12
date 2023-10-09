
public class Person { // class header

	// attributes, normally private visibility
    private String name;
    private int age;
    private float height;
    private float weight;
    private int gender;

	// constructor, omits "void"
    public Person(String initName, int initAge,
                  float initHeight, float initWeight,
                  int initGender) {
        name = initName;
        age = initAge;
        height = initHeight;
        weight = initWeight;
        gender = initGender;
    }

	// getter method for returning the age
    public int getAge() {
        return age;
    }
    
    // setter method for changing the age
    public void setAge(int newAge) {
    	age = newAge;
    }

	// celebrate birthday (increments age)
    public void celebrateBirthday() {
        age++;
    }
}
