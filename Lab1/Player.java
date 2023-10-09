
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
    
    public boolean isFemale(){
        return female;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    
    public Country getNationality(){
        return nationality;
    }

    public void update(int t, int p, int s, int a, int g){
        noMatches++;
        t += noTackles;
        p += noPasses;
        s += noShots;
        a += noAssists;
        g += noGoals;
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
        System.out.printf("Shots: %d\n", noShots);
        System.out.printf("Assists: %d\n", noAssists);
        System.out.printf("Goals: %d\n", noGoals);
    } 
    
}



