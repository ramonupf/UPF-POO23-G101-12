
public class Player {
    private boolean female;
    private String name;
    private int age;
    private Country nationality;
    private int noMatches;
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;

    public Player(boolean g, String n, int a, Country nat){
        female = g;
        name = n;
        age = a;
        nationality = nat;
        noMatches=0;
        noTackles = 0;
        noPasses = 0;
        noShots = 0;
        noAssists = 0;
        noGoals = 0;
    }

    //getters
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    
    public Country getNationality(){
        return nationality;
    }

    public boolean isFemale(){
        return female;
    }

    public void updateStats(Match match){
        int goals = 0;
        // Check if the player is one of the scorers for the home team
        for (Player scorer : match.getHomeScorers()) {
            if (scorer.equals(this)) {
                goals++;
            }
        }
        // Check if the player is one of the scorers for the away team
        for (Player scorer : match.getAwayScorers()) {
            if (scorer.equals(this)) {
                goals++;
            }
        }
        // Update the player's statistics
        update(0, 0, 0, 0, goals);
    }

    public void update(int t, int p, int s, int a, int g){
        noMatches++;
        noTackles += t;
        noPasses += p;
        noShots += s;
        noAssists += a;
        noGoals += g;
    }

    public void printStats(){
        System.out.printf("Stats of %s:\n", name);
        if(isFemale()){
            System.out.printf("Gender: Female.\n");
        } else {
            System.out.printf("Gender: Male.\n");
        }
        System.out.printf("Country:  %s\n", nationality.getName());
        System.out.printf("Age: %d\n", age);
        System.out.printf("Played matches: %d\n", noMatches);
        System.out.printf("Passes: %d\n", noPasses);
        System.out.printf("Tackles: %d\n", noTackles);
        System.out.printf("Shots: %d\n", noShots);
        System.out.printf("Assists: %d\n", noAssists);
        System.out.printf("Goals: %d\n", noGoals);
    } 
   
}


