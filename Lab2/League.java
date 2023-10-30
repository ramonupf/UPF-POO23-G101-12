import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class League {
    private String name;
    private Country country;
    private Gender gender;
    private LinkedList<Team> teams;
    private LinkedList<Match> matches;

    public League(){
        teams = new LinkedList<Team>();
        matches = new LinkedList<Match>();
    }

    public League(String n, Country c, Gender g){
        name = n;
        country = c;
        gender = g;
        teams = new LinkedList<Team>();
        matches = new LinkedList<Match>();
    }
    //getters
    public String getName() {
        return name;
    }
    
    public Country getCountry() {
        return country;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public LinkedList<Team> getTeams() {
        return teams;
    }
    
    public LinkedList<Match> getMatches() {
        return matches;
    }

    public void addTeam(Team t){
        teams.add(t);       
    }

    public void generateMatches(){
        for(int i=0;i<teams.size();i++){
            for(int j=0;j<teams.size();j++){
                if(j != i){
                    Match auxMatch = new Match(teams.get(i), teams.get(j));
                    matches.add(auxMatch);
                }
            }
        }
    }

    public void simulateMatches(){
        for (Match match : matches) {
            match.simulateMatch(); // Simulate the match
            //Update stats for home team and away team
            match.getHomeTeam().updateStats(match);
            match.getAwayTeam().updateStats(match);
            //Update stats for players in the home team
            for (Player player : match.getHomeTeam().getPlayers()) {
                player.updateStats(match);
            }
            //Update stats for players in the away team
            for (Player player : match.getAwayTeam().getPlayers()) {
                player.updateStats(match);
            }
        }
    }

    public void printTeams() {
        System.out.println("Teams in " + name + " League:");
        int teamNum = 1;
        for (Team team : teams) {
            System.out.println(teamNum+". " +team.getName());
            teamNum++;
        }
    }

    public void printMatches(){
        System.out.println("Matches in " + name + " League:");
        for (Match match : matches) {
            System.out.println("Match: " + match.getHomeTeam().getName() + " vs. " + match.getAwayTeam().getName());
            System.out.println("Result: " + match.getHomeGoals() + " - " + match.getAwayGoals());
            System.out.println("----------------------------");
        }
    }

    public League leagueFromCSV(String leagueName, String countryName, Gender leagueGender){
        LinkedList<Team> teams = new LinkedList<>();
        League league = null;
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
                    league = new League(leagueName, new Country(countryName), leagueGender);
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

}
