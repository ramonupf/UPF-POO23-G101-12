public class Goalkeeper extends Player {
    Goalkeeper(boolean g, String n, int a, Country nat){
        super(g, n, a, nat);
    }
    

    @Override
    public void update(Competition c, Match m){
        GoalkeeperStats provStats = (GoalkeeperStats)this.stats.get(c);
        if (provStats == null) {
            GoalkeeperStats newStats = new GoalkeeperStats(this);
            stats.put(c,newStats);
        }
        stats.get(c).updateStats(m);
    }
}


