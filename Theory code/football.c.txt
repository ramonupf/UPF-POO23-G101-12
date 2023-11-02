
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// PROGRAM DATA

// number of players and their names
int no_players;
char * player_names[1000];

// number of teams and their names and players
int no_teams;
char * team_names[100];
int no_team_players[100];
int team_players[100][100];

// matches 
// each match is in the following format:
// (home team, away team, home goals, away goals, scorer 1, scorer 2, ...)
int no_matches;
int matches[500][100];

// team statistics
// each team has the following associated statistics:
// (matches played, wins, ties, losses, goals for, goals against, points)
int team_stats[100][7];

// player statistics
int goals_scored[1000];


// PROGRAM FUNCTIONS

// return the index of a name in an array
int find_name(char * array[], int size, char * name) {
	for (int i = 0; i < size; ++i)
		if (strcmp(array[i], name) == 0)
			return i;
	return -1;
}

// add a player
void add_player(char * player_name) {
	player_names[no_players] = player_name;
	no_players++;
}

// add a team
void add_team(char * team_name) {
	team_names[no_teams] = team_name;
	no_teams++;
}

// assign a player to a team
void assign_player(char * player_name, char * team_name) {
	// retrieve the player id and team id
	int player_id = find_name(player_names, no_players, player_name);
	int team_id = find_name(team_names, no_teams, team_name);
	
	// if both are valid, perform the assignment
	if (player_id >= 0 && team_id >= 0) {
		team_players[team_id][no_team_players[team_id]] = player_id;
		no_team_players[team_id]++;
	}
}

// update team statistics
void update_stats(int team_id, int goals_for, int goals_against) {
	team_stats[team_id][0]++;
	team_stats[team_id][1] += goals_for > goals_against;
	team_stats[team_id][2] += goals_for == goals_against;
	team_stats[team_id][3] += goals_for < goals_against;
	team_stats[team_id][4] += goals_for;
	team_stats[team_id][5] += goals_against;
	team_stats[team_id][6] += 3 * (goals_for > goals_against) + (goals_for == goals_against);
}

// register a match
void register_match(char * home_name, char * away_name,
                    int home_goals, char * home_scorers[],
                    int away_goals, char * away_scorers[]) {
    // retrieve the ids of the two teams
    int home_id = find_name(team_names, no_teams, home_name);
	int away_id = find_name(team_names, no_teams, away_name);
	
	// if both are valid, register the match
	if (home_id >= 0 && away_id >= 0) {
		matches[no_matches][0] = home_id;
		matches[no_matches][1] = away_id;
		matches[no_matches][2] = home_goals;
		matches[no_matches][3] = away_goals;
		
		for (int i = 0; i < home_goals; ++i) {
			int player_id = find_name(player_names, no_players, home_scorers[i]);
			matches[no_matches][4 + i] = player_id;
			// update goals scored
			if (player_id >= 0) goals_scored[player_id]++;
		}
		
		for (int i = 0; i < away_goals; ++i) {
			int player_id = find_name(player_names, no_players, away_scorers[i]);
			matches[no_matches][4 + home_goals + i] = player_id;
			// update goals scored
			if (player_id >= 0) goals_scored[player_id]++;
		}
		no_matches++;
		
		// update team statistics
		update_stats(home_id, home_goals, away_goals);
		update_stats(away_id, away_goals, home_goals);
	}
}


// PRINT FUNCTIONS

// print the players of a team
void print_team_players(char * team_name) {
	// retrieve the team id
	int team_id = find_name(team_names, no_teams, team_name);
	
	// if it is valid, print the players
	if (team_id >= 0) {
		printf("Players of %s:\n", team_names[team_id]);
		for (int i = 0; i < no_team_players[team_id]; ++i)
			printf("  %s\n", player_names[team_players[team_id][i]]);
	}
}

// compare statistics of teams with indices a and b
int stat_cmp(const void * elem1, const void * elem2) {
	int a = *((int *)elem1);
    int b = *((int *)elem2);

    if (team_stats[a][6] < team_stats[b][6]) return 1;
    else if (team_stats[b][6] < team_stats[a][6]) return -1;
    
    if (team_stats[a][4] - team_stats[a][5] < team_stats[b][4] - team_stats[b][5]) return 1;
    else if (team_stats[b][4] - team_stats[b][5] < team_stats[a][4] - team_stats[a][5]) return -1;
    
    if (team_stats[a][4] < team_stats[b][4]) return 1;
    else if (team_stats[b][4] < team_stats[a][4]) return -1;
    
    return 0;
}

// print the current league table
void print_table() {
	int team_ids[100];
	for (int i = 0; i < no_teams; ++i)
		team_ids[i] = i;
	qsort(team_ids, no_teams, sizeof(int), stat_cmp);
	
	printf("TEAM                \tPLAYED\tWINS\tTIES\tLOSSES\tGF\tGA\tPOINTS\n");
	for (int i = 0; i < no_teams; ++i) {
		printf("%s", team_names[team_ids[i]]);
		for (int j = strlen(team_names[team_ids[i]]); j < 20; ++j)
			printf(" ");
		for (int j = 0; j < 7; ++j)
			printf("\t%d", team_stats[team_ids[i]][j]);
		printf("\n");
	}
	printf("\n");
}

// compare goals scored of players with indices a and b
int goal_cmp(const void * elem1, const void * elem2) {
	int a = *((int *)elem1);
    int b = *((int *)elem2);

    if (goals_scored[a] < goals_scored[b]) return 1;
    if (goals_scored[b] < goals_scored[a]) return -1;

    return 0;
}

// print k highest scorers
void print_high_scorers(int k) {
	int player_ids[100];
	for (int i = 0; i < no_players; ++i)
		player_ids[i] = i;
	qsort(player_ids, no_players, sizeof(int), goal_cmp);
	
	printf("PLAYER              \tGOALS\n");
	for (int i = 0; i < k; ++i) {
		printf("%s", player_names[player_ids[i]]);
		for (int j = strlen(player_names[player_ids[i]]); j < 20; ++j)
			printf(" ");
		printf("\t%d\n", goals_scored[player_ids[i]]);
	}
	printf("\n");
}


// INITIALIZATION FUNCTIONS

// initialize teams
void initialize_teams() {
	add_team("Alavés");
	add_team("Almería");
	add_team("Athletic Club");
	add_team("Atlético de Madrid");
	add_team("Barcelona");
	add_team("Cádiz");
	add_team("Celta de Vigo");
	add_team("Getafe");
	add_team("Girona");
	add_team("Granada");
	add_team("Las Palmas");
	add_team("Mallorca");
	add_team("Osasuna");
	add_team("Rayo Vallecano");
	add_team("Real Betis");
	add_team("Real Madrid");
	add_team("Real Sociedad");
	add_team("Sevilla");
	add_team("Valencia");
	add_team("Villareal");
}

// initialize some players
void initialize_players() {
	add_player("Kike García");
	assign_player("Kike García", "Alavés");
	add_player("Luis Rioja");
	assign_player("Luis Rioja", "Alavés");
	add_player("Rubén Duarte");
	assign_player("Rubén Duarte", "Alavés");
	
	add_player("Sergio Arribas");
	assign_player("Sergio Arribas", "Almería");
	
	add_player("Gorka Guruzeta");
	assign_player("Gorka Guruzeta", "Athletic Club");
	add_player("Iñaki Williams");
	assign_player("Iñaki Williams", "Athletic Club");
	
	add_player("Álvaro Morata");
	assign_player("Álvaro Morata", "Atlético de Madrid");
	add_player("Marcos Llorente");
	assign_player("Marcos Llorente", "Atlético de Madrid");
	add_player("Memphis Depay");
	assign_player("Memphis Depay", "Atlético de Madrid");
	
	add_player("Ferrán Torres");
	assign_player("Ferrán Torres", "Barcelona");
	add_player("Pedri");
	assign_player("Pedri", "Barcelona");
	
	add_player("Federico San Emeterio");
	assign_player("Federico San Emeterio", "Cádiz");
	
	add_player("Óscar Mingueza");
	assign_player("Óscar Mingueza", "Celta de Vigo");
	
	add_player("Artem Dovbyk");
	assign_player("Artem Dovbyk", "Girona");
	add_player("Cristhian Stuani");
	assign_player("Cristhian Stuani", "Girona");
	add_player("Yangel Herrera");
	assign_player("Yangel Herrera", "Girona");
	
	add_player("Samu Omorodion");
	assign_player("Samu Omorodion", "Granada");
	
	add_player("Jonathan Viera");
	assign_player("Jonathan Viera", "Las Palmas");
	
	add_player("Antonio Raíllo");
	assign_player("Antonio Raíllo", "Mallorca");
	
	add_player("Moi Gómez");
	assign_player("Moi Gómez", "Osasuna");
	add_player("Rubén García");
	assign_player("Rubén García", "Osasuna");
	
	add_player("Álvaro García");
	assign_player("Álvaro García", "Rayo Vallecano");
	add_player("Isi Palazón");
	assign_player("Isi Palazón", "Rayo Vallecano");
	add_player("Pathé Ciss");
	assign_player("Pathé Ciss", "Rayo Vallecano");
	add_player("Randy Nteka");
	assign_player("Randy Nteka", "Rayo Vallecano");
	
	add_player("Ayoze Pérez");
	assign_player("Ayoze Pérez", "Real Betis");
	add_player("Willian José");
	assign_player("Willian José", "Real Betis");
	
	add_player("Jude Bellingham");
	assign_player("Jude Bellingham", "Real Madrid");
	add_player("Rodrygo Goes");
	assign_player("Rodrygo Goes", "Real Madrid");
	add_player("Vinícius Júnior");
	assign_player("Vinícius Júnior", "Real Madrid");
	
	add_player("Ander Barrenetxea");
	assign_player("Ander Barrenetxea", "Real Sociedad");
	add_player("Take Kubo");
	assign_player("Take Kubo", "Real Sociedad");
	
	add_player("Erik Lamela");
	assign_player("Erik Lamela", "Sevilla");
	add_player("Rafa Mir");
	assign_player("Rafa Mir", "Sevilla");
	add_player("Youssef En-Nesyri");
	assign_player("Youssef En-Nesyri", "Sevilla");
	
	add_player("Javi Guerra");
	assign_player("Javi Guerra", "Valencia");
	add_player("Mouctar Diakhaby");
	assign_player("Mouctar Diakhaby", "Valencia");
	add_player("Pepelu");
	assign_player("Pepelu", "Valencia");
	
	add_player("Gerard Moreno");
	assign_player("Gerard Moreno", "Villareal");
	add_player("Jorge Cuenca");
	assign_player("Jorge Cuenca", "Villareal");
	
	add_player("Propia puerta");
}

// initialize some matches
void initialize_matches() {
	char * home_scorers[10];
	char * away_scorers[10];
	
	// Partidos día 1
	away_scorers[0] = "Isi Palazón";
	away_scorers[1] = "Randy Nteka";
	register_match("Almería", "Rayo Vallecano", 0, home_scorers, 2, away_scorers);
	
	home_scorers[0] = "Youssef En-Nesyri";
	away_scorers[0] = "Mouctar Diakhaby";
	away_scorers[1] = "Javi Guerra";
	register_match("Sevilla", "Valencia", 1, home_scorers, 2, away_scorers);
	
	home_scorers[0] = "Take Kubo";
	away_scorers[0] = "Artem Dovbyk";
	register_match("Real Sociedad", "Girona", 1, home_scorers, 1, away_scorers);
	
	home_scorers[0] = "Jonathan Viera";
	away_scorers[0] = "Antonio Raíllo";
	register_match("Las Palmas", "Mallorca", 1, home_scorers, 1, away_scorers);
	
	away_scorers[0] = "Rodrygo Goes";
	away_scorers[1] = "Jude Bellingham";
	register_match("Athletic Club", "Real Madrid", 0, home_scorers, 2, away_scorers);
	
	away_scorers[0] = "Rubén García";
	away_scorers[1] = "Moi Gómez";
	register_match("Celta de Vigo", "Osasuna", 0, home_scorers, 2, away_scorers);
	
	home_scorers[0] = "Jorge Cuenca";
	away_scorers[0] = "Ayoze Pérez";
	away_scorers[1] = "Willian José";
	register_match("Villareal", "Real Betis", 1, home_scorers, 2, away_scorers);
	
	register_match("Getafe", "Barcelona", 0, home_scorers, 0, away_scorers);
	
	home_scorers[0] = "Federico San Emeterio";
	register_match("Cádiz", "Alavés", 1, home_scorers, 0, away_scorers);
	
	home_scorers[0] = "Álvaro Morata";
	home_scorers[1] = "Memphis Depay";
	home_scorers[2] = "Marcos Llorente";
	away_scorers[0] = "Samu Omorodion";
	register_match("Atlético de Madrid", "Granada", 3, home_scorers, 1, away_scorers);
	
	// Partidos día 2
	away_scorers[0] = "Gerard Moreno";
	register_match("Mallorca", "Villareal", 0, home_scorers, 1, away_scorers);
	
	home_scorers[0] = "Pepelu";
	register_match("Valencia", "Las Palmas", 1, home_scorers, 0, away_scorers);
	
	home_scorers[0] = "Ander Barrenetxea";
	away_scorers[0] = "Óscar Mingueza";
	register_match("Real Sociedad", "Celta de Vigo", 1, home_scorers, 1, away_scorers);
	
	home_scorers[0] = "Sergio Arribas";
	away_scorers[0] = "Jude Bellingham";
	away_scorers[1] = "Jude Bellingham";
	away_scorers[2] = "Vinícius Júnior";
	register_match("Almería", "Real Madrid", 1, home_scorers, 3, away_scorers);
	
	away_scorers[0] = "Iñaki Williams";
	away_scorers[1] = "Gorka Guruzeta";
	register_match("Osasuna", "Athletic Club", 0, home_scorers, 2, away_scorers);
	
	home_scorers[0] = "Yangel Herrera";
	home_scorers[1] = "Cristhian Stuani";
	home_scorers[2] = "Cristhian Stuani";
	register_match("Girona", "Getafe", 3, home_scorers, 0, away_scorers);
	
	home_scorers[0] = "Pedri";
	home_scorers[1] = "Ferrán Torres";
	register_match("Barcelona", "Cádiz", 2, home_scorers, 0, away_scorers);
	
	register_match("Real Betis", "Atlético de Madrid", 0, home_scorers, 0, away_scorers);
	
	home_scorers[0] = "Luis Rioja";
	home_scorers[1] = "Rubén Duarte";
	home_scorers[2] = "Kike García";
	home_scorers[3] = "Kike García";
	away_scorers[0] = "Propia puerta";
	away_scorers[1] = "Erik Lamela";
	away_scorers[2] = "Rafa Mir";
	register_match("Alavés", "Sevilla", 4, home_scorers, 3, away_scorers);
	
	away_scorers[0] = "Álvaro García";
	away_scorers[1] = "Pathé Ciss";
	register_match("Granada", "Rayo Vallecano", 0, home_scorers, 2, away_scorers);
}


// MAIN FUNCTION

int main() {
	initialize_teams();
	initialize_players();
	initialize_matches();
	print_table();
	print_high_scorers(10);
}

