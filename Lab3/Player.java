
public class Player {
    protected boolean female;
    protected String name;
    protected int age;
    protected Country nationality;
    protected int noMatches;


    public Player(boolean g, String n, int a, Country nat){
        female = g;
        name = n;
        age = a;
        nationality = nat;
        noMatches=0;

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
        noMatches++;
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
    } 
   
}


