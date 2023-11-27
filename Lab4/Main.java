public class Main {
    // This main class checks that the main methods of the application work.
    public static void main(String[] args) {
        // Creating countries
        Country usa = new Country("USA");
        Country brazil = new Country("Brazil");
        Country germany = new Country("Germany");
        Country japan = new Country("Japan");
        Country spain = new Country("Spain");

        // Creating players for USA
        Goalkeeper playerUSA1 = new Goalkeeper(false,"Alex", 25, usa);
        Outfielder playerUSA2 = new Outfielder(true,"Taylor", 22, usa);
        Outfielder playerUSA3 = new Outfielder(false,"Jordan", 24, usa);
        Outfielder playerUSA4 = new Outfielder(true,"Casey", 27, usa);
        Outfielder playerUSA5 = new Outfielder(false,"Jamie", 23, usa);

        // Creating players for Brazil
        Goalkeeper playerBrazil1 = new Goalkeeper(false,"Carlos", 26, brazil);
        Outfielder playerBrazil2 = new Outfielder(true, "Maria", 28, brazil);
        Outfielder playerBrazil3 = new Outfielder(false, "Pedro", 25, brazil);
        Outfielder playerBrazil4 = new Outfielder(true, "Fernanda", 23, brazil);
        Outfielder playerBrazil5 = new Outfielder(false,"Lucas", 24, brazil);

        // Creating players for Germany
        Goalkeeper playerGermany1 = new Goalkeeper(false, "Hans", 26, germany);
        Outfielder playerGermany2 = new Outfielder(true,"Greta", 27, germany);
        Outfielder playerGermany3 = new Outfielder(false,"Felix", 23, germany);
        Outfielder playerGermany4 = new Outfielder(true,"Sophia", 24, germany);
        Outfielder playerGermany5 = new Outfielder(false,"Karl", 25, germany);

        // Creating players for Japan
        Goalkeeper playerJapan1 = new Goalkeeper(false,"Yuto", 25, japan);
        Outfielder playerJapan2 = new Outfielder(true,"Sakura", 23, japan);
        Outfielder playerJapan3 = new Outfielder(false,"Kenji", 27, japan);
        Outfielder playerJapan4 = new Outfielder(true,"Aiko", 22, japan);
        Outfielder playerJapan5 = new Outfielder(false,"Daichi", 24, japan);

        // Creating players for Spain
        Goalkeeper playerSpain1 = new Goalkeeper(false,"Miguel", 24, spain);
        Outfielder playerSpain2 = new Outfielder(true,"Isabella", 26, spain);
        Outfielder playerSpain3 = new Outfielder(false,"Diego", 27, spain);
        Outfielder playerSpain4 = new Outfielder(true,"Luna", 22, spain);
        Outfielder playerSpain5 = new Outfielder(false,"Rafael", 25, spain);

        // Creating teams
        NationalTeam teamUSA = new NationalTeam("Team USA", usa, Gender.MALE);
        NationalTeam teamBrazil = new NationalTeam("Team Brazil", brazil, Gender.FEMALE);
        NationalTeam teamGermany = new NationalTeam("Team Germany", germany, Gender.MALE);
        NationalTeam teamJapan = new NationalTeam("Team Japan", japan, Gender.FEMALE);
        NationalTeam teamSpain = new NationalTeam("Team Spain", spain, Gender.MALE);

        // Adding players to teams
        teamUSA.addPlayer(playerUSA1);
        teamUSA.addPlayer(playerUSA2);
        teamUSA.addPlayer(playerUSA3);
        teamUSA.addPlayer(playerUSA4);
        teamUSA.addPlayer(playerUSA5);
        teamUSA.addPlayer(playerBrazil2);

        teamBrazil.addPlayer(playerBrazil1);
        teamBrazil.addPlayer(playerBrazil2);
        teamBrazil.addPlayer(playerBrazil3);
        teamBrazil.addPlayer(playerBrazil4);
        teamBrazil.addPlayer(playerBrazil5);

        teamGermany.addPlayer(playerGermany1);
        teamGermany.addPlayer(playerGermany2);
        teamGermany.addPlayer(playerGermany3);
        teamGermany.addPlayer(playerGermany4);
        teamGermany.addPlayer(playerGermany5);

        teamJapan.addPlayer(playerJapan1);
        teamJapan.addPlayer(playerJapan2);
        teamJapan.addPlayer(playerJapan3);
        teamJapan.addPlayer(playerJapan4);
        teamJapan.addPlayer(playerJapan5);

        teamSpain.addPlayer(playerSpain1);
        teamSpain.addPlayer(playerSpain2);
        teamSpain.addPlayer(playerSpain3);
        teamSpain.addPlayer(playerSpain4);
        teamSpain.addPlayer(playerSpain5);
        

        //competitions:
        League league = new League("International League", spain, Gender.MALE, false);
        Cup worldCup = new Cup("World Cup", spain, Gender.FEMALE,false);

        // Adding teams to competitions
        league.addTeam(teamUSA);
        league.addTeam(teamBrazil);
        league.addTeam(teamGermany);
        league.addTeam(teamJapan);
        league.addTeam(teamSpain);

        worldCup.addTeam(teamUSA);
        worldCup.addTeam(teamBrazil);
        worldCup.addTeam(teamGermany);
        worldCup.addTeam(teamJapan);
        worldCup.addTeam(teamSpain);

        // Simulating and displaying competition outcomes
        simulateAndDisplayCompetition(league);
        simulateAndDisplayCompetition(worldCup);

        //Printing individual player stats:
        playerUSA1.getStats(league).printStats();
        playerJapan4.getStats(worldCup).printStats();

    }

    private static void simulateAndDisplayCompetition(Competition competition) {
        if (competition instanceof League) {
            League league = (League) competition;
            league.generateMatches();
            league.simulateMatches();
            league.printTeams();
            league.printMatches();
            league.printTable();
            league.printGoalScorers(10);
        } else if (competition instanceof Cup) {
            Cup cup = (Cup) competition;
            cup.generateMatches();
            cup.simulateMatches();
            cup.printTeams();
            cup.printMatches();
            cup.printGoalScorers(10);
        }
    }
}
/*
public class Main {
    //this main class checks that the main methods of lab3 work. 
    public static void main(String[] args) {
        Country usa = new Country("USA");
        Country brazil = new Country("Brazil");

        // Create players
        Goalkeeper player1 = new Goalkeeper(false, "John", 25, usa);
        Outfielder player2 = new Outfielder(false, "Maria", 28, brazil);
        Outfielder player3 = new Outfielder(false, "David", 22, usa);

        // Create teams
        Team team1 = new Team("Team USA", usa, Gender.MALE);
        Team team2 = new Team("Team Brazil", brazil, Gender.MALE);

        // Add players to teams
        team1.addPlayer(player1);
        team1.addPlayer(player3);
        team2.addPlayer(player2);

        Team team3 = new Team("Team 3", brazil, Gender.MALE);
        Team team4 = new Team("Team 4", brazil, Gender.MALE);
        Team team5 = new Team("Team 5", brazil, Gender.MALE);
        Team team6 = new Team("Team 6", usa, Gender.MALE);

        team3.addPlayer(player1);
        team3.addPlayer(player3);
        team4.addPlayer(player2);
        team5.addPlayer(player2);
        team6.addPlayer(player2);
        
        League competition = new League("Test Competition", usa, Gender.MALE, true);


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
        player2.getStats(competition).printStats();
        player3.getStats(competition).printStats();

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

        // Print player and team stats
        player1.getStats(cupCompetition).printStats();

        team1.getStats(cupCompetition).printStats();
        team2.getStats(cupCompetition).printStats();

        competition.printTable();
        competition.printGoalScorers(5);
    
    }

}



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