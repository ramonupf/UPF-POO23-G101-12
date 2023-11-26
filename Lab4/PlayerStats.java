
public abstract class PlayerStats implements Comparable<PlayerStats>{
    protected Player player;
    protected int noMatches;

    PlayerStats(Player p){
        player = p;
        noMatches = 0;
    }



    public Player getPlayer() {
        return player;
    }

    public int getNoMatches(){
        return noMatches;
    }
    
    public void updateStats(Match m){
        noMatches++;
    }

    public abstract void printStats();

}
