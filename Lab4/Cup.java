import java.util.*;

public class Cup extends Competition {
    //Attributes:
    private ArrayList<LinkedList<Team>> tr;
    private ArrayList<LinkedList<CupMatch>> mr;
    private int roundIndex;

    public Cup(String n, Country c, Gender g, Boolean club){
        super(n,c,g,club);
        //initialize lists:
        tr = new ArrayList<LinkedList<Team>>();
        mr = new ArrayList<LinkedList<CupMatch>>();
        //initialize round 0:
        tr.add(new LinkedList<Team>()); // Initialize a new LinkedList for teams in the first round
        mr.add(new LinkedList<CupMatch>()); // Initialize a new LinkedList for matches in the first round    
        roundIndex = 0;
    }

    @Override
    public void generateMatches() {
        //first round includes all teams:
        int initialNumTeams = teams.size();
        for(int i=0;i<initialNumTeams;i++){
            tr.get(roundIndex).add(teams.get(i));
        }
        Collections.shuffle(tr.get(0)); //mix the teams randomly

        int numRounds = (int) Math.ceil(Math.log((double) initialNumTeams) / Math.log(2)); // using the property logba = (log a)/(log b)
        
        for(int i=0; i<numRounds;i++){
            Team notPlayingTeam = null;
            int numTeams = tr.get(i).size();
            if (numTeams%2!=0){
                numTeams--;
                notPlayingTeam = tr.get(i).getLast();// will need to add last team directly to next round
            }
            for(int j=0; j<numTeams; j+=2){
                CupMatch auxMatch = new CupMatch(tr.get(i).get(j), tr.get(i).get(j+1));
                mr.get(i).add(auxMatch); //store list of matches in mr<i>
            }
            simulateMatches();
            addNewRound();
            //check who won and add to next round:
            int numMatches = mr.get(i).size();
            for(int k=0;k<numMatches;k++){
                if(mr.get(i).get(k).getHomeGoals()>mr.get(i).get(k).getAwayGoals()){
                    //winner is homeTeam
                    tr.get(roundIndex).add(mr.get(i).get(k).getHomeTeam());
                } else{
                    //winner is awayTeam
                    tr.get(roundIndex).add(mr.get(i).get(k).getAwayTeam());
                }
            }
            if(notPlayingTeam != null){
                tr.get(roundIndex).add(notPlayingTeam);
            }      
            Collections.shuffle(tr.get(roundIndex)); //mix the teams randomly
        }
    }

    @Override
    public void simulateMatches() {
        for (CupMatch match : mr.get(roundIndex)) {
            match.simulateMatch(); // Simulate the match
            //Update stats for home team and away team
            match.getHomeTeam().updateStats(match);
            match.getAwayTeam().updateStats(match);
            //Update stats for players in the home team
            for (Player player : match.getHomeTeam().getPlayers()) {
                player.updateStats(match);
            }
            //Update stats for players in the away team
            for (Player player : match.getAwayTeam().getPlayers()) {
                player.updateStats(match);
            }
            matches.add(match);
        }
    }

    private void addNewRound() {
        tr.add(new LinkedList<Team>()); // Initialize a new LinkedList for teams in the new round
        mr.add(new LinkedList<CupMatch>()); // Initialize a new LinkedList for matches in the new round
        roundIndex++; // Increment the round index
    }
    
}
