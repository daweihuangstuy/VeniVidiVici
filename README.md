# VeniVidiVici
Repository for APCS1 Final Project

Brief project introduction
	For our final project we would like to create a terminal simulation of a classic game called “risk”.
This is a multiplayer world-domination conquest game that can support the participation of 2 - 6 players.
The number of troops that each player will receive at the start of the game is contingent on the number of
players at the start of the game. Everyone receives 20 troops if there are 6 players, 25 troops if there
are 5 players, 30 troops for 4 players, etc. There will be a total of 42 territories distributed over seven
continents. The player can visualize troop numbers in enemy territory and know which territory is occupied 
and by which enemy army. 
	That in our game, we have a map that each territory will have an unique lable. Once a player occupied a
territory, the color of the lable will change according to the player. But because the game is too long, so
at the set up stage, players can come to an agreement of whoever got certain amount of perecentage of the
total territories occupied win the game.

Launch instruction
	First you open the terminal. Then you have to enlarge the width of the terminal, we suggest 1000, so 
that you can have a better view of the map. After that you just follow the instructions about how you should
play the game. When it is your turn, you can attack as many time as you want. But you can only use maximum of
3 troops at a time, that you also need to have at least 1 troop stay in the territory to claim ownership. For
each attack, the computer will roll a dice as many time as the amount of troops you dedicated to. That each 
troop will have a probability of one-half to win the fight. If the offense win, the defense troop will
decrease by one. And vice versa. If there is 0 amount of troops on the attacking territory, then the offense 
will gain the ownership of the territory. At the end, whoever conquered certain percentage of the territories
the players agree before, that player win the game.