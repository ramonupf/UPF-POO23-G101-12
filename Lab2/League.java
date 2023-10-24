import java.util.*;

public class League {
    private String name;
    private Country country;
    private Gender gender;
    private LinkedList<Team> teams;
    private LinkedList<Match> matches;

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
        for(int i=0; i<matches.size(); i++){
            matches.get(i).simulateMatch();
            
        }
    }
}
