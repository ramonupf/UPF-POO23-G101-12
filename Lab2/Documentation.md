# Object-Oriented Programming Project Report

## Introduction

The problem in this **LAB 2** is to develop a Java program that simulates a sports league. The program should be capable of creating and managing teams, players, and matches. The main functionality includes adding and removing players from teams, simulating matches, and updating statistics for both teams and players. This program focuses on object-oriented programming principles, involving classes like `Team`, `Match`, `Player`, and `League`, each with specific methods and attributes.

### Classes and Methods:

1. **Team Class**
   - `addPlayer(Player p)`: Adds a player to the team based on gender compatibility.
   - `removePlayer(Player p)`: Removes a player from the team.
   - `updateStats(Match match)`: Updates team statistics after a match.
   - `playMatch(int forGoals, int againstGoals)`: Updates match results and statistics.
   - `printStats()`: Prints the team's statistics.

2. **Match Class**
   - `simulateMatch()`: Simulates a match, generating random goals and scorers.
   - `addRandomScorers(int goals, boolean home)`: Adds random scorers to home or away team.
   - `printMatch()`: Prints match details, including scorers.

3. **Player Class**
   - `updateStats(Match match)`: Updates player statistics based on match results.
   - `update(int t, int p, int s, int a, int g)`: Updates player's statistics.
   - `printStats()`: Prints player's statistics.

4. **League Class**
   - `addTeam(Team t)`: Adds a team to the league.
   - `generateMatches()`: Generates matches between teams in the league.
   - `simulateMatches()`: Simulates all matches in the league and updates statistics.
   - `printTeams()`: Prints the list of teams in the league.
   - `printMatches()`: Prints the results of all matches in the league.
   - `leagueFromCSV(String leagueName, String countryName, Gender leagueGender)`: Reads data from a CSV file to create the league, teams, and players. 

## Alternative Solutions and Chosen Solution

There are multiple ways to implement this sports league simulation, but the chosen solution emphasizes object-oriented programming (OOP) principles. The program uses encapsulation, but it still doesn't implement concepts such as inheritance or polymorphism. Future labs will focus into this in order to create a flexible and extensible structure. 

A solution we have chosen for testing our main program is using .csv files that contain all the data. Each csv file corresponds to a league and we created a method in League class that creates an instance of League with all its attributes. This way we can make sure that all code works as expected. In fact, this allowed us to identify some bugs of the program, such as the fact that match stats were only being updated when the team was playing at home

The decision to use the OOP approach is based on the following reasons:

1. **Modularity**: OOP promotes modularity, making it easier to manage and extend the codebase. Each class is responsible for a specific aspect of the program, such as teams, players, matches, and leagues.

2. **Reusability**: OOP enables code reuse through inheritance. For example, the `Player` class can serve as a base class for different types of players, allowing for common statistics tracking.

3. **Flexibility**: OOP allows for easy extension of the program. We  can add new features, classes, or behaviors without significantly affecting existing code.

4. **Readability**: The OOP approach promotes clean and readable code. Each class encapsulates its behavior, making it easy to understand and maintain.

5. **Polymorphism**: The code uses polymorphism to update player statistics based on the match results, which demonstrates a core OOP concept.

## Conclusion

The solution successfully implements a sports league simulation using object-oriented programming principles. The classes are well-structured, and the program performs as expected, handling tasks such as team and player management, match simulation, and statistics updates. However, there might be some room for improvements, such as handling exceptions and input validation. Additionally, further testing and refinement may be required for real-world scenarios, but the chosen OOP approach lays a solid foundation for such enhancements.

## Source of data

We obtained the data of players and teams from https://footystats.org/es/download-stats-csv