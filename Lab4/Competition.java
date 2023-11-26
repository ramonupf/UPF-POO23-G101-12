import java.util.*;

public class Competition { //could be abstract but the UML doesn't say so
    protected String name;
    protected Country country;
    protected Gender gender;
    protected LinkedList<Team> teams;
    protected LinkedList<Match> matches;
    protected boolean clubs;

    public Competition(){
        teams = new LinkedList<Team>();
        matches = new LinkedList<Match>();
    }

    public Competition(String n, Country c, Gender g, Boolean club){
        name = n;
        country = c;
        gender = g;
        clubs = club;
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
        if(t.getGender() != gender){
            System.out.println("The gender of the competition and the gender of the team do not match.");
        } else {
            if (clubs && !(t instanceof NationalTeam)) {
                teams.add(t);
            } else if (!clubs && t instanceof NationalTeam) {
                teams.add(t);
            } else{
                System.out.println("The type of competition and the type of team do not match.");
            }
        }
    }

    public void generateMatches(){
        //empty. used only in subclasses of Competition
    }

    public void simulateMatches(){
        for (Match match : matches) {
            match.simulateMatch(); // Simulate the match
            //Update stats for home team and away team
            match.getHomeTeam().update(this,match);
            match.getAwayTeam().update(this,match);
            //Update stats for players in the home team
            for (Player player : match.getHomeTeam().getPlayers()) {
                player.update(this,match);
            }
            //Update stats for players in the away team
            for (Player player : match.getAwayTeam().getPlayers()) {
                player.update(this,match);
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
        System.out.printf("%d matches in " + name + " League:\n", matches.size());
        for (Match match : matches) {
            System.out.println("Match: " + match.getHomeTeam().getName() + " vs. " + match.getAwayTeam().getName());
            System.out.println("Result: " + match.getHomeGoals() + " - " + match.getAwayGoals());
            System.out.println("----------------------------");
        }
    }

    public void printGoalScorers(int playerNum){
        ArrayList<OutfielderStats> outfielderStatsList = new ArrayList<OutfielderStats>();
        for (Team team: teams){
            for(Player player: team.getPlayers()){
                if (player instanceof Outfielder)
                    outfielderStatsList.add((OutfielderStats) player.getStats(this));
            }
        }
        Collections.sort(outfielderStatsList);
        System.out.printf("Goal Scorers of %s\n", this.name);
        System.out.printf("     Player   |  Goals | Played Matches | \n");
        int i = 0;
        while(i<playerNum){
            System.out.printf("   %d   |  %s    |    %d    |    %d    |\n", i+1, outfielderStatsList.get(i).getPlayer().getName(), outfielderStatsList.get(i).getNoGoals(), outfielderStatsList.get(i).getNoMatches());
            i++;
        }
    }
}
