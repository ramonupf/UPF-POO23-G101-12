public class Outfielder extends Player {
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;

    Outfielder(boolean g, String n, int a, Country nat){
        super(g, n, a, nat);
        noTackles = 0;
        noPasses = 0;
        noShots = 0;
        noAssists = 0;
        noGoals = 0;
    }

    @Override
    public void updateStats(Match match){
        super.updateStats(match);
        int goals = 0;
        // Check if the player is one of the scorers for the home team
        if(match.homeTeam.players.contains(this)){
            for (Player scorer : match.getHomeScorers()) {
                if (scorer.equals(this)) {
                    goals++;
                }
            }
        // Check if the player is one of the scorers for the away team
        } else if(match.awayTeam.players.contains(this)){
            for (Player scorer : match.getAwayScorers()) {
                if (scorer.equals(this)) {
                    goals++;
                }
            }
        }

        update(0,0,0,0,goals);
    }
    
    public void update(int t, int p, int s, int a, int g){
        noTackles += t;
        noPasses += p;
        noShots += s;
        noAssists += a;
        noGoals += g;
    }

    @Override
    public void printStats(){
        super.printStats();
        System.out.printf("Passes: %d\n", noPasses);
        System.out.printf("Tackles: %d\n", noTackles);
        System.out.printf("Shots: %d\n", noShots);
        System.out.printf("Assists: %d\n", noAssists);
        System.out.printf("Goals: %d\n", noGoals);
    } 

}
