import java.util.*;

public class Match {
    protected Team homeTeam;
    protected Team awayTeam;
    protected int homeGoals;
    protected int awayGoals;
    protected LinkedList<Player> homeScorers;
    protected LinkedList<Player> awayScorers;
    
    public Match(Team h, Team a){ //h for home and a for away
        homeTeam = h;
        awayTeam = a;
        homeScorers = new LinkedList<Player>();
        awayScorers = new LinkedList<Player>();
    }
 
    //getter methods
    public Team getHomeTeam() {
        return homeTeam;
    }
    
    public Team getAwayTeam() {
        return awayTeam;
    }
    
    public int getHomeGoals() {
        return homeGoals;
    }
    
    public int getAwayGoals() {
        return awayGoals;
    }
    
    public LinkedList<Player> getHomeScorers() {
        return homeScorers;
    }
    
    public LinkedList<Player> getAwayScorers() {
        return awayScorers;
    }
    
    public void simulateMatch(){
        int n = 6;
        Random random = new Random();
        homeGoals = random.nextInt(n);
        awayGoals = random.nextInt(n);
        //home team scorers:
        addRandomScorers(homeGoals, true);
        //away team scorers:
        addRandomScorers(awayGoals, false);
    }

    protected void addRandomScorers(int goals, boolean home){
        Team team;
        if (home){
            team = homeTeam;
        }else{
            team = awayTeam;
        }
        int n = team.getPlayers().size();
        Random random = new Random();
        for(int i=0; i<goals;i++){
            int scorerIndex = random.nextInt(n);
            if(home){
                homeScorers.add(homeTeam.getPlayers().get(scorerIndex));
            }
            else{
                awayScorers.add(awayTeam.getPlayers().get(scorerIndex));
            }
        }
    }

    public void printMatch(){
        System.out.printf(" %s %d - %d %s\n", homeTeam.getName(), homeGoals, awayTeam.getName(), awayGoals);
        printScorers(homeTeam, homeScorers);
        printScorers(awayTeam, awayScorers);
    }

    private void printScorers(Team team, LinkedList<Player> scorers){
        System.out.printf("%s scorers:\n", team.getName());
        for(int i=0;i<scorers.size();i++){
            System.out.println(scorers.get(i).getName());
        }
    }


}
