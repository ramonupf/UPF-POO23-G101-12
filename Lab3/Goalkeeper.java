public class Goalkeeper extends Player {
    private int noSaves;
    private int noGoalsLet;

    Goalkeeper(boolean g, String n, int a, Country nat){
        super(g, n, a, nat);
        noSaves = 0;
        noGoalsLet = 0;
    }
    
    @Override
    public void updateStats(Match match) {
        super.updateStats(match);
        //update number of let goals:
        if(match.homeTeam.players.contains(this)){
            noGoalsLet += match.awayGoals;
        } else if(match.awayTeam.players.contains(this)){
            noGoalsLet += match.homeGoals;
        }
    }

    public void update(int s, int g){
        noSaves+=s;
        noGoalsLet+=g;
    }

    @Override
    public void printStats(){
        super.printStats();
        System.out.printf("Saves: %d\n", noSaves);
        System.out.printf("Goals Let: %d\n", noGoalsLet);
    }
}