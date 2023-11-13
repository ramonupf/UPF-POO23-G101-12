import java.util.*;

public class GroupPlay extends Competition {
    private final int teamsPerGroup = 4; //WE ASSUME OUR APP WORKS WITH GROUPS OF 4
    private int noGroups;
    private ArrayList<League> groups;

    public GroupPlay(String n, Country c, Gender g, boolean clubs){
        super(n, c, g, clubs);
        groups = new ArrayList<League>();
        teams = new LinkedList<Team>();
        matches = new LinkedList<Match>();
    }


    @Override
    public void generateMatches(){ 
        int numTeams = teams.size();
        //Handle cases with less than teamsPerGroup teams
        if (numTeams <= teamsPerGroup) {
            noGroups = 1;
            //Create one group with all available teams
            League league = new League(name, country, gender, clubs);
            for (Team team : teams) {
                league.addTeam(team);
            }
            groups.add(league);
        } else { //other cases
            Collections.shuffle(teams); //mix the teams randomly
            noGroups = numTeams / teamsPerGroup;
            int remainingTeams = numTeams % teamsPerGroup;
            Iterator<Team> teamIterator = teams.iterator();
            //Creating groups of teamsPerGroup
            for (int i = 0; i < noGroups; i++) {
                League league = new League(name, country, gender, clubs);
                for (int j = 0; j < teamsPerGroup && teamIterator.hasNext(); j++) {
                    league.addTeam(teamIterator.next());
                }
                groups.add(league);
            }
            //Handle the remaining teams
            if (remainingTeams > 0) {
                //Distribute remaining teams to existing groups
                int i = 0;
                while (teamIterator.hasNext() && i < noGroups) {
                    groups.get(i).addTeam(teamIterator.next());
                    i = (i + 1) % noGroups; //this ensures that the index is always between the possible range of groups
                }
            }
        }

        //Generate matches for each league
        for (League league : groups){
            league.generateMatches();
        }
    }

        

    @Override
    public void simulateMatches(){
        for (League league : groups){
            league.simulateMatches();
            matches.addAll(league.getMatches());
        }
    }



    public void printTables(){
        //empty
    }

}
