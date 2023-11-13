public class NationalTeam extends Team {
    
    public NationalTeam(String n, Country c, Gender g){
        super(n,c,g);
    }

    @Override
    public void addPlayer(Player p){
        if(!p.getNationality().equals(country)){
            System.out.println("The player's ("+p.getName()+") nationality ("+p.getNationality().getName() +") doesn't match the National team ("+country.getName()+").");
        } else{
            super.addPlayer(p);
        }
    }
}
