**Inheritance think:** “A student is a person”

**POLYMORPHISM**
``` java
Person p = new Student("Mary", 18, 4)
System.out.println(p.getName());
```

**POLYMORPHIC VARIABLE**

- **Declared type:** type given in declaration
- Instantiated type: type of instance stored
	Instantiated type must be <u>subclass</u> of declared type


**Overwriting**: taking the same method and implementing in also in the subclass

``` java
//method in class Person
public String getName(){´
	return name;
	}
```

```java
//method in class Doctor -> extends Person
public String getName(){
	return "Dr. " + name;
}
```


![[oop t6 doctor class.drawio 2.png]]

<u>Strength of polymorphism:</u> I can treat many instances of subclasses of the same 
class and store them together in the same array
```java

Person[] persons = new Person[5]
person[0] = new Doctor ("X", 1, 2)
person[1] = new Student ("Y", 3, 4)
```

***POLYMORPHISM* = *polymorphic variable + overwriting***

- **<u>Overloading:</u>** different methods with the <u>same</u> name but different args
- ****<u>Shadowing:</u>** creating different attributes with the same name

------

BREAK

------


JAVA KEYWORDS
- **super**: allows access to the superclass or parent class of an object
- **final:** cannot overwrite
	 - putting it in a class header makes it that no other class can inherit from it



- **Casting:** take instance store in a variable *u* and store in another variable *v* with a different <u>declared type</u>

```java
Student s3 = new Student("Mary", )
Person p = s3;
System.out.println.(p.getName());
```

| | Declared| Instantiated |  
| -------- | -------- | -------- |  
|s3 |Student | Student|  
| p| Person| |

- **Upcasting:** typecasting a child object *u* to a parent object
- **Downcasting:** the type of <u>v</u> is a subclass of the type *u*
example:
```c
//in c you would do something like
float f = 1.35;
int c = (int)f;
```

```java
Student s4 = (Student)p2;
System.out.println(s4.getNoCourses());
```

JAVA KEYWORD
- **instanceof**

-----------------
# CLASS EXAMPLES

```java
ExampleClass e1 = new ExampleClass(1);
ExampleClass e2 = new ExampleClass(1);
System.out.println(e1 == e2); //prints "false"
```

why?
![[e1 e2 equal.drawio.png]]

e1 and e2 both contain "1" but they are different locations in memory