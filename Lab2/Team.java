import java.util.LinkedList;

public class Team {
	private String name;
    private Country country;
    private Gender gender;
    private LinkedList<Player> players;
    private int noMatches;
    private int noWins;
    private int noTies;
    private int noLosses;
    private int goalsScored;
    private int goalsAgainst; 

    public Team(String n, Country c, Gender g){
        name = n;
        country = c;
        gender = g;
        players = new LinkedList<Player>();
        noMatches = 0;
        noWins = 0;
        noTies = 0;
        noLosses = 0; 
        goalsScored = 0;
        goalsAgainst = 0;
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

    public LinkedList<Player> getPlayers(){
        return players;
    }

    public void addPlayer(Player p){
        if(gender==Gender.MIXED){
            players.add(p);
        }else if((p.isFemale() && gender == Gender.FEMALE) || !p.isFemale() && gender == Gender.MALE){
            players.add(p);
        }else{
            System.out.println("The player's gender and the team's gender do not match.");
        } 
    }

    public void removePlayer(Player p){
        players.remove(p);
    }

    public void updateStats(Match match){
        if(match.getHomeTeam().getName()==name) {
            playMatch(match.getHomeGoals(), match.getAwayGoals());
        }
        else if (match.getHomeTeam().getName()==name){
            playMatch(match.getAwayGoals(), match.getHomeGoals());
        }
    }

    public void playMatch(int forGoals, int againstGoals){
        goalsScored += forGoals;
        goalsAgainst += againstGoals;
        noMatches++;
        if(forGoals > againstGoals){
            noWins++;
        } else if(againstGoals > forGoals){
            noLosses++;
        } else{
            noTies++;
        }
    }
    
    public void printStats(){
        System.out.printf("Stats of %s:\n", name);
        System.out.printf("Country: %s\n", getCountry().getName());
        if(getGender()==Gender.FEMALE){
            System.out.printf("Gender: Female.\n");
        } else if (getGender()==Gender.MALE){
            System.out.printf("Gender: Male.\n");
        } else{
            System.out.printf("Gender: Mixed.\n");
        }
        System.out.printf("Played matches: %d\n", noMatches);
        System.out.printf("Wins: %d\n", noWins);
        System.out.printf("Ties: %d\n", noTies);
        System.out.printf("Losses: %d\n", noLosses);
        System.out.printf("Goals scored: %d\n", goalsScored);
        System.out.printf("Goals against: %d\n", goalsAgainst);
    }
}