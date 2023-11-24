
public abstract class PlayerStats implements Comparable<PlayerStats>{
    protected Player player;
    protected int noMatches;

    PlayerStats(Player p){
        player = p;
        noMatches = 0;
    }

    public void updateStats(Match m){
        noMatches++;
    }

    public abstract void printStats();

}
