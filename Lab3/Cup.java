import java.util.*;

public class Cup extends Competition {

    private ArrayList<LinkedList<Team>> tr;
    private ArrayList<LinkedList<Match>> mr;

    private int roundIndex;

    public Cup(String n, Country c, Gender g, Boolean club){
        super(n,c,g,club);
        roundIndex = 0;
        //initialize
    }

    @Override
    public void generateMatches() {
        Collections.shuffle(tr);
        int initialNumTeams = tr.get(0).size();
        int numRounds = (int) Math.ceil(Math.log((double) initialNumTeams) / Math.log(2)); // using the property logba = (log a)/(log b)
        for(int i=0; i<numRounds;i++){
            //do the pairings
            //store list of matches in mr<i>
            //simulateMatches() of mr<i>
            //
        }
    }

    @Override
    public void simulateMatches() {
        roundIndex = 9;
        super.simulateMatches();
    }
    
}
