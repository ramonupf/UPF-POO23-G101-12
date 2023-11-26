
public class OutfielderStats extends PlayerStats{
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;

    public OutfielderStats(Player p){
        super(p);
        noTackles = 0;
        noPasses = 0;
        noShots = 0;
        noAssists = 0;
        noGoals = 0;
    }
    
    public int getNoGoals(){
        return noGoals;
    }

    @Override
    public void updateStats(Match match){
        super.updateStats(match);
        // Check if the player is one of the scorers for the home team
        if(match.homeTeam.players.contains(this.player)){
            for (Player scorer : match.getHomeScorers()) {
                if (scorer.equals(this.player)) {
                    noGoals++;
                }
            }
        // Check if the player is one of the scorers for the away team
        } else if(match.awayTeam.players.contains(this.player)){
            for (Player scorer : match.getAwayScorers()) {
                if (scorer.equals(this.player)) {
                    noGoals++;
                }
            }
        }
    }

    public void updateOtherStats(int t, int p, int s, int a){
        noTackles += t;
        noPasses += p;
        noShots += s;
        noAssists += a;
    }
    
    @Override
    public void printStats(){
        System.out.printf("Stats of %s:\n", player.getName());
        if(player.isFemale()){
            System.out.printf("Gender: Female.\n");
        } else {
            System.out.printf("Gender: Male.\n");
        }
        System.out.printf("Country:  %s\n", player.getNationality().getName());
        System.out.printf("Age: %d\n", player.getAge());
        System.out.printf("Played matches: %d\n", noMatches);
        System.out.printf("Passes: %d\n", noPasses);
        System.out.printf("Tackles: %d\n", noTackles);
        System.out.printf("Shots: %d\n", noShots);
        System.out.printf("Assists: %d\n", noAssists);
        System.out.printf("Goals: %d\n", noGoals);
    }

    @Override
    public int compareTo(PlayerStats o) {
        OutfielderStats other = (OutfielderStats) o;
        //compare goals
        if(this.noGoals > other.noGoals){ 
            return -1;
        } else if (this.noGoals < other.noGoals){
            return 1;
        }

        //compare assists
        if(this.noAssists > other.noAssists){ 
            return -1;
        } else if (this.noAssists < other.noAssists){
            return 1;
        }

        return 0;
    }
   

}