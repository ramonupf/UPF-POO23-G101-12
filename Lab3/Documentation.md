# Object-Oriented Programming Project Report

## Introduction

The problem in this **LAB 3** is to develop a Java program that simulates a sports league. A part from the classes defined during the lasts two labs, we now implemented the new subclasses of player, `outfielder` and `goalkeeper` and we changed `League` into `Competition`, which is now a superclass from which `GroupPlay` and `Cup` extend.


### Relevant Classes of Lab 3:

**Competition**: A base class for different types of football competitions. It provides foundational attributes and methods applicable to all competition types.

**Cup, GroupPlay, and League**: These classes extend the Competition class to simulate specific types of football competitions. The Cup class is designed for eliminatory tournaments, while the League class behaves as in Lab 2. The group play consists of subleagues. We have decided to set to 4 the number of teams in each group and have designed an algorithm to build such groups.

**Match and CupMatch**: The Match class simulates individual football matches. The CupMatch class extends Match to incorporate specific rules and structures unique to cup competitions.

**Player, Goalkeeper, and Outfielder**: The Player class is an abstract class (although we didn't declare it as abstract because it wasn't stated in the UML) that defines general attributes and behaviors of a football player. The Goalkeeper and Outfielder classes are specialized extensions of Player, tailored to represent specific player roles on the field.

**NationalTeam**: This class represents national football teams.

## Solution
Inheritance is used to create specific player types (like Goalkeeper and Outfielder) and competition formats (Cup and League), deriving from more general classes.

Polymorphism allows for uniform handling of different types of competitions and matches, enabling the program to manage various competition formats.

Encapsulation ensures that the internal workings of each class are not exposed unnecessarily, maintaining a clear separation of concerns. In this case, we had to define some attributes as `protected` in order for the subclasses of a superclass to inherit them.

Abstraction allows the program to define generic templates for entities like players and competitions, which are then specialized in subclasses. We believe that the `Competition` class could be abstract, although we haven't coded it like this because it was not like this in the UML.
 
## Conclusion

In this Lab 3 we have succesfully implemented the new subclasses and as of now, we are postponing the .csv file reading implementation in the Main class and we decided to chek only the most relevant methods implemented in this specific Lab. In the next lab we will try to fix the csv reading algorithm in order to have a solid program.

## Relevant things we have learned in this lab:
- **Iterator**: We discovered this kind of object and it was very useful to build the groupplay groups out of the list of teams.
- **equals()**: we used it in the country class in order to compare between instances of country.
- **addAll**: we discovered this method while .
- **Cup Class Algorithms**: this was the most time-consuming part of the lab, but we had the chance to practice and think a lot about programming.
- **VSCode Debugging**: while working on the algorithms and checking their implementation with the main, we had the chance to try the debugging mode of vscode. It was really helpful.
