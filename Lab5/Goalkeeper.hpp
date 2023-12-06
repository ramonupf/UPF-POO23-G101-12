
#ifndef _GOALKEEPER_
#define _GOALKEEPER_

//#include "Player.hpp"
#include "Match.hpp"
using namespace std;


class Goalkeeper : public Player {

private:
    int noSaves;
    int noGoalsLet;
	
public:
	Goalkeeper(bool g, std::string n, int a, Country * nat) : Player(g, n, a, nat) {
        noSaves = 0;
        noGoalsLet = 0;
	}
	
    int getNoSaves(){
        return noSaves;
    }

    int getNoGoalsLet(){
        return noGoalsLet;
    }

    void updateStats(Match * m){
        bool updated = false;
        noMatches += 1;
        Team * teamOne = m->getTeamOne();
        for(Player* player : teamOne->getPlayers()){
            if(player == this){ //the goal keeper is in teamOne
                noGoalsLet += m->getGoalTwo();
                updated = true;
            }
        }
        if(updated==false){
            noGoalsLet += m->getGoalOne();
        }
    }
    
    void printStats(){
        string gender;
        if(female){
            gender = "female";
        } else{
            gender = "male";
        }
        cout << "Stats of " << name << endl;
        cout << "Gender: " << gender << endl;
        cout << "Age: " << age << endl;
        cout << "Nationality: " << nationality->getName() << endl;
        cout << "Played matches: " << noMatches << endl;
        cout << "Saves: " << noSaves << endl;
        cout << "Goals Let: " << noGoalsLet << endl;
    }
};

#endif

