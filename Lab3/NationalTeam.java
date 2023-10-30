public class NationalTeam extends Team {
    
    public NationalTeam(String n, Country c, Gender g){
        super(n,c,g);
    }

    public void addPlayer(Player p){
        if(!p.getNationality().equals(country)){
            System.out.println("The player's ("+p.getName()+") nationality ("+p.getNationality().getName() +") doesn't match the National team ("+country.getName()+").");
        } else{
            if(gender==Gender.MIXED){
                players.add(p);
                System.out.println("Added Player: " + p.getName() + " to new Team: " + name);
            }else if((p.isFemale() && gender == Gender.FEMALE) || !p.isFemale() && gender == Gender.MALE){
                players.add(p);
                System.out.println("Added " + p.getName() + " to " + name);
            }else{
                System.out.println("The player's gender and the team's gender do not match.");
            } 
        }
    }
    
}
