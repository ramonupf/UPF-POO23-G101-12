# Soccer Match Simulation Program Documentation

## Introduction

The program simulates soccer matches using object-oriented programming in C++. Apart from the provided complete classes, we have written the code for `Player`, `Goalkeeper`, `Outfielder`, and a `main` function that demonstrates the simulation. The `Player` class serves as the base for representing soccer players, while `Goalkeeper` and `Outfielder` are subclasses derived from the abstract class `Player`.

## Class Descriptions and Methods

### Player Class
The base class for all player types in the simulation.

- **Constructor (`Player(bool g, string n, int a, Country * nat)`)**: Initializes a player with gender, name, age, and nationality.
- **isFemale()**: Returns a boolean to indicate the gender of the player.
- **getName()**: Returns the player's name.
- **getAge()**: Returns the player's age.
- **getCountry()**: Obtains the player's nationality. Returns a Country pointer.
- **getNoMatches()**: Returns the number of matches the player has participated in.
- **updateStats(Match * m)**: A pure virtual function, each derived class must implement this method to update the player's statistics based on a match.
- **printStats()**: A pure virtual function, each derived class must implement this method to print the player's statistics.

### Goalkeeper Class
Derived from `Player`, it adds attributes and methods specific to a goalkeeper.

- **Constructor (`Goalkeeper(bool g, string n, int a, Country * nat)`)**: Calls the base class constructor and initializes noSaves and noGoalsLet to zero.
- **getNoSaves()** and **getNoGoalsLet()**: Returns the number of saves and goals let by the goalkeeper, respectively.
- **updateStats(Match * m)**: Updates the goalkeeper's statistics based on the match's outcome. It increments the number of matches played and adjusts the `noGoalsLet` based on whether the goalkeeper's team is `teamOne` or `teamTwo` in the match.
- **printStats()**: Prints out the goalkeeper's statistics, including saves, goals let, and other inherited attributes.

### Outfielder Class
Also derived from `Player`, it focuses on attributes and methods relevant to outfield players.

- **Constructor (`Outfielder(bool g, string n, int a, Country * nat)`)**: Initializes specific statistics like `noTackles`, `noPasses`, `noShots`, `noAssists`, and `noGoals` to zero.
- **Getters for Statistics**: Methods like `getNoTackles()`, `getNoPasses()`, `getNoShots()`, `getNoAssists()`, and `getNoGoals()` provide access to individual statistics.
- **updateStats(Match * m)**: Updates the outfielder's statistics based on their performance in the match. It checks whether the outfielder has scored any goals in the match and updates `noGoals` accordingly.
- **printStats()**: Outputs the detailed statistics of the outfielder, including goals, passes, assists, shots, and tackles.

### Main Function
In the `main` function, these classes are instantiated and used to simulate a soccer match. Players are created and assigned to teams, and a match is simulated between these teams. After the match, the `updateStats` method of each player is called to reflect their performance in the match, and their statistics are printed using `printStats`.

## Conclusion
The chosen design effectively demonstrates object-oriented programming principles. The `Player` class provides a foundational abstract class for soccer players, which is then extended by `Goalkeeper` and `Outfielder` classes to implement specific roles. This ensures code reusability and scalability. The `main` function showcases the practical use of these classes. Each class is designed to encapsulate relevant data and behaviors, with clear interfaces and implementation of polymorphism.