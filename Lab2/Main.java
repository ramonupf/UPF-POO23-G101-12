public class Main {
    public static void main(String[] args) {
        League premierLeague = new League();
        premierLeague = premierLeague.leagueFromCSV("Premier League","England",Gender.MALE);
        premierLeague.generateMatches();
        premierLeague.simulateMatches();
        premierLeague.printMatches(); //PRINTS ALL MATCHES IN LEAGUE
        premierLeague.printTeams(); //PRINTS ALL TEAMS IN LEAGUE

        //EXAMPLE
        System.out.println("-----------------");
        int teamExample = 9;
        System.out.println("STATS OF TEAM "+premierLeague.getTeams().get(teamExample).getName());
        for(int i=0;i<premierLeague.getTeams().get(teamExample).getPlayers().size();i++){
            premierLeague.getTeams().get(5).getPlayers().get(i).printStats();
        }
        System.out.println();
        //EXAMPLE
        teamExample = 7;
        premierLeague.getTeams().get(teamExample).printStats();
    }

}

