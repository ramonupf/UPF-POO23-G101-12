
#include "Person.hpp"

// A class that illustrates inheritance in C++

class Student : public Person {

protected:

	int noCourses;

public:

	// note how to call the constructor of Person
    Student(std::string n, int a, int c) : Person(n, a) {
         noCourses = c;
    }

    int getNoCourses() {
        return noCourses;
    }

}; // note the semicolon
