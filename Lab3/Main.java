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
        */

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

