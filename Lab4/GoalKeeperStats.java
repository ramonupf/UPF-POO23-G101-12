
public class GoalkeeperStats extends PlayerStats{
    private int noSaves;
    private int noGoalsLet;

    public GoalkeeperStats(Player p){
        super(p);
        noSaves = 0;
        noGoalsLet = 0;
    }

    @Override
    public void updateStats(Match match) {
        super.updateStats(match);
        //update number of let goals:
        if(match.homeTeam.players.contains(this.player)){
            noGoalsLet += match.awayGoals;
        } else if(match.awayTeam.players.contains(this.player)){
            noGoalsLet += match.homeGoals;
        }
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
        System.out.printf("Saves: %d\n", noSaves);
        System.out.printf("Goals let: %d\n", noGoalsLet);
    
    }

    @Override
    public int compareTo(PlayerStats o) {
        GoalkeeperStats other = (GoalkeeperStats) o;
        if(this.noGoalsLet < other.noGoalsLet){ 
            return -1;
        } else if (this.noGoalsLet > other.noGoalsLet){
            return 1;
        }

        if(this.noSaves < other.noSaves){ 
            return -1;
        } else if (this.noSaves > other.noSaves){
            return 1;
        }

        return 0;
    }
     
}