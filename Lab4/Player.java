import java.util.*;

public class Player {
    protected boolean female;
    protected String name;
    protected int age;
    protected Country nationality;
    protected int noMatches;
    protected HashMap<Competition,PlayerStats> stats;

    public Player(boolean g, String n, int a, Country nat){
        female = g;
        name = n;
        age = a;
        nationality = nat;
        stats = new HashMap<Competition, PlayerStats>();
    }

    //getters
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    
    public Country getNationality(){
        return nationality;
    }

    public PlayerStats getStats(Competition c){
        return stats.get(c);
    }

    public boolean isFemale(){
        return female;
    }

    

 
    public void update(Competition c, Match m) {
        PlayerStats provStats = this.stats.get(c);
        if (provStats != null) {
            stats.get(c).updateStats(m);
        }else { 
            //do nothing
        }
        
        
    }

 
}


