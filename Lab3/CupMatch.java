import java.util.Random;

public class CupMatch extends Match {
    CupMatch(Team h, Team a){
        super(h,a);
    }

    @Override
    public void simulateMatch(){
        int n = 6;
        Random random = new Random();
        homeGoals = random.nextInt(n);
        awayGoals = random.nextInt(n);
        //extra time
        if(homeGoals == awayGoals){
            int maxExtraTimeGoals = 3;
            homeGoals += random.nextInt(maxExtraTimeGoals);
            awayGoals += random.nextInt(maxExtraTimeGoals);
        }
        //home team scorers:
        addRandomScorers(homeGoals, true);
        //away team scorers:
        addRandomScorers(awayGoals, false);

        //penalties. Scorers statistics are not affected by penalties. It just decides the winner with 1 or 0.
        if(homeGoals == awayGoals){
            int penaltyBool = 1;
            int winnerBoolean = random.nextInt(penaltyBool);
            if(winnerBoolean==1){
                homeGoals +=1;
            }else{
                awayGoals +=1;
            }
        }
    }
}
