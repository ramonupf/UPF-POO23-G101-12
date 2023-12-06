#include <iostream>
using namespace std;

#include "Goalkeeper.hpp"
#include "Outfielder.hpp"


int main(){
    srand(time(0)); //random seed to avoid getting the same value for rand() each time
    //Create a few countries
    Country* usa = new Country("USA");
    Country* brazil = new Country("Brazil");
    Country* france = new Country("France");
    Country* japan = new Country("Japan");
    Country* nkorea = new Country("North Korea");
    Country* skorea = new Country("South Korea");
    
    //Create a few outfielders from different countries
    Outfielder* outfielderUSA = new Outfielder(true, "Alex Morgan", 30, usa);
    Outfielder* outfielderBrazil = new Outfielder(false, "Roberto Carlos", 35, brazil);
    Outfielder* outfielderFrance = new Outfielder(true, "Marie Dupont", 28, france);
    Outfielder* outfielderJapan = new Outfielder(false, "Hiroshi Tanaka", 31, japan);
    Outfielder* outfielderNKorea = new Outfielder(true, "Kim Yuna", 29, nkorea);
    Outfielder* outfielderSKorea = new Outfielder(false, "Lee Min-ho", 33, skorea);

    //Create two teams that each include some outfielders
    Team * team_one = new Team("Team one", usa, Team::Gender::MIXED);
    Team * team_two = new Team("Team two", japan, Team::Gender::MIXED);
    team_one->addPlayer(outfielderUSA);
    team_one->addPlayer(outfielderBrazil);
    team_one->addPlayer(outfielderFrance);
    
    team_two->addPlayer(outfielderNKorea);
    team_two->addPlayer(outfielderJapan);
    team_two->addPlayer(outfielderSKorea);
    
    //create a match between two teams, simulate the match and print the result
    Match * new_match = new Match(team_one, team_two);
    new_match->simulateMatch();
    new_match->printMatch();

    //Update the statistics of each player as a result of playing the match
    outfielderUSA->updateStats(new_match);
    outfielderBrazil->updateStats(new_match);
    outfielderFrance->updateStats(new_match);
    outfielderJapan->updateStats(new_match);
    outfielderNKorea->updateStats(new_match);
    outfielderSKorea->updateStats(new_match);

    //Print the statistics of each player.
    cout << "Stats of players of " << team_one->getName() << endl;
    for(Player * player : team_one->getPlayers()){
        player->printStats();
    }
    cout << "Stats of players of " << team_two->getName() << endl;
    for(Player * player : team_two->getPlayers()){
        player->printStats();
    }

    //delete the Outfielder instances
    delete outfielderUSA;
    delete outfielderBrazil;
    delete outfielderFrance;
    delete outfielderJapan;
    delete outfielderNKorea;
    delete outfielderSKorea;

    //delete the Country instances
    delete usa;
    delete brazil;
    delete france;
    delete japan;
    delete nkorea;
    delete skorea;

    //delete other instances
    delete new_match;
    delete team_one;
    delete team_two;
}