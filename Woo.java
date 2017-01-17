import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import cs1.Keyboard;

public class Woo {
    //class variables
    static int numPlayer = 0;
    static ArrayList<String> playerOrder = new ArrayList<String>();
    static String playerTurn;
    static ArrayList<Integer> troopPresent = new ArrayList<Integer>();
	static double victoryMargin;
    
    //initial toops for placement
    public static int player1InitialTroop = -1;
    public static int player2InitialTroop = -1;
    public static int player3InitialTroop = -1;
    public static int player4InitialTroop = -1;
    public static int player5InitialTroop = -1;
    public static int player6InitialTroop = -1;
    
    //player variables
    //player occupied territories
    static ArrayList<String> player1Occupied = new ArrayList<String>();
    static ArrayList<String> player2Occupied = new ArrayList<String>();
    static ArrayList<String> player3Occupied = new ArrayList<String>();
    static ArrayList<String> player4Occupied = new ArrayList<String>();
    static ArrayList<String> player5Occupied = new ArrayList<String>();
    static ArrayList<String> player6Occupied = new ArrayList<String>();
    //player troopNumbers
    static int player1TroopNum = -1;
    static int player2TroopNum = -1;
    static int player3TroopNum = -1;
    static int player4TroopNum = -1;
    static int player5TroopNum = -1;
    static int player6TroopNum = -1;
    //player territoryNumbers
    static int player1TerritoryNum = -1;
    static int player2TerritoryNum = -1;
    static int player3TerritoryNum = -1;
    static int player4TerritoryNum = -1;
    static int player5TerritoryNum = -1;
    static int player6TerritoryNum = -1;
    //game status
    static boolean status = false;
    
    static String[][] terriInfo;
    
    //project colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String args[]) throws FileNotFoundException {
	//instantialize players
	Territory game = new Territory();
	Player1 player1 = new Player1();
	Player2 player2 = new Player2();
	startGame();
	renderMap();
	System.out.println("Each player must initially alternately place " + player1InitialTroop + " troops each\n");
	
	//initial placement of troops
	int rounds = 0;
	playerTurn = "player1";
	
	while (playerOrder.get(rounds % playerOrder.size()) != ""){
	    playerTurn = playerOrder.get(rounds % playerOrder.size());
	    System.out.println("Order of Play: " + playerOrder.toString().substring(1,playerOrder.toString().length() - 1));
	    System.out.println("\nIt is " + playerTurn + "'s turn");
	    System.out.println(playerTurn + " has " + findTroopNum(playerTurn) + " troops left to place\n");
	    System.out.println("Type the territory to place troops:");	
	    String initTerritory = cs1.Keyboard.readString();
	    while (territoryGraph.validTerritory(initTerritory) == false){
		System.out.println("The territory that you entered is incorrect and does not exist. Please try again.");
		initTerritory = cs1.Keyboard.readString();
	    }
	    while(territoryGraph.validTerritory(initTerritory) == false ||
			(!(game.territory[game.findLocation(initTerritory)][2].equals("no")) &&
			 !(game.territory[game.findLocation(initTerritory)][2].equals(playerTurn)))){
				System.out.println("You had entered an invalid territory or that territory has already been taken. Please try again.");
				initTerritory = cs1.Keyboard.readString();
	    }
	    if(game.territory[game.findLocation(initTerritory)][2] == "no" ||
	       game.territory[game.findLocation(initTerritory)][2] == playerTurn){
		int locat = game.findLocation(initTerritory);
		game.territory[locat][1] = Integer.toString(Integer.parseInt(game.territory[locat][1]) + 1);
		game.territory[locat][2] = playerTurn;
		System.out.println(game.territory[locat][1]);
		System.out.println("You have placed one troop on territory: " + initTerritory);
		System.out.println(game.territory[locat][1]);
	    }
	    terriInfo = game.getTerritoryInfo();
	    troopPresent = game.troopPresent();
	    //update territories
	    if (playerTurn.equals("player1")){
		player1Occupied = game.terriOccupier(playerTurn);
	    }
	    if (playerTurn.equals("player2")){
		player2Occupied = game.terriOccupier(playerTurn);
	    }
	    if (playerTurn.equals("player3")){
		player3Occupied = game.terriOccupier(playerTurn);
	    }
	    if (playerTurn.equals("player4")){
		player4Occupied = game.terriOccupier(playerTurn);
	    }
	    if (playerTurn.equals("player5")){
		player5Occupied = game.terriOccupier(playerTurn);
	    }
	    if (playerTurn.equals("player6")){
		player6Occupied = game.terriOccupier(playerTurn);
	    }
	    // update troopNumbers
	    player1TroopNum = game.troopNumber("player1");
	    player2TroopNum = game.troopNumber("player2");
	    player3TroopNum = game.troopNumber("player3");
	    player4TroopNum = game.troopNumber("player4");
	    player5TroopNum = game.troopNumber("player5");
	    player6TroopNum = game.troopNumber("player6");
	    // update territoryNumbers
	    player1TerritoryNum = game.territoryNumber("player1");
	    player2TerritoryNum = game.territoryNumber("player2");
	    player3TerritoryNum = game.territoryNumber("player3");
	    player4TerritoryNum = game.territoryNumber("player4");
	    player5TerritoryNum = game.territoryNumber("player5");
	    player6TerritoryNum = game.territoryNumber("player6");
	    
	    renderMap();
	    rounds+=1;
	    if (player1InitialTroop == 0 || player2InitialTroop == 0 || player3InitialTroop == 0 || player4InitialTroop == 0 || 
		player5InitialTroop == 0 || player6InitialTroop == 0){
		    break;
	    } 
	    subtractTroops(playerTurn);
	}
	
	//game loop until victory
	while ((int)(victoryMargin * 42) > game.territoryNumber(playerOrder.get(rounds % playerOrder.size()))){
		//placement feature
		
		// uncomment later
		// playerTurn = playerOrder.get(rounds % playerOrder.size());
		// int additionalTroops = Territory.calcAddTroops(playerTurn);
		// while (additionalTroops > 0){
			// System.out.println(playerTurn + " may place " + additionalTroops + " more additional troops.");
			// System.out.println("Type the territory to place troops:");	
			// String placeTerritory = cs1.Keyboard.readString();
			// while (territoryGraph.validTerritory(placeTerritory) == false){
			// System.out.println("The territory that you entered is incorrect and does not exist. Please try again.");
			// placeTerritory = cs1.Keyboard.readString();
			// }
			// while(territoryGraph.validTerritory(placeTerritory) == false ||
				// (!(game.territory[game.findLocation(placeTerritory)][2].equals("no")) &&
				 // !(game.territory[game.findLocation(placeTerritory)][2].equals(playerTurn)))){
					// System.out.println("You had entered an invalid territory or that territory has already been taken. Please try again.");
					// placeTerritory = cs1.Keyboard.readString();
			// }
			// if (game.territory[game.findLocation(placeTerritory)][2].equals("no")){
				// game.territory[game.findLocation(placeTerritory)][2] = playerTurn;
				// System.out.println(game.territory[game.findLocation(placeTerritory)][2]);
				// int initTroopNum = Integer.parseInt(game.territory[game.findLocation(placeTerritory)][1]);
				// game.territory[game.findLocation(placeTerritory)][1] = Integer.toString(initTroopNum + 1);
				// additionalTroops -= 1;
			// }
			// else{
				// int initTroopNum = Integer.parseInt(game.territory[game.findLocation(placeTerritory)][1]);
				// game.territory[game.findLocation(placeTerritory)][1] = Integer.toString(initTroopNum + 1);
				// additionalTroops -= 1;
			// }		
			
			// terriInfo = game.getTerritoryInfo();
			// troopPresent = game.troopPresent();
			// update territories
			// if (playerTurn.equals("player1")){
			// player1Occupied = game.terriOccupier(playerTurn);
			// }
			// if (playerTurn.equals("player2")){
			// player2Occupied = game.terriOccupier(playerTurn);
			// }
			// if (playerTurn.equals("player3")){
			// player3Occupied = game.terriOccupier(playerTurn);
			// }
			// if (playerTurn.equals("player4")){
			// player4Occupied = game.terriOccupier(playerTurn);
			// }
			// if (playerTurn.equals("player5")){
			// player5Occupied = game.terriOccupier(playerTurn);
			// }
			// if (playerTurn.equals("player6")){
			// player6Occupied = game.terriOccupier(playerTurn);
			// }
			
			// update troopNumbers
			// player1TroopNum = game.troopNumber("player1");
			// player2TroopNum = game.troopNumber("player2");
			// player3TroopNum = game.troopNumber("player3");
			// player4TroopNum = game.troopNumber("player4");
			// player5TroopNum = game.troopNumber("player5");
			// player6TroopNum = game.troopNumber("player6");
			// update territoryNumbers
			// player1TerritoryNum = game.territoryNumber("player1");
			// player2TerritoryNum = game.territoryNumber("player2");
			// player3TerritoryNum = game.territoryNumber("player3");
			// player4TerritoryNum = game.territoryNumber("player4");
			// player5TerritoryNum = game.territoryNumber("player5");
			// player6TerritoryNum = game.territoryNumber("player6");
			// renderMap(); //render map
	    // }
	    
	    //attack feature
	    int numPlay = 1;
	    while (numPlay >= 0){
		System.out.println("\nIt is " + playerTurn + "'s turn");
		System.out.println("\nType the territory to send troops from");
		String location = cs1.Keyboard.readString();
		while (Territory.findLocation(location) == -1){ // need another feature : this territory is not yours
		    System.out.println("\nSorry, this location is invalid, please try again");
		    location = cs1.Keyboard.readString();
		}
		System.out.println("\nType the territory that you want to attack");
		String target = cs1.Keyboard.readString();
		while (Territory.findLocation(target) == -1){ // need another feature : this territory is yours
		    System.out.println("\nSorry, this location is invalid, please try again");
		    target = cs1.Keyboard.readString();
		}
		System.out.println("\nType the number of troops to use, you can use a maximum of 3");
		int attTroops = cs1.Keyboard.readInt();
		while (attTroops > 3){
		    System.out.println("Sorry, you can only have a maximum number of 3, please try again");
		    attTroops = cs1.Keyboard.readInt();
		}
		while (attTroops < 1){
		    System.out.println("Sorry, you need at least a minimum number of 1, please try again");
		    attTroops = cs1.Keyboard.readInt();
		}
		int numWin = 0;
		String defense = Territory.findOwner(target);
		if (playerTurn.equals("player1")){
		    numWin = attack(attTroops,target,location, playerTurn, defense);
		}
		if (playerTurn.equals("player2")){
		    numWin = attack(attTroops,target,location, playerTurn, defense);
		}
		if (playerTurn.equals("player3")){
		    numWin = attack(attTroops,target,location, playerTurn, defense);
		}
		if (playerTurn.equals("player4")){
		    numWin = attack(attTroops,target,location, playerTurn, defense);
		}
		if (playerTurn.equals("player5")){
		    numWin = attack(attTroops,target,location, playerTurn, defense);
		}
		if (playerTurn.equals("player6")){
		    numWin = attack(attTroops,target,location, playerTurn, defense);
		}
		// updates
		boolean conquer;
		conquer = Territory.updateStat(target, playerTurn, numWin);
		if (conquer){
		    game.territory[game.findLocation(target)][2] = playerTurn;
		}
		//update(playerTurn);
		renderMap();
		
		numPlay -= 1;
	    }
	    
	    rounds+=1;
	}
	
	
    
    }
    
    //*******************************************************************************
    public static void startGame() throws FileNotFoundException {	
	//print game cover in terminal
	File text1 = new File("Cover.txt");
	Scanner scanner1 = new Scanner(text1);
	while (scanner1.hasNextLine()){
	    String line1 = scanner1.nextLine();
	    System.out.println(line1);
	}
	
	//Enter StartText
	System.out.println("Type start to Begin:");	
	String startText = cs1.Keyboard.readString();
	if (!startText.equals("start")){
	    System.out.println("Wrong input. Program has been terminated. Please try again.");
	    System.exit(0);
	}
	
	//Enter Game Information
	System.out.println("\n\nEnter Game Information");
	
	//Enter Player Information
	System.out.println("\nType in the number of players:");
	int playerNum = 0;
	while (numPlayer == 0){
	    try {
		playerNum = Integer.parseInt( cs1.Keyboard.readWord() );
	    }
	    catch (Exception e) {
		System.out.println("You had entered an invalid quantity. Please try again.");
	    }
	    if (playerNum > 1 && playerNum <= 6){
		numPlayer = playerNum;
	    }
	    else{
		System.out.println("You had entered an invalid range. Please try again.");
	    }
	}
	
	System.out.println("\nType in the percentage of territory occupied needed for a player to win:");
	System.out.println("It must be greater than 0.6666. Enter as a decimal like '0.75432'");
	double victory = 0.00;
	while (victory < 0.6666 || victory > 1.000){
		try {
		victoryMargin = Double.parseDouble( cs1.Keyboard.readWord() );
	    }
	    catch (Exception e) {
		System.out.println("You had entered an invalid quantity. Please try again.");
	    }
	    if (victoryMargin > 0.6666 && victoryMargin < 1.000){
		victory = victoryMargin;
	    }
	    else{
		System.out.println("You had entered an invalid range. Please try again.");
	    }
	}
	//set initial troops for placement for each player
	player1InitialTroop = Helper.setInitialTroops(numPlayer);
	player2InitialTroop = Helper.setInitialTroops(numPlayer);
	player3InitialTroop = Helper.setInitialTroops(numPlayer);
	player4InitialTroop = Helper.setInitialTroops(numPlayer);
	player5InitialTroop = Helper.setInitialTroops(numPlayer);
	player6InitialTroop = Helper.setInitialTroops(numPlayer);
	
	// create player order
	int uppCount = 1;
	while (uppCount <= numPlayer ){
	    playerOrder.add("player" + uppCount);
	    uppCount += 1;
	}
	playerOrder = Helper.randomize(playerOrder);
    }
    public static void renderMap() throws FileNotFoundException {
	// print world map in terminal
	
	File text2 = new File("WorldMap.txt");
	Scanner scanner2 = new Scanner(text2);
	while (scanner2.hasNextLine()){
	    String line2 = scanner2.nextLine();
	    
	    //Color Map
	    if (numPlayer >= 2){
		line2 = line2.replace("(BLUE)",ANSI_BLUE + "(BLUE)" + ANSI_RESET); //PLAYER 1
		line2 = line2.replace("Player 1:",ANSI_BLUE + "Player 1" + ANSI_RESET + ":"); //PLAYER 1
		line2 = line2.replace("(GREEN)",ANSI_GREEN + "(GREEN)" + ANSI_RESET); //PLAYER 2
		line2 = line2.replace("Player 2:",ANSI_GREEN + "Player 2" + ANSI_RESET + ":"); //PLAYER 2
	    }
	    if (numPlayer >= 3){
		line2 = line2.replace("(RED)",ANSI_RED + "(RED)" + ANSI_RESET); //PLAYER 3
		line2 = line2.replace("Player 3:",ANSI_RED + "Player 3" + ANSI_RESET + ":"); //PLAYER 3
	    }
	    if (numPlayer >= 4){
		line2 = line2.replace("(YELLOW)",ANSI_YELLOW + "(YELLOW)" + ANSI_RESET); //PLAYER 4
		line2 = line2.replace("Player 4:",ANSI_YELLOW + "Player 4" + ANSI_RESET + ":"); //PLAYER 4
	    }
	    if (numPlayer >= 5){
		line2 = line2.replace("(PURPLE)",ANSI_PURPLE + "(PURPLE)" + ANSI_RESET); //PLAYER 5
		line2 = line2.replace("Player 5:",ANSI_PURPLE + "Player 5" + ANSI_RESET + ":"); //PLAYER 5
	    }
	    if (numPlayer == 6){
		line2 = line2.replace("(CYAN)",ANSI_CYAN + "(CYAN)" + ANSI_RESET); //PLAYER 6
		line2 = line2.replace("Player 6:",ANSI_CYAN + "Player 6" + ANSI_RESET + ":"); //PLAYER 6
	    }	
	    for (int i = 0; i < troopPresent.size(); i++){
		String troops = terriInfo[troopPresent.get(i)][1];
		if (troops.length() == 1){
		    troops = "00" + troops;
		}
		if (troops.length() == 2){
		    troops = "0" + troops;
		}
		line2 = line2.replace(territoryGraph.TerritoryCode[troopPresent.get(i)], troops);
	    }
	    
	    //update player territories by color
	    for (int i = 0; i < player1Occupied.size(); i++){
		line2 = line2.replace(player1Occupied.get(i), ANSI_BLUE + player1Occupied.get(i) + ANSI_RESET);
	    }
	    for (int i = 0; i < player2Occupied.size(); i++){
		line2 = line2.replace(player2Occupied.get(i), ANSI_GREEN + player2Occupied.get(i) + ANSI_RESET);
	    }
	    for (int i = 0; i < player3Occupied.size(); i++){
		line2 = line2.replace(player3Occupied.get(i), ANSI_RED + player3Occupied.get(i) + ANSI_RESET);
	    }
	    for (int i = 0; i < player4Occupied.size(); i++){
		line2 = line2.replace(player4Occupied.get(i), ANSI_YELLOW + player4Occupied.get(i) + ANSI_RESET);
	    }
	    for (int i = 0; i < player5Occupied.size(); i++){
		line2 = line2.replace(player5Occupied.get(i), ANSI_PURPLE + player5Occupied.get(i) + ANSI_RESET);
	    }
	    for (int i = 0; i < player6Occupied.size(); i++){
		line2 = line2.replace(player6Occupied.get(i), ANSI_CYAN + player6Occupied.get(i) + ANSI_RESET);
	    }
	    
	    //update troopNumber Display
	    if (player1TroopNum > 0){				
		line2 = line2.replace("XX1", Helper.troopToString(player1TroopNum));
	    }
	    if (player2TroopNum > 0){				
		line2 = line2.replace("XX2", Helper.troopToString(player2TroopNum));
	    }
	    if (player3TroopNum > 0){				
				line2 = line2.replace("XX3", Helper.troopToString(player3TroopNum));
	    }
	    if (player4TroopNum > 0){				
		line2 = line2.replace("XX4", Helper.troopToString(player4TroopNum));
	    }
	    if (player5TroopNum > 0){				
		line2 = line2.replace("XX5", Helper.troopToString(player5TroopNum));
	    }
	    if (player6TroopNum > 0){				
		line2 = line2.replace("XX6", Helper.troopToString(player6TroopNum));
	    }
	    
	    //update territoryNumber Display
	    if (player1TerritoryNum > 0){				
		line2 = line2.replace("YY1", Helper.territoryToString(player1TerritoryNum));
	    }
	    if (player2TerritoryNum > 0){				
		line2 = line2.replace("YY2", Helper.territoryToString(player2TerritoryNum));
	    }
	    if (player3TerritoryNum > 0){				
		line2 = line2.replace("YY3", Helper.territoryToString(player3TerritoryNum));
	    }
	    if (player4TerritoryNum > 0){				
		line2 = line2.replace("YY4", Helper.territoryToString(player4TerritoryNum));
	    }
	    if (player5TerritoryNum > 0){				
		line2 = line2.replace("YY5", Helper.territoryToString(player5TerritoryNum));
	    }
	    if (player6TerritoryNum > 0){				
		line2 = line2.replace("YY6", Helper.territoryToString(player6TerritoryNum));
	    }
	    //print map line (final procedure)
	    System.out.println(line2);
	}
	/*
	//for move feature

		//move feature
    if (playerTurn.equals("player1")){
	occupied = player1Occupied;
    }
    if (playerTurn.equals("player2")){
	occupied = player2Occupied;
    }
    if (playerTurn.equals("player3")){
	occupied = player3Occupied;
    }
    if (playerTurn.equals("player4")){
	occupied = player4Occupied;
    }
    if (playerTurn.equals("player5")){
	occupied = player5Occupied;
    }
    if (playerTurn.equals("player6")){
	occupied = player6Occupied;
    }
	*/
    }
    //*******************************************************************************
    //helpful methods
    public static int findTroopNum(String player){
	if (player.equals("player1")){
	    return player1InitialTroop;
	}
	if (player.equals("player2")){
	    return player2InitialTroop;
	}
	if (player.equals("player3")){
	    return player3InitialTroop;
	}
	if (player.equals("player4")){
	    return player4InitialTroop;
	}
	if (player.equals("player5")){
	    return player5InitialTroop;
	}
	if (player.equals("player6")){
	    return player6InitialTroop;
	}
		return -1;
    } 
    public static void subtractTroops(String player){
	if (player.equals("player1")){
	    player1InitialTroop -= 1;
	}
	if (player.equals("player2")){
	    player2InitialTroop -= 1;
	}
	if (player.equals("player3")){
	    player3InitialTroop -= 1;
	}
	if (player.equals("player4")){
	    player4InitialTroop -= 1;
	}
	if (player.equals("player5")){
	    player5InitialTroop -= 1;
	}
	if (player.equals("player6")){
	    player6InitialTroop -= 1;
	}
    }
    /*
      attack- attack strength increases with numTroops
      random num generator 1 - 3 indicates successful attack
      random num generator 4 - 6 indicates failed attack
     */

    public static int attack(int attTroops, String territory, String location, String offense, String defense){
    	int attStat; //status of attack, win or fail
	int numWin = 0;
    	for (int ctr = 0; ctr < attTroops; ctr++){
    	    attStat = (int) (Math.random() * 6);
    	    if (attStat > 3){
		System.out.println("Offension win");
		Territory.subtract(territory); // defense lose 1 troop (variable in Territory)
		updateTroops(defense); // defense lose 1 troop (variable in Woo)
		numWin++;
    	    }
    	    else{
		System.out.println("Defense win");
    	        Territory.subtract(location); // offense lose 1 troop (variable in Territory)
		updateTroops(offense); // offense lose 1 troop (variable in Woo)
	    }
	}
	return numWin;
    }

    /*
    public static void move(ArrayList<String> occupied, int numTroops, String origin, String destination){
	for ( String terr : occupied ){
	    if (origin != terr){
		System.out.println("Sorry, you do not occupy " + origin + ". Please choose another territory to move your troops from.");
	    }
	}
	
	for ( String terr : occipied ) {
	    if (destination != terr) {
		System.out.println("Sorry, you do not occupy " + destination + ". Please choose another territory to move your troops to.");
	    }
	}
	//	if (numTroops @ origin  > 0){
	    //troops @ origin -= numToops;
	    //troops @destination += numTroops;

	}
	else{
	    System.out.println("Sorry, you do not have enough troops to move to the destination. Please try moving troops from a different territory.");

    }
    */
    
    public static void updateTroops(String player){
	if (player.equals("player1")){
	    player1TroopNum -= 1;
	}
	if (player.equals("player2")){
	    player2TroopNum -= 1;
	}
	if (player.equals("player3")){
	    player3TroopNum -= 1;
	}
	if (player.equals("player4")){
	    player4TroopNum -= 1;
	}
	if (player.equals("player5")){
	    player5TroopNum -= 1;
	}
	if (player.equals("player6")){
	    player6TroopNum -= 1;
	}
    }
    public static void subtractTerritory(String player){
	if (player.equals("player1")){
	    player1TerritoryNum -= 1;
	}
	if (player.equals("player2")){
	    player2TerritoryNum -= 1;
	}
	if (player.equals("player3")){
	    player3TerritoryNum -= 1;
	}
	if (player.equals("player4")){
	    player4TerritoryNum -= 1;
	}
	if (player.equals("player5")){
	    player5TerritoryNum -= 1;
	}
	if (player.equals("player6")){
	    player6TerritoryNum -= 1;
	}
    }
    /*
    public static void updateTerritory(String winner, String loser, String territory){
	if (player.equals("player1")){
	    player1TerritoryNum -= 1;
	}
	if (player.equals("player2")){
	    player2TerritoryNum -= 1;
	}
	if (player.equals("player3")){
	    player3TerritoryNum -= 1;
	}
	if (player.equals("player4")){
	    player4TerritoryNum -= 1;
	}
	if (player.equals("player5")){
	    player5TerritoryNum -= 1;
	}
	if (player.equals("player6")){
	    player6TerritoryNum -= 1;
	}
    }
    */
    public static void removeTerritory(String player, String territory){
	if (player.equals("player1")){
	    player1Occupied.remove(territory);
	}
	if (player.equals("player2")){
	    player2Occupied.remove(territory);
	}
	if (player.equals("player3")){
	    player3Occupied.remove(territory);
	}
	if (player.equals("player4")){
	    player4Occupied.remove(territory);
	}
	if (player.equals("player5")){
	    player5Occupied.remove(territory);
	}
	if (player.equals("player6")){
	    player6Occupied.remove(territory);
	}
    }
    public static void addTerritory(String player, String territory){
	if (player.equals("player1")){
	    player1Occupied.add(territory);
	}
	if (player.equals("player2")){
	    player2Occupied.add(territory);
	}
	if (player.equals("player3")){
	    player3Occupied.add(territory);
	}
	if (player.equals("player4")){
	    player4Occupied.add(territory);
	}
	if (player.equals("player5")){
	    player5Occupied.add(territory);
	}
	if (player.equals("player6")){
	    player6Occupied.add(territory);
	}
    }
    
}
