//import Team.Gender;

public class Main {
    public static void main(String[] args){
        Country c1= new Country("Italy");
        Country cat = new Country("Catalonia");
        Player feryjhon = new Player(false, "Feryjhon", 39, c1);
        Player jorge = new Player(false, "Jorge", 56, cat);
        Team gironaFemaleTeam = new Team("Girona femení", cat, Gender.FEMALE);
        Team upf = new Team("Universitat Pompeu Fabra", cat, Gender.MIXED);
        upf.addPlayer(feryjhon);
        gironaFemaleTeam.addPlayer(jorge);
        feryjhon.printStats();
        feryjhon.update(40,3,2,1,1);
        feryjhon.printStats();
        gironaFemaleTeam.playMatch(5, 2);
        gironaFemaleTeam.printStats();
    }
}
