
#include <iostream>

// A simple class in C++

class Person {

// visibility works by blocks

protected:

	// all instance members in this block are protected

	// in C++, strings have type "std::string"
    std::string name;
    int age;

public:

	// all instance members in this block are public

    Person(std::string n, int a) {
        name = n;
        age = a;
    }

    std::string getName() {
        return name;
    }

    int getAge() {
        return age;
    }

}; // note the semicolon
