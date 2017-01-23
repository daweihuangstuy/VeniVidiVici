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
    
    //playerOccupied Continents
    static String occupiedNorthAmerica = "none";
    static String occupiedSouthAmerica = "none";
    static String occupiedAfrica = "none";
    static String occupiedAsia = "none";
    static String occupiedEurope = "none";
    static String occupiedAustralia = "none";
    
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
	boolean autoPlace = false;
	
	while (playerOrder.get(rounds % playerOrder.size()) != ""){
		endGame();
	    playerTurn = playerOrder.get(rounds % playerOrder.size());
		String playColor = playerColor(playerTurn);
	    System.out.println("Order of Play: " + playerOrder.toString().substring(1,playerOrder.toString().length() - 1));
	    System.out.println("\nIt is " + playColor + "'s turn");
	    System.out.println(playerTurn + " has " + findTroopNum(playerTurn) + " troops left to place\n");
	    System.out.println("Type the territory to place troops (To automatically place remaining troops, type 'autoPlace'): ");	
	    String initTerritory = cs1.Keyboard.readString();
		if (initTerritory.equals("autoPlace")){
			autoPlace = true;
		}
	    while (territoryGraph.validTerritory(initTerritory) == false && autoPlace == false){
		System.out.println("The territory that you entered is incorrect and does not exist. Please try again.");
		initTerritory = cs1.Keyboard.readString();
		if (initTerritory.equals("autoPlace")){
			System.out.println("hello");
			autoPlace = true;
		}
	    }
	    while((territoryGraph.validTerritory(initTerritory) == false ||
			(!(game.territory[game.findLocation(initTerritory)][2].equals("no")) &&
			 !(game.territory[game.findLocation(initTerritory)][2].equals(playerTurn))))&& autoPlace == false){
				System.out.println("You had entered an invalid territory or that territory has already been taken. Please try again.");
				initTerritory = cs1.Keyboard.readString();
				if (initTerritory.equals("autoPlace")){
			autoPlace = true;
		}
	    }
		
		if (autoPlace == false){
			endGame();
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
			
			//update continentOccupied
			occupiedNorthAmerica = game.occupyContinent("NorthAmerica");
			occupiedSouthAmerica = game.occupyContinent("SouthAmerica");
			occupiedAfrica = game.occupyContinent("Africa");
			occupiedAsia = game.occupyContinent("Asia");
			occupiedEurope = game.occupyContinent("Europe");
			occupiedAustralia = game.occupyContinent("Australia");
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
			subtractTroops(playerTurn);
			if (initPlaceArmNum() == (playerOrder.size())){
				break;
			} 
			endGame();
		}
		if (autoPlace == true){
			break;
		}
	}
	
	//autoPlace feature for initial placement
	if (autoPlace == true){
		endGame();
		 while (!(initPlaceArmNum() == (playerOrder.size()))){
				endGame();
				playerTurn = playerOrder.get(rounds % playerOrder.size());
				int availNumber = (int)(Math.random() * Territory.availTerr(playerTurn).size());
				int availToTerrNum = Territory.findLocation(Territory.availTerr(playerTurn).get(availNumber));
				int initialTroopNum = Integer.parseInt(game.territory[availToTerrNum][1]);
				game.territory[availToTerrNum][2] = playerTurn;
				game.territory[availToTerrNum][1] = Integer.toString(initialTroopNum + 1);
				
				terriInfo = game.getTerritoryInfo();
			troopPresent = game.troopPresent();
			//update continentOccupied
			occupiedNorthAmerica = game.occupyContinent("NorthAmerica");
			occupiedSouthAmerica = game.occupyContinent("SouthAmerica");
			occupiedAfrica = game.occupyContinent("Africa");
			occupiedAsia = game.occupyContinent("Asia");
			occupiedEurope = game.occupyContinent("Europe");
			occupiedAustralia = game.occupyContinent("Australia");
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
				
				subtractTroops(playerTurn);
				rounds += 1;
				endGame();
			}
			endGame();
			autoPlace = false;
			renderMap();
	}
	
	//game loop until victory
	while ((int)(victoryMargin * 42) > game.territoryNumber(playerOrder.get(rounds % playerOrder.size()))){
		//placement feature
		
		endGame();
		playerTurn = playerOrder.get(rounds % playerOrder.size());
		String playColor = playerColor(playerTurn);
		int additionalTroops = Territory.calcAddTroops(playerTurn);
		while (additionalTroops > 0){
			System.out.println(playColor + " may place " + additionalTroops + " more additional troops.");
			System.out.println("Type the territory to place troops  (To automatically place remaining troops, type 'autoPlace'):");	
			String placeTerritory = cs1.Keyboard.readString();
			if (placeTerritory.equals("autoPlace")){
				autoPlace = true;
			}
			while (territoryGraph.validTerritory(placeTerritory) == false && autoPlace == false){
			System.out.println("The territory that you entered is incorrect and does not exist. Please try again.");
			placeTerritory = cs1.Keyboard.readString();
			if (placeTerritory.equals("autoPlace")){
				autoPlace = true;
			}
			}
			while((territoryGraph.validTerritory(placeTerritory) == false ||
				(!(game.territory[game.findLocation(placeTerritory)][2].equals("no")) &&
				 !(game.territory[game.findLocation(placeTerritory)][2].equals(playerTurn)))) && autoPlace == false){
					System.out.println("You had entered an invalid territory or that territory has already been taken. Please try again.");
					placeTerritory = cs1.Keyboard.readString();
					if (placeTerritory.equals("autoPlace")){
				autoPlace = true;
			}
			}
			
			if (autoPlace == false){
				endGame();
				if (game.territory[game.findLocation(placeTerritory)][2].equals("no")){
					endGame();
					game.territory[game.findLocation(placeTerritory)][2] = playerTurn;
					System.out.println(game.territory[game.findLocation(placeTerritory)][2]);
					int initTroopNum = Integer.parseInt(game.territory[game.findLocation(placeTerritory)][1]);
					game.territory[game.findLocation(placeTerritory)][1] = Integer.toString(initTroopNum + 1);
					additionalTroops -= 1;
					endGame();
				}
				else{
					endGame();
					int initTroopNum = Integer.parseInt(game.territory[game.findLocation(placeTerritory)][1]);
					game.territory[game.findLocation(placeTerritory)][1] = Integer.toString(initTroopNum + 1);
					additionalTroops -= 1;
					endGame();
				}		
			}
			
			terriInfo = game.getTerritoryInfo();
			troopPresent = game.troopPresent();

			
			//update continentOccupied
			occupiedNorthAmerica = game.occupyContinent("NorthAmerica");
			occupiedSouthAmerica = game.occupyContinent("SouthAmerica");
			occupiedAfrica = game.occupyContinent("Africa");
			occupiedAsia = game.occupyContinent("Asia");
			occupiedEurope = game.occupyContinent("Europe");
			occupiedAustralia = game.occupyContinent("Australia");
			//	update territories

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
			// player1TroopNum = game.troopNumber("player1");

			//	update troopNumbers
			player1TroopNum = game.troopNumber("player1");
			player2TroopNum = game.troopNumber("player2");
			player3TroopNum = game.troopNumber("player3");
			player4TroopNum = game.troopNumber("player4");
			player5TroopNum = game.troopNumber("player5");
			player6TroopNum = game.troopNumber("player6");

			//	update territoryNumbers
			player1TerritoryNum = game.territoryNumber("player1");
			player2TerritoryNum = game.territoryNumber("player2");
			player3TerritoryNum = game.territoryNumber("player3");
			player4TerritoryNum = game.territoryNumber("player4");
			player5TerritoryNum = game.territoryNumber("player5");
			player6TerritoryNum = game.territoryNumber("player6");
			renderMap(); //render map
			endGame();
			
		//autoPlace feature for round placement
		if (autoPlace == true){
			 while (additionalTroops > 0){
				 endGame();
					playerTurn = playerOrder.get(rounds % playerOrder.size());
					int availNumber = (int)(Math.random() * Territory.availTerr(playerTurn).size());
					int availToTerrNum = Territory.findLocation(Territory.availTerr(playerTurn).get(availNumber));
					int initialTroopNum = Integer.parseInt(game.territory[availToTerrNum][1]);
					game.territory[availToTerrNum][2] = playerTurn;
					game.territory[availToTerrNum][1] = Integer.toString(initialTroopNum + 1);
					
					terriInfo = game.getTerritoryInfo();
				troopPresent = game.troopPresent();
				// update territories
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
				//update continentOccupied
				occupiedNorthAmerica = game.occupyContinent("NorthAmerica");
				occupiedSouthAmerica = game.occupyContinent("SouthAmerica");
				occupiedAfrica = game.occupyContinent("Africa");
				occupiedAsia = game.occupyContinent("Asia");
				occupiedEurope = game.occupyContinent("Europe");
				occupiedAustralia = game.occupyContinent("Australia");
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
				
					additionalTroops -= 1;
					endGame();
				}
				endGame();
				autoPlace = false;
				renderMap();
		}
		}
	    
		
		
		
		
		
	    //attack feature
		endGame();
	    boolean button = true;
	    while (button == true){
		System.out.println("\nIt is " + playColor + "'s turn");
		System.out.println("\nType the territory to send troops from");
		String location = cs1.Keyboard.readString();
		while (game.findLocation(location) == -1 ||
		       !game.territory[game.findLocation(location)][2].equals(playerTurn) ||
		       game.territory[game.findLocation(location)][1].equals("1")){
		       
		       if (Territory.findLocation(location) == -1){ // need another feature : this territory is not yours
			   System.out.println("\nSorry, this location is invalid, please try again");
			   location = cs1.Keyboard.readString();
		       }
		       if (! game.territory[game.findLocation(location)][2].equals(playerTurn)){
			   System.out.println("\nSorry, this is not your territory, please try again");
			   location = cs1.Keyboard.readString();
		       }
		       if (game.territory[game.findLocation(location)][1].equals("1")){
			   System.out.println("\nSorry, you need at least 2 troops on this territory, please try again");
			   location = cs1.Keyboard.readString();
		       }
		}
		System.out.println("\nType the territory that you want to attack");
		String target = cs1.Keyboard.readString();

		territoryGraph.setUp();
		
		while (Territory.findLocation(target) == -1 ||
		       game.territory[game.findLocation(target)][2].equals(playerTurn) ||
		       territoryGraph.isConnect(location, target) == false){ // check is these two territories connected
		    if (Territory.findLocation(target) == -1){
			System.out.println("\nSorry, this location is invalid, please try again");
			target = cs1.Keyboard.readString();
		    }
		    if (game.territory[game.findLocation(target)][2].equals(playerTurn)){
			System.out.println("\nSorry, this is your territory, please try again");
			target = cs1.Keyboard.readString();
		    }
		    if (territoryGraph.isConnect(location, target) == false){ // check is these two territories connected
			System.out.println("Sorry, these two territories is not connected, please try again");
			target = cs1.Keyboard.readString();
		    }
		}
		System.out.println("\nType the number of troops to use, you can use a maximum of 3");
		int attTroops = cs1.Keyboard.readInt();
		while (attTroops > 3 || // check is the at most 3 troops
		       attTroops < 1 || // check is there at least 1 troop
		       Integer.parseInt(game.territory[game.findLocation(location)][1]) - attTroops == 0 || // check is there at least one troop to protect your territory
		       Integer.parseInt(game.territory[game.findLocation(location)][1]) - attTroops < 0){// check if this territory have enough troops
			if (attTroops > 3){
			System.out.println("Sorry, you can only have a maximum number of 3, please try again");
			attTroops = cs1.Keyboard.readInt();
		    }
		    if (attTroops < 1){
			System.out.println("Sorry, you need at least a minimum number of 1, please try again");
			   attTroops = cs1.Keyboard.readInt();
		    }
		    if (Integer.parseInt(game.territory[game.findLocation(location)][1]) - attTroops == 0){
			System.out.println("Sorry, you need at least 1 troops to protect you current territory, please try again");
			attTroops = cs1.Keyboard.readInt();
		    }
		    if (Integer.parseInt(game.territory[game.findLocation(location)][1]) - attTroops < 0){
			System.out.println("Sorry, you don't have enough troops in this territory, please try again");
			attTroops = cs1.Keyboard.readInt();
		    }
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
		//if (! Territory.territory[Territory.findLocation(target)][2].equals("no")){
		    boolean conquer;
		    conquer = Territory.updateStat(target, playerTurn, numWin);
		    if (conquer){
			game.territory[game.findLocation(target)][2] = playerTurn;
			game.territory[game.findLocation(location)][1] = Integer.parseInt(game.territory[game.findLocation(location)][1]) - attTroops + "";
		    }
		    //	}
		    //if (Territory.territory[Territory.findLocation(target)][2].equals("no")){
		    //game.territory[game.findLocation(target)][2] = playerTurn;
		    //game.territory[game.findLocation(target)][1] = numWin + "";
		    //game.territory[game.findLocation(location)][1] = Integer.parseInt(game.territory[game.findLocation(location)][1]) - attTroops + "";
		    //}
		//update(playerTurn);
		
		//update continentOccupied
		occupiedNorthAmerica = game.occupyContinent("NorthAmerica");
		occupiedSouthAmerica = game.occupyContinent("SouthAmerica");
		occupiedAfrica = game.occupyContinent("Africa");
		occupiedAsia = game.occupyContinent("Asia");
		occupiedEurope = game.occupyContinent("Europe");
		occupiedAustralia = game.occupyContinent("Australia");
		// update territories
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
		
		System.out.println(player1Occupied );
		System.out.println(player2Occupied );
		renderMap(); //render map here

		System.out.println("Do you want to continue on attacking? Type 'yes' to continue attack");
		String sta = cs1.Keyboard.readString();
		if (! sta.equals("yes")){
		    button = false;
		}
	    }
	    // renderMap();	    
		
		
		
		
		
		//Move Feature
	    String territorySelect;
		String troopSelect;
		String placeTerritory;
		String End = "";
		int moveNum = 0;
		
		while (End.equals("exit") == false){
			//select a territory to move
			System.out.println(playColor + " may move troops");
			System.out.println("Please select a territory to move troops");
			territorySelect = cs1.Keyboard.readString();
			while (territoryGraph.validTerritory(territorySelect) == false || game.occupier(territorySelect).equals(playerTurn) == false ||
			Integer.parseInt(game.territory[game.findLocation(territorySelect)][1]) <= 1){
				while (territoryGraph.validTerritory(territorySelect) == false){
					System.out.println("You had entered an invalid territory. Please try again");
					territorySelect = cs1.Keyboard.readString();
				}
				while (territoryGraph.validTerritory(territorySelect) == false || game.occupier(territorySelect).equals(playerTurn) == false){
					if (territoryGraph.validTerritory(territorySelect) == false){
						break;
					}
					System.out.println("You had selected a territory that you do not occupy. Please try again");
					territorySelect = cs1.Keyboard.readString();
				} 
				
				while ( territoryGraph.validTerritory(territorySelect) == false || game.occupier(territorySelect).equals(playerTurn) == false || 
				Integer.parseInt(game.territory[game.findLocation(territorySelect)][1]) <= 1){
					if (territoryGraph.validTerritory(territorySelect) == false){
						break;
					}
					if (game.occupier(territorySelect).equals(playerTurn) == false){
						break;
					}
					System.out.println("You cannot move if there is only one troop on a territory. Please try again.");
					territorySelect = cs1.Keyboard.readString();
				}
			}
			
			//select how much troops to move
			System.out.println("Please select how much troops " + playColor + " would like to move");
			troopSelect = cs1.Keyboard.readString();
			while (Helper.checkString(troopSelect) == false || (Integer.parseInt(troopSelect) > (Integer.parseInt(game.territory[game.findLocation(territorySelect)][1]) - 1))){
				while (Helper.checkString(troopSelect) == false){
					System.out.println("You entered an invalid quantity. Please try again.");
					troopSelect = cs1.Keyboard.readString();
				}
				while (Helper.checkString(troopSelect) == false || (Integer.parseInt(troopSelect) > (Integer.parseInt(game.territory[game.findLocation(territorySelect)][1]) - 1))){
					if (Helper.checkString(troopSelect) == false){
						break;
					}
					System.out.println("You must leave at least one troop on the territory when you move");
					troopSelect = cs1.Keyboard.readString();
				}
			}
			int newtroopSelect = Integer.parseInt(troopSelect);
			//select where to move your troops
			System.out.println("Please select the territory " + playColor + " would like to move to.");
			placeTerritory = cs1.Keyboard.readString();
			while (territoryGraph.validTerritory(placeTerritory) == false || game.occupier(placeTerritory).equals(playerTurn) == false){
				while (territoryGraph.validTerritory(placeTerritory) == false){
					System.out.println("You had entered an invalid territory. Please try again");
					placeTerritory = cs1.Keyboard.readString();
				}
				while (territoryGraph.validTerritory(placeTerritory) == false || game.occupier(placeTerritory).equals(playerTurn) == false){
					if (territoryGraph.validTerritory(placeTerritory) == false){
						break;
					}
					System.out.println("You had selected a territory that you do not occupy. Please try again");
					placeTerritory = cs1.Keyboard.readString();
				}
			}
			
			//update game storage
			int initialTroop = Integer.parseInt(game.territory[game.findLocation(territorySelect)][1]);
			game.territory[game.findLocation(territorySelect)][1] = Integer.toString(initialTroop - Integer.parseInt(troopSelect));
			
			int finalTroop = Integer.parseInt(game.territory[game.findLocation(placeTerritory)][1]);
			game.territory[game.findLocation(placeTerritory)][1] = Integer.toString(finalTroop + Integer.parseInt(troopSelect));
			
			// update territories
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
					//update continentOccupied
					occupiedNorthAmerica = game.occupyContinent("NorthAmerica");
					occupiedSouthAmerica = game.occupyContinent("SouthAmerica");
					occupiedAfrica = game.occupyContinent("Africa");
					occupiedAsia = game.occupyContinent("Asia");
					occupiedEurope = game.occupyContinent("Europe");
					occupiedAustralia = game.occupyContinent("Australia");
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
					
					System.out.println("Would you like to continue the game? Enter 'exit' to end turn. Enter anything else to continue moving.");
					End = cs1.Keyboard.readString();
		}
		
		
		endGame();
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
	System.out.println("It must be greater than or equal to 0.6666 and less than or equal to 1.0. Enter as a decimal like '0.75432'");
	double victory = 0.00;
	while (victory < 0.6666 || victory > 1.000){
		try {
		victoryMargin = Double.parseDouble( cs1.Keyboard.readWord() );
	    }
	    catch (Exception e) {
		System.out.println("You had entered an invalid quantity. Please try again.");
	    }
	    if (victoryMargin >= 0.6666 && victoryMargin <= 1.000){
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
		
		//update continent occupy display
		//update North America
		if (!(occupiedNorthAmerica.equals("none"))){
			if (occupiedNorthAmerica.equals("player1")){
				line2 = line2.replace("(Player x1)", ANSI_BLUE + "(Player 01)" + ANSI_RESET); //player1
			}
			if (occupiedNorthAmerica.equals("player2")){
				line2 = line2.replace("(Player x1)", ANSI_GREEN + "(Player 02)" + ANSI_RESET); //player2
			}
			if (occupiedNorthAmerica.equals("player3")){
				line2 = line2.replace("(Player x1)", ANSI_RED + "(Player 03)" + ANSI_RESET); //player3
			}
			if (occupiedNorthAmerica.equals("player4")){
				line2 = line2.replace("(Player x1)", ANSI_YELLOW + "(Player 04)" + ANSI_RESET); //player4
			}
			if (occupiedNorthAmerica.equals("player5")){
				line2 = line2.replace("(Player x1)", ANSI_PURPLE + "(Player 05)" + ANSI_RESET); //player5
			}
			if (occupiedNorthAmerica.equals("player6")){
				line2 = line2.replace("(Player x1)", ANSI_CYAN + "(Player 06)" + ANSI_RESET); //player6
			}
		}
		
		//update South America
		if (!(occupiedSouthAmerica.equals("none"))){
			if (occupiedSouthAmerica.equals("player1")){
				line2 = line2.replace("(Player x2)", ANSI_BLUE + "(Player 01)" + ANSI_RESET); //player1
			}
			if (occupiedSouthAmerica.equals("player2")){
				line2 = line2.replace("(Player x2)", ANSI_GREEN + "(Player 02)" + ANSI_RESET); //player2
			}
			if (occupiedSouthAmerica.equals("player3")){
				line2 = line2.replace("(Player x2)", ANSI_RED + "(Player 03)" + ANSI_RESET); //player3
			}
			if (occupiedSouthAmerica.equals("player4")){
				line2 = line2.replace("(Player x2)", ANSI_YELLOW + "(Player 04)" + ANSI_RESET); //player4
			}
			if (occupiedSouthAmerica.equals("player5")){
				line2 = line2.replace("(Player x2)", ANSI_PURPLE + "(Player 05)" + ANSI_RESET); //player5
			}
			if (occupiedSouthAmerica.equals("player6")){
				line2 = line2.replace("(Player x2)", ANSI_CYAN + "(Player 06)" + ANSI_RESET); //player6
			}
		}
		//update Africa
		if (!(occupiedAfrica.equals("none"))){
			if (occupiedAfrica.equals("player1")){
				line2 = line2.replace("(Player x3)", ANSI_BLUE + "(Player 01)" + ANSI_RESET); //player1
			}
			if (occupiedAfrica.equals("player2")){
				line2 = line2.replace("(Player x3)", ANSI_GREEN + "(Player 02)" + ANSI_RESET); //player2
			}
			if (occupiedAfrica.equals("player3")){
				line2 = line2.replace("(Player x3)", ANSI_RED + "(Player 03)" + ANSI_RESET); //player3
			}
			if (occupiedAfrica.equals("player4")){
				line2 = line2.replace("(Player x3)", ANSI_YELLOW + "(Player 04)" + ANSI_RESET); //player4
			}
			if (occupiedAfrica.equals("player5")){
				line2 = line2.replace("(Player x3)", ANSI_PURPLE + "(Player 05)" + ANSI_RESET); //player5
			}
			if (occupiedAfrica.equals("player6")){
				line2 = line2.replace("(Player x3)", ANSI_CYAN + "(Player 06)" + ANSI_RESET); //player6
			}
		}
		//update Asia
		if (!(occupiedAsia.equals("none"))){
			if (occupiedAsia.equals("player1")){
				line2 = line2.replace("(Player x4)", ANSI_BLUE + "(Player 01)" + ANSI_RESET); //player1
			}
			if (occupiedAsia.equals("player2")){
				line2 = line2.replace("(Player x4)", ANSI_GREEN + "(Player 02)" + ANSI_RESET); //player2
			}
			if (occupiedAsia.equals("player3")){
				line2 = line2.replace("(Player x4)", ANSI_RED + "(Player 03)" + ANSI_RESET); //player3
			}
			if (occupiedAsia.equals("player4")){
				line2 = line2.replace("(Player x4)", ANSI_YELLOW + "(Player 04)" + ANSI_RESET); //player4
			}
			if (occupiedAsia.equals("player5")){
				line2 = line2.replace("(Player x4)", ANSI_PURPLE + "(Player 05)" + ANSI_RESET); //player5
			}
			if (occupiedAsia.equals("player6")){
				line2 = line2.replace("(Player x4)", ANSI_CYAN + "(Player 06)" + ANSI_RESET); //player6
			}
		}
		//update Europe
		if (!(occupiedEurope.equals("none"))){
			if (occupiedEurope.equals("player1")){
				line2 = line2.replace("(Player x5)", ANSI_BLUE + "(Player 01)" + ANSI_RESET); //player1
			}
			if (occupiedEurope.equals("player2")){
				line2 = line2.replace("(Player x5)", ANSI_GREEN + "(Player 02)" + ANSI_RESET); //player2
			}
			if (occupiedEurope.equals("player3")){
				line2 = line2.replace("(Player x5)", ANSI_RED + "(Player 03)" + ANSI_RESET); //player3
			}
			if (occupiedEurope.equals("player4")){
				line2 = line2.replace("(Player x5)", ANSI_YELLOW + "(Player 04)" + ANSI_RESET); //player4
			}
			if (occupiedEurope.equals("player5")){
				line2 = line2.replace("(Player x5)", ANSI_PURPLE + "(Player 05)" + ANSI_RESET); //player5
			}
			if (occupiedEurope.equals("player6")){
				line2 = line2.replace("(Player x5)", ANSI_CYAN + "(Player 06)" + ANSI_RESET); //player6
			}
		}
		//update Australia
		if (!(occupiedAustralia.equals("none"))){
			if (occupiedAustralia.equals("player1")){
				line2 = line2.replace("(Player x6)", ANSI_BLUE + "(Player 01)" + ANSI_RESET); //player1
			}
			if (occupiedAustralia.equals("player2")){
				line2 = line2.replace("(Player x6)", ANSI_GREEN + "(Player 02)" + ANSI_RESET); //player2
			}
			if (occupiedAustralia.equals("player3")){
				line2 = line2.replace("(Player x6)", ANSI_RED + "(Player 03)" + ANSI_RESET); //player3
			}
			if (occupiedAustralia.equals("player4")){
				line2 = line2.replace("(Player x6)", ANSI_YELLOW + "(Player 04)" + ANSI_RESET); //player4
			}
			if (occupiedAustralia.equals("player5")){
				line2 = line2.replace("(Player x6)", ANSI_PURPLE + "(Player 05)" + ANSI_RESET); //player5
			}
			if (occupiedAustralia.equals("player6")){
				line2 = line2.replace("(Player x6)", ANSI_CYAN + "(Player 06)" + ANSI_RESET); //player6
			}
		}
		
		// update territoryPercentage Display
		double roundPlayer1 = Math.round((100 * (double)player1TerritoryNum/42)*100)/100; //player1
		double roundPlayer2 = Math.round((100 * (double)player2TerritoryNum/42)*100)/100; //player2
		double roundPlayer3 = Math.round((100 * (double)player3TerritoryNum/42)*100)/100; //player3
		double roundPlayer4 = Math.round((100 * (double)player4TerritoryNum/42)*100)/100; //player4
		double roundPlayer5 = Math.round((100 * (double)player5TerritoryNum/42)*100)/100; //player5
		double roundPlayer6 = Math.round((100 * (double)player6TerritoryNum/42)*100)/100; //player6
		double roundVictoryMargin = (Math.round(victoryMargin * 100)*100)/100; //player6
		
		line2 = line2.replace("ZZZZ1", Helper.terrToString(roundPlayer1)); //player1
		line2 = line2.replace("ZZZZ2", Helper.terrToString(roundPlayer2)); //player2
		line2 = line2.replace("ZZZZ3", Helper.terrToString(roundPlayer3)); //player3
		line2 = line2.replace("ZZZZ4", Helper.terrToString(roundPlayer4)); //player4
		line2 = line2.replace("ZZZZ5", Helper.terrToString(roundPlayer5)); //player5
		line2 = line2.replace("ZZZZ6", Helper.terrToString(roundPlayer6)); //player6
		line2 = line2.replace("ZZZZZ", Helper.terrToString(roundVictoryMargin)); //victory percent
	    //print map line (final procedure)
	    System.out.println(line2);
	}

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

    public static int attack(int attTroops, String target, String location, String offense, String defense){
    	int attStat; //status of attack, win or fail
	int numWin = 0;
	if (Territory.territory[Territory.findLocation(target)][2].equals("no")){
	  System.out.println("Offension win");
	  numWin = attTroops;
	}
	else{
	    for (int ctr = 0; ctr < attTroops; ctr++){
		attStat = (int) (Math.random() * 6);
		if (attStat >= 0){ //I (Dawei) changed this to guarentee victory for the attacker. MUST CHANGE IT BACK!!!
		    System.out.println("Offension win");
		    Territory.subtract(target); // defense lose 1 troop (variable in Territory)
		    updateTroops(defense); // defense lose 1 troop (variable in Woo)
		    numWin++;
		}
		else{
		    System.out.println("Defense win");
		    Territory.subtract(location); // offense lose 1 troop (variable in Territory)
		    updateTroops(offense); // offense lose 1 troop (variable in Woo)
		}
	    }
	}
	return numWin;	
    }
	
    
    //move
    /*
    //public ArrayList occupied = new ArrayList[][];
public static void move(ArrayList<String> occupied, int numTroops, String origin, String destination){

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


    int ctrO = 0;
    int ctrD = 0;
    for ( String terr : occupied ){
	if (origin == terr){
	    //ctrO = occupied.indexOf(origin);
	    // troopPresent[ctrO][]; //array --> array list
	    System.out.println("Moving troops from " + origin);
	}
	System.out.println("Sorry, you do not occupy " + origin + ". Please choose another territory to move your troops from.");	
    }
    for ( String terr : occupied ) {
	if (destination == terr) {
	    // ctrD = occupied.indexOf(destination);
	    //troopPresent[ctrD] += numTroops;
	    System.out.println("Moving troops to " + destination);
	}
	System.out.println("Sorry, you do not occupy " + destination + ". Please choose another territory to move your troops to.");
    }
    */
    
    // System.out.println("Sorry, you do not have enough troops to move to the destination. Please try moving troops from a different territory.");


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
	
	public static int initPlaceArmNum(){
		int nullCounter = 0;
		if (player1InitialTroop == 0){
			nullCounter += 1;
		}
		if (player2InitialTroop == 0){
			nullCounter += 1;
		}
		if (player3InitialTroop == 0){
			nullCounter += 1;
		}
		if (player4InitialTroop == 0){
			nullCounter += 1;
		}
		if (player5InitialTroop == 0){
			nullCounter += 1;
		}
		if (player6InitialTroop == 0){
			nullCounter += 1;
		}
		return nullCounter;
	}
	
	public static String playerColor(String player){
		if (player.equals("player1")){
			return (ANSI_BLUE + "player1" + ANSI_RESET);
		}
		if (player.equals("player2")){
			return (ANSI_GREEN + "player2" + ANSI_RESET);
		}
		if (player.equals("player3")){
			return (ANSI_RED + "player3" + ANSI_RESET);
		}
		if (player.equals("player4")){
			return (ANSI_YELLOW + "player4" + ANSI_RESET);
		}
		if (player.equals("player5")){
			return (ANSI_PURPLE + "player5" + ANSI_RESET);
		}
		if (player.equals("player6")){
			return (ANSI_CYAN + "player6" + ANSI_RESET);
		}
		return "playerNull";
	}
	
	public static void endGame(){
		//check to see if any player has won
		//check player1
		if ((int)(victoryMargin * 42) < player1TerritoryNum){
			System.out.println("\n\nplayer 1 has won the game");
			System.exit(0);
		}
		//check player2
		if ((int)(victoryMargin * 42) < player2TerritoryNum){
			System.out.println("\n\nplayer 2 has won the game");
			System.exit(0);
		}
		//check player3
		if ((int)(victoryMargin * 42) < player3TerritoryNum){
			System.out.println("\n\nplayer 3 has won the game");
			System.exit(0);
		}
		//check player4
		if ((int)(victoryMargin * 42) < player4TerritoryNum){
			System.out.println("\n\nplayer 4 has won the game");
			System.exit(0);
		}
		//check player5
		if ((int)(victoryMargin * 42) < player5TerritoryNum){
			System.out.println("\n\nplayer 5 has won the game");
			System.exit(0);
		}
		//check player6
		if ((int)(victoryMargin * 42) < player6TerritoryNum){
			System.out.println("\n\nplayer 1 has won the game");
			System.exit(0);
		}
	}
    
}
