#ifndef _OUTFIELDER_
#define _OUTFIELDER_

//#include "Player.hpp"
#include "Match.hpp"
using namespace std;

class Outfielder : public Player {

private:
    int noTackles;
    int noPasses;
    int noShots;
    int noAssists;
    int noGoals;
	
public:
	Outfielder(bool g, std::string n, int a, Country * nat) : Player(g, n, a, nat) {
        noTackles = 0;
        noPasses = 0;
        noShots = 0;
        noAssists = 0;
        noGoals = 0;
	}
	
    int getNoTackles(){
        return noTackles;
    }

    int getNoPasses(){
        return noPasses;
    }
    
    int getNoShots(){
        return noShots;
    }

    int getNoAssists(){
        return noAssists;
    }
    
    int getNoGoals(){
        return noGoals;
    }


    void updateStats(Match * m){
        noMatches += 1;
        bool updated = false;
        for(Player* player : m->getScorersOne()){
            if(player == this){ 
                noGoals+=1;
                updated = true;
            }
        }
        if(updated==false){
            for(Player* player : m->getScorersTwo()){
                if(player == this){ 
                    noGoals+=1;
                }
            }   
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
        cout << "Goals: " << noGoals << endl;
        cout << "Passes: " << noPasses << endl;
        cout << "Assists: " << noAssists << endl;
        cout << "Shots: " << noShots << endl;
        cout << "Tackles: " << noTackles << endl;
    }
};

#endif
