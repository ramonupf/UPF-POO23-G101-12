
#ifndef _PLAYER_
#define _PLAYER_

#include "Country.hpp"
#include "Team.hpp"
#include "Match.hpp"
using namespace std;

class Player {

private:
    bool female;
    string name;
    int age;
    Country nationality;
    int noMatches;
	
public:
	Player(bool g, std::string n, int a, Country nat) {
        female = g;
        name = n;
        age = a;
        nationality = nat;
	}
	
	bool isFemale() {
        return female;
    }

    string getName(){
        return name;
    }

    int getAge(){
        return age;
    }

    Country getCountry(){
        return nationality;
    }

    int getNoMatches(){
        return noMatches;
    }

    virtual void updateStats(Match m) = 0;

    virtual void printStats() = 0;
    
};

#endif

