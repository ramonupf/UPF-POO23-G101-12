public class Main {
    //this main class checks that the main methods of lab3 work. 
    public static void main(String[] args) {
        Country usa = new Country("USA");
        Country brazil = new Country("Brazil");

        // Create players
        Player player1 = new Player(false, "John", 25, usa);
        Player player2 = new Player(false, "Maria", 28, brazil);
        Player player3 = new Player(false, "David", 22, usa);

        // Create teams
        Team team1 = new Team("Team USA", usa, Gender.MALE);
        Team team2 = new Team("Team Brazil", brazil, Gender.MALE);

        // Add players to teams
        team1.addPlayer(player1);
        team1.addPlayer(player3);
        team2.addPlayer(player2);

        // Print player and team stats
        player1.printStats();
        player2.printStats();
        player3.printStats();

        team1.printStats();
        team2.printStats();

        Team team3 = new Team("Team 3", brazil, Gender.MALE);
        Team team4 = new Team("Team 4", brazil, Gender.MALE);
        Team team5 = new Team("Team 5", brazil, Gender.MALE);
        Team team6 = new Team("Team 6", usa, Gender.MALE);

        team3.addPlayer(player1);
        team3.addPlayer(player3);
        team4.addPlayer(player2);
        team5.addPlayer(player2);
        team6.addPlayer(player2);
        
        Competition competition = new Competition("Test Competition", usa, Gender.MALE, true);

        // Add teams to the competition
        competition.addTeam(team1);
        competition.addTeam(team2);
        competition.addTeam(team3);
        competition.addTeam(team4);

        // Generate matches
        competition.generateMatches();

        // Simulate matches
        competition.simulateMatches();

        // Print teams and matches
        competition.printTeams();
        //competition.printMatches();

        // Create a Cup competition
        Cup cupCompetition = new Cup("Cup Competition", brazil, Gender.FEMALE, true);

        // Add teams to the Cup competition
        cupCompetition.addTeam(team1);
        cupCompetition.addTeam(team2);
        cupCompetition.addTeam(team3);
        cupCompetition.addTeam(team4);
        cupCompetition.addTeam(team5);

        // Generate Cup matches
        cupCompetition.generateMatches();

        // Simulate Cup matches
        cupCompetition.simulateMatches();

        // Print teams and matches for the Cup competition
        cupCompetition.printTeams();
        cupCompetition.printMatches();
    

    
        // Create a Group play competition
        GroupPlay groupPlayCompetition = new GroupPlay("Group Play Competition", brazil, Gender.FEMALE, true);

        // Add teams to the Group play competition
        groupPlayCompetition.addTeam(team1);
        groupPlayCompetition.addTeam(team2);
        groupPlayCompetition.addTeam(team3);
        groupPlayCompetition.addTeam(team4);
        groupPlayCompetition.addTeam(team5);
        groupPlayCompetition.addTeam(team6);
        groupPlayCompetition.addTeam(team6);
        groupPlayCompetition.addTeam(team6);
        groupPlayCompetition.addTeam(team6);
        groupPlayCompetition.addTeam(team6);
        groupPlayCompetition.addTeam(team6);


        // Generate Cup matches
        groupPlayCompetition.generateMatches();

        // Simulate Cup matches
        groupPlayCompetition.simulateMatches();

        // Print teams and matches for the Cup competition
        groupPlayCompetition.printTeams();
        groupPlayCompetition.printMatches();

    
    }

}


/*
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        //create list of teams from csv
        //create list of countries from csv
        //create list of players from csv
        //create list of competitions from csv

        League premierLeague = leagueFromCSV("Premier League","England",Gender.MALE);
        premierLeague.generateMatches();
        premierLeague.simulateMatches();
        premierLeague.printMatches(); //PRINTS ALL MATCHES IN LEAGUE
        premierLeague.printTeams(); //PRINTS ALL TEAMS IN LEAGUE

        //EXAMPLE
        System.out.println("-----------------");
        int teamExample = 9;
        System.out.println("STATS OF TEAM "+premierLeague.getTeams().get(teamExample).getName());
        for(int i=0;i<premierLeague.getTeams().get(teamExample).getPlayers().size();i++){
            premierLeague.getTeams().get(5).getPlayers().get(i).printStats();
        }
        
        System.out.println();
        //EXAMPLE
        teamExample = 7;
        premierLeague.getTeams().get(teamExample).printStats();
        

        //Check methods
        Country spainCountry = new Country("Spain");
        Country franceCountry = new Country("France");
        System.out.println(spainCountry.equals(franceCountry));

        Team spain = new NationalTeam("Spain National Team", spainCountry, Gender.MALE);
        Player newPlayer1 = new Player(false, "Fery", 19, spainCountry);
        Player newPlayer2 = new Player(false, "Ramon", 19, franceCountry);
        spain.addPlayer(newPlayer1);
        spain.addPlayer(newPlayer2);
        
    }

    private static Competition leagueFromCSV(String leagueName, String countryName, Gender leagueGender){
        LinkedList<Team> teams = new LinkedList<>();
        Competition league = null;
        try {
            File file = new File(leagueName+".csv");
            Scanner scanner = new Scanner(file);
            //Skip the first row (header) containing column names
            if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                System.out.println(data[0]);

                if (league == null) {
                    // Create the league
                    league = new Competition(leagueName, new Country(countryName), leagueGender);
                    System.out.println("Created League: " + league.getName());
                }

                if (!data[5].equals("Team Name")) {
                    // Check if the team already exists in the list
                    Team existingTeam = findTeamByName(teams, data[5]);
                    if (existingTeam != null) {
                        //Team with the same name already exists, use it
                        //Add players to the existing team
                        boolean isFemale = Gender.valueOf(data[7]) == Gender.FEMALE;
                        Player player = new Player(isFemale, data[0], Integer.valueOf(data[1]), new Country(data[6]));
                        existingTeam.addPlayer(player);
                    } else {
                        //Create a new team
                        Team team = new Team(data[5], new Country(data[6]), Gender.valueOf(data[7]));
                        teams.add(team);
                        System.out.println("Created Team: " + team.getName());
                        // Add players to the new team
                        boolean isFemale = Gender.valueOf(data[7]) == Gender.FEMALE;
                        Player player = new Player(isFemale, data[0], Integer.valueOf(data[1]), new Country(data[6]));
                        team.addPlayer(player);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Add teams to the league
        for (Team team : teams) {
            league.addTeam(team);
            System.out.println("Added Team"+ team.getName()+" to "+ league.getName());
        }

        return league;
    }

    private static Team findTeamByName(LinkedList<Team> teams, String name) {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        return null;
    }

    private static Country findCountryByName(LinkedList<Country> countries, String name) {
        for (Country country : countries) {
            if (country.getName().equals(name)) {
                return country;
            }
        }
        return null;
    }

}

*/