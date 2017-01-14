import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import cs1.Keyboard;

public class Woo {
    //class variables
    public static int numPlayer = 0;
	static ArrayList<String> playerOrder = new ArrayList<String>();
	static String playerTurn;
	static ArrayList<Integer> troopPresent = new ArrayList<Integer>();
	
	//initial Territories for placement of players
	public static int player1InitialTerr = -1;
	public static int player2InitialTerr = -1;
	public static int player3InitialTerr = -1;
	public static int player4InitialTerr = -1;
	public static int player5InitialTerr = -1;
	public static int player6InitialTerr = -1;
	
	//player occupied territories
	static ArrayList<String> player1Occupied = new ArrayList<String>();
	static ArrayList<String> player2Occupied = new ArrayList<String>();
	static ArrayList<String> player3Occupied = new ArrayList<String>();
	static ArrayList<String> player4Occupied = new ArrayList<String>();
	static ArrayList<String> player5Occupied = new ArrayList<String>();
	static ArrayList<String> player6Occupied = new ArrayList<String>();
	
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
		System.out.println("Order of Player: " + playerOrder.toString().substring(1,playerOrder.toString().length() - 1) + "\n");
		
		//initial placement of troops
		int initialRounds = 0;
		playerTurn = "player1";
		
		
		while (playerOrder.get(initialRounds % playerOrder.size()) != ""){
			if (player1InitialTerr == 0 || player2InitialTerr == 0 || player3InitialTerr == 0 || player4InitialTerr == 0 || 
			player5InitialTerr == 0 || player6InitialTerr == 0){
				break;
			} 
			playerTurn = playerOrder.get(initialRounds % playerOrder.size());
			System.out.println("Type the territory to place troops:");	
			String initTerritory = cs1.Keyboard.readString();
			System.out.println(territoryGraph.validTerritory(initTerritory));
			while (territoryGraph.validTerritory(initTerritory) == false){
				System.out.println("The territory that you entered is incorrect and does not exist. Please try again.");
				initTerritory = cs1.Keyboard.readString();
			}
			while(!(game.territory[game.findLocation(initTerritory)][2].equals("no")) &&
			!(game.territory[game.findLocation(initTerritory)][2].equals(playerTurn))){
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
			
			renderMap();
			initialRounds+=1;
			System.out.println(playerTurn);
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
		System.out.println("\nType in the number of players:");
		
		//Enter Player Information
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
		//set initial troops for placement for each player
		player1InitialTerr = Helper.setInitialTroops(numPlayer);
		player2InitialTerr = Helper.setInitialTroops(numPlayer);
		player3InitialTerr = Helper.setInitialTroops(numPlayer);
		player4InitialTerr = Helper.setInitialTroops(numPlayer);
		player5InitialTerr = Helper.setInitialTroops(numPlayer);
		player6InitialTerr = Helper.setInitialTroops(numPlayer);
		
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
			
			//print map
			System.out.println(line2);
		}
	}
//*******************************************************************************

	// public void initialPlacement(String Player){
		// System.out.println("Type the territory to place troops");	
		// String initTerritory = cs1.Keyboard.readString();
		// String[][] game.territory = game.getgame.territory();
		// while(territoryGraph.validTerritory(initTerritory) == false || 
		// (game.territory[game.findLocation(initTerritory)][2] != "no" &&
		// game.territory[game.findLocation(initTerritory)][2] != Player)){
			// System.out.println("You had entered an invalid territory or that territory has already been taken. Please try again.");
			// initTerritory = cs1.Keyboard.readString();
		// }
		// if(game.territory[game.findLocation(initTerritory)][2] == "no" ||
		// game.territory[game.findLocation(initTerritory)][2] == Player){
			// System.out.println("You have placed one troop on territory: " + initTerritory);
			// int locat = game.findLocation(initTerritory);
			// game.territory[locat][1] = Integer.toString(Integer.parseInt(game.territory[locat][1]) + 1);
			// game.territory[locat][2] = Player;
			// System.out.println(game.territory[locat][1]);
		// }
		
	// }
}
