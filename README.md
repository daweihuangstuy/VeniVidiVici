<h1>RISK</h1>

About the game:

For our final project, we decided to do a terminal simulation of the classic game "Risk." This is a multiplayer world-domination conquest game that can support the participation of 2 - 6 players. At the start of the game, players would begin by taking turns placing one troop at a time on empty territories or on territories that they had already occupied. The number of troops that each player will receive at the start of the game depends on the number of players at the start of the game. Everyone receives 20 troops if there are 6 players, 25 troops if there are 5 players, 30 troops for 4 players, and so on. There is a total of 42 territories distributed over seven continents. The player can view troop numbers in enemy territory and know which territories are occupied by enemy armies. On the map we have created, each territory will have an unique lable that the player would enter into the terminal when refering to a specific territory. There are codes throughout the map but they serve as placeholders that will be replaced with data once the game comences. Once a player has occupied a territory, the color of the lable will change to correspond with the player's color, each player would have a unique color. Since the game can sometimes last too long, at the initial set up of the game, players can decide to only play up to the point where a certain percentage of the total territories is occupied by one player, and that player would be declared the winner. The point of the game is therefore to conquer all the territories at the expense of enemy players, but the players can set the victory to a percentage of territories any one individual player must win in order to be victorious

<h2>Instructions:</h2>

First, open terminal and enlarge your terminal window to a size big enough to be able to view the entire world map
(we suggest 1000) 
    	
To begin the game, type
```
   javac Woo.java
```
followed by
```
   java Woo
```

Enter your game information
1. Enter start to begin entering the game information.
2. Enter the amount of players that would participate in the game. There should be at least two and at most six.
3. Enter the percentage of territory any individual player would have to win in order to be considered the victor of the game.

Before the game starts, there is an initial placement period where you each take turns placing troops on territories. You can only place one troop at a time on your own territories or an empty territory and not the territories of other players. The players alternate when placing troops. To speed up the process, you may type "autoPlace" to immediately place the remainder of everyone's troops at random.

After the game begins and it is your turn, you have the option of using your troops to attack enemy territory, or moving your troops to a different territory. Follow the prompts that appear in the terminal window.

The steps below represents a player's turn. The players would continue taking turns until a single player has occupied enough territories to win the game.

	To place troops, type
	1. The territory where you would like to place one troop
	2. Repeat the first step until all your troops have been placed. To place troops at random, you can type "autoPlace" to automatically place the remainder of your troops.

	To attack, type
	1. The territory that you would like to mount your attack from
	2. How much troops you are willing to commit to the attack (at most the amount of troops within that territory and at most 3)
	3. The territory that you would like to attack. It can be an empty territory or an enemy territory. 

	To move troops, type
	1. The territory you would like to move your troops from. It can only be from a territory that you occupy.
	2. The amount of soldiers that you would like to move. It can move as much soldiers as you want but you must have at the very least one soldier to guard your territory.
	3. The territory that you would like to move your troops to. It can only move troops to your own territory.

<h2>Rules:</h2>

You can use the attack command as many times as you want, but you can only use a maximum of 3 troops during each attack. 
You should also keep in mind that you will need to have at least 1 troop stay in your original territory so that you maintain ownership of that territory. 
For each troop used to attack, the computer will roll a dice to determine the winner of the attack. 
If the offense wins (the person who initiated the attack), the defense's total number of troops will decrease by one.
If the defense wins, the offense's total number of troops will decrease by one.
If you decide to attack an empty territory, or a territory with no troops occupying it, you will automatically gain ownership of that territory.
You also have the option to move your troops when it is your turn. You can only move troops to a territory that
you already occupy. 
So, for example, you CANNOT move your troops to a territory occupied by the enemy army.

Whoever conquers the set percentage of territories the players agreed to at the start of the game will be declared the winner!
