import java.util.*;

public class League extends Competition {
    
    public League(String n, Country c, Gender g, boolean clubs){
        super(n, c, g, clubs);
        teams = new LinkedList<Team>();
        matches = new LinkedList<Match>();
    }

    @Override
    public void generateMatches(){
        for(int i=0;i<teams.size();i++){
            for(int j=0;j<teams.size();j++){
                if(j != i){
                    Match auxMatch = new Match(teams.get(i), teams.get(j));
                    matches.add(auxMatch);
                }
            }
        }
    }

    public void printTable(){
        ArrayList<TeamStats> teamStatsList = new ArrayList<TeamStats>();
        for (Team team: teams){
            teamStatsList.add(team.getStats(this));
        }
        Collections.sort(teamStatsList);
        System.out.printf("Classification of %s\n", this.name);
        System.out.printf("%-3s | %-15s | %-7s | %-15s | %-5s | %-5s | %-7s | %-13s | %-15s\n", 
        "No.", "Team", "Points", "Played Matches", "Wins", "Ties", "Losses", "Scored Goals", "Received Goals");
        int i =0;
        for(TeamStats stats: teamStatsList){
            i++;
            System.out.printf("%-3d | %-15s | %-7d | %-15d | %-5d | %-5d | %-7d | %-13d | %-15d\n",
            i, stats.getTeam().getName(),stats.getPoints(), stats.getNoMatches(), stats.getNoWins(),
            stats.getNoTies(), stats.getNoLosses(),stats.getoGoalsScored(), stats.getGoalsAgainst());
        }
    }

}
