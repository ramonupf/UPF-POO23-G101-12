import java.util.LinkedList;

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
        //empty
    }

}
