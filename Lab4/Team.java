import java.util.*;

public class Team {
	protected String name;
    protected Country country;
    protected Gender gender;
    protected LinkedList<Player> players;
    protected HashMap<Competition,TeamStats> stats;
    
    public Team(String n, Country c, Gender g){
        name = n;
        country = c;
        gender = g;
        players = new LinkedList<Player>();
        stats = new HashMap<Competition,TeamStats>();
    }

    public String getName() {
        return name;
    }

    public Country getCountry(){
        return country;
    }

    
    public Gender getGender(){
        return gender;
    }

    public TeamStats getStats(Competition c){
        return stats.get(c);
    }

    public LinkedList<Player> getPlayers(){
        return players;
    }

    public void addPlayer(Player p){
        if(gender==Gender.MIXED){
            players.add(p);
            System.out.println("Added Player: " + p.getName() + " to new Team: " + name);
        }else if((p.isFemale() && gender == Gender.FEMALE) || !p.isFemale() && gender == Gender.MALE){
            players.add(p);
            System.out.println("Added " + p.getName() + " to " + name);
        }else{
            System.out.println("The player's gender and the team's gender do not match.");
        } 
    }

    public void removePlayer(Player p){
        players.remove(p);
    }

    public void update(Competition c, Match match){
        TeamStats provStats = this.stats.get(c);
        if (provStats == null) {
            TeamStats newStats = new TeamStats(this);
            stats.put(c,newStats);
        }
        stats.get(c).updateStats(match);
        
        }

}