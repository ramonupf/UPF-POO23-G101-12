
#include "Student.hpp"

int main() {
	// creating an instance using "new" returns a *pointer*
    Student * s1 = new Student("John", 20, 4);
    
    // to call methods on a pointer variable, use "->"
    std::cout << s1->getName() << "\n";
    std::cout << s1->getAge() << "\n";
    std::cout << s1->getNoCourses() << "\n";

	// we can also create an instance using direct initialization
    Student s2("Mary", 18, 5);
    
    // to call methods on a direct variable, use "."
    std::cout << s2.getName() << "\n";
    std::cout << s2.getAge() << "\n";
    std::cout << s2.getNoCourses() << "\n";
}
