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

}
