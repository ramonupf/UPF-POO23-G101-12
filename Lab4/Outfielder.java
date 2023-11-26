public class Outfielder extends Player {
    
    Outfielder(boolean g, String n, int a, Country nat){
        super(g, n, a, nat);
    }
    public OutfielderStats getOutfielderStats(Competition c){
        return (OutfielderStats) stats.get(c);
    }

    @Override
    public void update(Competition c, Match m){
        OutfielderStats provStats = (OutfielderStats)this.stats.get(c);
        if (provStats == null) {
            OutfielderStats newStats = new OutfielderStats(this);
            stats.put(c,newStats);
        }
        stats.get(c).updateStats(m);
    }
}