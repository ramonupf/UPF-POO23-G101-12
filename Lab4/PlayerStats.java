public abstract class PlayerStats implements Comparable<PlayerStats>{
    protected Player player;
    protected int noMatches;

    PlayerStats(Player p){
        player = p;
    }

    public abstract void updateStats(Match m);

    public abstract void printStats();

}
