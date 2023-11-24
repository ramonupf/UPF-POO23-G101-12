public class TeamStats implements Comparable<TeamStats>{
    private Team team;
    private int noMatches;
    private int noWins;
    private int noTies;
    private int noLosses;
    private int goalsScored;
    private int goalsAgainst; 

    public TeamStats(Team t){
        team = t;
        noMatches = 0;
        noWins = 0;
        noTies = 0;
        noLosses = 0; 
        goalsScored = 0;
        goalsAgainst = 0;
    }
    
    public void updateStats(Match match){
        //play match is a private method of teamStats
        if(match.getHomeTeam().getName()==team.name) {
            playMatch(match.getHomeGoals(), match.getAwayGoals());
        }
        else if (match.getAwayTeam().getName()==team.name){
            playMatch(match.getAwayGoals(), match.getHomeGoals());
        }
    }

    public void printStats(){
        System.out.printf("Stats of %s:\n", team.getName());
        System.out.printf("Country: %s\n", team.getCountry().getName());
        if(team.getGender()==Gender.FEMALE){
            System.out.printf("Gender: Female.\n");
        } else if (team.getGender()==Gender.MALE){
            System.out.printf("Gender: Male.\n");
        } else{
            System.out.printf("Gender: Mixed.\n");
        }
        System.out.printf("Played matches: %d\n", noMatches);
        System.out.printf("Wins: %d\n", noWins);
        System.out.printf("Ties: %d\n", noTies);
        System.out.printf("Losses: %d\n", noLosses);
        System.out.printf("Goals scored: %d\n", goalsScored);
        System.out.printf("Goals against: %d\n", goalsAgainst);
    }

    public int compareTo(TeamStats ts){
        int pointsOther = 3*ts.noWins + ts.noTies;
        int pointsThis = 3*noWins + noTies;
        int goalDifferenceOther = ts.goalsScored - ts.goalsAgainst;
        int goalDifferenceThis = goalsScored - goalsAgainst;
        //compare points
        if (pointsThis > pointsOther){
            return -1;
        } else if(pointsThis < pointsOther){
            return 1;
        }
        //compare goal diff
        if(goalDifferenceThis > goalDifferenceOther){
            return 1;
        } else if(goalDifferenceThis < goalDifferenceOther){
            return -1;
        }
        //compare scored goals
        if(goalsScored>ts.goalsScored){
            return 1;
        } else if(goalsScored < ts.goalsScored){
            return -1;
        }
        return 0;
    }
    
    private void playMatch(int forGoals, int againstGoals){
        goalsScored += forGoals;
        goalsAgainst += againstGoals;
        noMatches++;
        if(forGoals > againstGoals){
            noWins++;
        } else if(againstGoals > forGoals){
            noLosses++;
        } else{
            noTies++;
        }
    }

}
