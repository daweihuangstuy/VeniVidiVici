import java.util.ArrayList;

public class Territory{
    public static String[][] territory = new String[42][3];
    public static String[][] connect = new String[42][6];
    public Territory(){	
	// initialize territory
	territory[0][0] = "A11"; territory[0][1] = "0"; territory[0][2] = "no";
	territory[1][0] = "A12"; territory[1][1] = "0"; territory[1][2] = "no";
	territory[2][0] = "A13"; territory[2][1] = "0"; territory[2][2] = "no";
	territory[3][0] = "A14"; territory[3][1] = "0"; territory[3][2] = "no";
	territory[4][0] = "A15"; territory[4][1] = "0"; territory[4][2] = "no";
	territory[5][0] = "A16"; territory[5][1] = "0"; territory[5][2] = "no";
	territory[6][0] = "A17"; territory[6][1] = "0"; territory[6][2] = "no";
	territory[7][0] = "A18"; territory[7][1] = "0"; territory[7][2] = "no";
	territory[8][0] = "A19"; territory[8][1] = "0"; territory[8][2] = "no";
	territory[9][0] = "B11";territory[9][1] = "0";territory[9][2] = "no";
	territory[10][0] = "B12";territory[10][1] = "0";territory[10][2] = "no";
	territory[11][0] = "B13";territory[11][1] = "0";territory[11][2] = "no";
	territory[12][0] = "B14";territory[12][1] = "0";territory[12][2] = "no";
	territory[13][0] = "C11";territory[13][1] = "0";territory[13][2] = "no";
	territory[14][0] = "C12";territory[14][1] = "0";territory[14][2] = "no";
	territory[15][0] = "C13";territory[15][1] = "0";territory[15][2] = "no";
	territory[16][0] = "C14";territory[16][1] = "0";territory[16][2] = "no";
	territory[17][0] = "C15";territory[17][1] = "0";territory[17][2] = "no";
	territory[18][0] = "C16";territory[18][1] = "0";territory[18][2] = "no";
	territory[19][0] = "C17";territory[19][1] = "0";territory[19][2] = "no";
	territory[20][0] = "D11";territory[20][1] = "0";territory[20][2] = "no";
	territory[21][0] = "D12";territory[21][1] = "0";territory[21][2] = "no";
	territory[22][0] = "D13";territory[22][1] = "0";territory[22][2] = "no";
	territory[23][0] = "D14";territory[23][1] = "0";territory[23][2] = "no";
	territory[24][0] = "D15";territory[24][1] = "0";territory[24][2] = "no";
	territory[25][0] = "D16";territory[25][1] = "0";territory[25][2] = "no";
	territory[26][0] = "E11";territory[26][1] = "0";territory[26][2] = "no";
	territory[27][0] = "E12";territory[27][1] = "0";territory[27][2] = "no";
	territory[28][0] = "E13";territory[28][1] = "0";territory[28][2] = "no";
	territory[29][0] = "E14";territory[29][1] = "0";territory[29][2] = "no";
	territory[30][0] = "E15";territory[30][1] = "0";territory[30][2] = "no";
	territory[31][0] = "E16";territory[31][1] = "0";territory[31][2] = "no";
	territory[32][0] = "E17";territory[32][1] = "0";territory[32][2] = "no";
	territory[33][0] = "E18";territory[33][1] = "0";territory[33][2] = "no";
	territory[34][0] = "E19";territory[34][1] = "0";territory[34][2] = "no";
	territory[35][0] = "E21";territory[35][1] = "0";territory[35][2] = "no";
	territory[36][0] = "E22";territory[36][1] = "0";territory[36][2] = "no";
	territory[37][0] = "E23";territory[37][1] = "0";territory[37][2] = "no";
	territory[38][0] = "F11";territory[38][1] = "0";territory[38][2] = "no";
	territory[39][0] = "F12";territory[39][1] = "0";territory[39][2] = "no";
	territory[40][0] = "F13";territory[40][1] = "0";territory[40][2] = "no";
	territory[41][0] = "F14";territory[41][1] = "0";territory[41][2] = "no";
    }
    
    public String[][] getTerritoryInfo(){
	return territory;
    }
    
	// return the territory index of a given location
    public static int findLocation(String location){
	for (int i = 0; i < territory.length; i++){
	    if (territory[i][0].equals(location)){
		return i;
	    }
	}
	return -1;
    }
    
	// returns an ArrayList of occupied territories with Troops
    public ArrayList<Integer> troopPresent (){
	ArrayList<Integer> arr1 = new ArrayList<Integer>();
	for (int i = 0; i < territory.length; i++){
	    if (Integer.parseInt(territory[i][1]) > 0){
		arr1.add(i);
	    }
	}
	return arr1;
    }
    
	// returns an ArrayList of territories occupied by a player
    public ArrayList<String> terriOccupier (String occupier){
	ArrayList<String> arr2 = new ArrayList<String>();
	for (int i = 0; i < territory.length; i++){
	    if (territory[i][2].equals(occupier)){
		arr2.add(territory[i][0]);
	    }
	}
	return arr2;
    }
    
	// returns the amount of troops a player has
    public static int troopNumber(String player){
	int troopNum = 0;
	for (int i = 0; i < territory.length; i++){
	    if (territory[i][2].equals(player)){
		troopNum += Integer.parseInt(territory[i][1]);
	    }
	}
	return troopNum;
    }
    
	// returns the number of territories a player has
    public static int territoryNumber(String player){
	int territoryNum = 0;
	for (int i = 0; i < territory.length; i++){
	    if (territory[i][2].equals(player)){
		territoryNum += 1;
	    }
	}
	return territoryNum;
    }
    
	// returns the target
    public static String findOwner(String target){
	for (int i = 0; i < territory.length; i++){
	    if (territory[i][0].equals(target)){
		return territory[i][0];
	    }
	}
	return "";
    }
    
	// subtracts troops from a location
    public static void subtract(String target){
	int loc = findLocation(target);
	int troops = Integer.parseInt(territory[loc][1]);
	System.out.println("\nBefore attack..." +
			   "\nTroops: " + troops +
			   "\nPosition: " + target);
	territory[loc][1] = (troops - 1) + "";
	System.out.println("\nAfter attack..." +
			   "\nTroops: " + territory[loc][1] +
			   "\nPosition: " + target);
	
    }
    
	//updates information after an attack
    public static boolean updateStat(String target, String offense, int numWin){
	int loc = findLocation(target);
	String defense = occupier(target);
	if (! territory[loc][2].equals("no")){
	    if (territory[loc][1].equals("0")){
		territory[loc][2] = offense;
		territory[loc][1] = numWin + "";
		//Woo.update(
		Woo.addTerritory(target, offense);
		Woo.removeTerritory(defense, target);
		return true;
	    }
	}
	else{
	    if (territory[loc][1].equals("0")){
		territory[loc][2] = offense;
		territory[loc][1] = numWin + "";
		Woo.addTerritory(target, offense);
		return true;
	    }
	}
	return false;
    }
	
	// checks to see if a player is victorious
    public static boolean isVictory (String player, double winMargin){
		if (territoryNumber(player) > (int)(winMargin * 42)){
		    return true;
		}
		else {
		    return false;
		}
    }    
	
	// returns the current occupier of a territory
    public static String occupier(String terr){
	return territory[findLocation(terr)][2];
    }
    
	// returns the amount of troops that could be added by a player at the start of the game
    public static int calcAddTroops (String player){
	int startTroops = 0;
	boolean NorthAmerica = true; //A
	boolean SouthAmerica = true; //B
	boolean Europe = true; //C
	boolean Africa = true; //D
	boolean Asia = true; //E
	boolean Australia = true; //F
	//check to see if player has a monopoly on any continents
	//check North America
	int index = 0;
	for (int i = index ; i <= 8; i++){
	    NorthAmerica = occupier((territoryGraph.Territories[i])).equals(player);
	    if (NorthAmerica == false){
		break;
	    } 
	}
	//check South America
	index = 9;
	for (int i = index ; i <= 12; i++){
			SouthAmerica = occupier((territoryGraph.Territories[i])).equals(player);
			if (SouthAmerica == false){
			    break;
			} 
	}
	//check Europe
	index = 13;
	for (int i = index ; i <= 19; i++){
	    Europe = occupier((territoryGraph.Territories[i])).equals(player);
	    if (Europe == false){
		break;
	    } 
	}
	//check Africa
	index = 20;
	for (int i = index ; i <= 25; i++){
			Africa = occupier((territoryGraph.Territories[i])).equals(player);
			if (Africa == false){
			    break;
			} 
	}
	//check Asia
	index = 26;
		for (int i = index ; i <= 37; i++){
		    Asia = occupier((territoryGraph.Territories[i])).equals(player);
		    if (Asia == false){
			break;
		    } 
		}
		//check Australia
		index = 38;
		for (int i = index ; i <= 41; i++){
		    Australia = occupier((territoryGraph.Territories[i])).equals(player);
		    if (Australia == false){
			break;
		    } 
		}
		
		if (NorthAmerica == true){
		    startTroops += 5;
		}
		if (SouthAmerica == true){
		    startTroops += 2;
		}
		if (Europe == true){
		    startTroops += 3;
		}
		if (Africa == true){
		    startTroops += 3;
		}
		if (Asia == true){
		    startTroops += 7;
		}
		if (Australia == true){
		    startTroops += 2;
		}
		
		int terrBonus = (int)((double)(territoryNumber(player)) / 3);
		if (terrBonus <= 3){
		    startTroops += 3;
		}
		else {
		    startTroops += terrBonus;
		}
		return startTroops;
    }

	// returns an ArrayList of avaliable territories for autoPlace to randomly place
	public static ArrayList<String> availTerr(String player){
	ArrayList<String> tempArr = new ArrayList<String>();
	for (int i = 0; i < territory.length; i++){
		if(territory[i][2].equals(player) || territory[i][2].equals("no")){
			tempArr.add(territory[i][0]);
		}
	}
	return tempArr;
}

	// returns the player or no players that currently occupy a specified continent
	public static String occupyContinent(String continent){
		String defaultPlayer;
		//NorthAmerica
		if (continent.equals("NorthAmerica")){
			defaultPlayer = occupier((territoryGraph.Territories[0]));
			for (int i = 0 ; i <= 8; i++){
				if (!(defaultPlayer.equals(occupier((territoryGraph.Territories[i]))))){
					return "none";
				}
			}
			return defaultPlayer;
		}
		
		//SouthAmerica
		if (continent.equals("SouthAmerica")){
			defaultPlayer = occupier((territoryGraph.Territories[9]));
			for (int i = 9 ; i <= 12; i++){
				if (!(defaultPlayer.equals(occupier((territoryGraph.Territories[i]))))){
					return "none";
				}
			}
			return defaultPlayer;
		}
		
		//Europe
		if (continent.equals("Europe")){
			defaultPlayer = occupier((territoryGraph.Territories[13]));
			for (int i = 13 ; i <= 19; i++){
				if (!(defaultPlayer.equals(occupier((territoryGraph.Territories[i]))))){
					return "none";
				}
			}
			return defaultPlayer;
		}
		
		//Africa
		if (continent.equals("Africa")){
			defaultPlayer = occupier((territoryGraph.Territories[20]));
			for (int i = 20 ; i <= 25; i++){
				if (!(defaultPlayer.equals(occupier((territoryGraph.Territories[i]))))){
					return "none";
				}
			}
			return defaultPlayer;
		}
		
		//Asia
		if (continent.equals("Asia")){
			defaultPlayer = occupier((territoryGraph.Territories[20]));
			for (int i = 26 ; i <= 37; i++){
				if (!(defaultPlayer.equals(occupier((territoryGraph.Territories[i]))))){
					return "none";
				}
			}
			return defaultPlayer;
		}
		
		//Australia
		if (continent.equals("Australia")){
			defaultPlayer = occupier((territoryGraph.Territories[38]));
			for (int i = 38 ; i <= 41; i++){
				if (!(defaultPlayer.equals(occupier((territoryGraph.Territories[i]))))){
					return "none";
				}
			}
			return defaultPlayer;
		}
		return "playerNull";
	}
	
	//returns true if a player owns the given territory, false otherwise.
	public static boolean playerOwned(String player12, String Terr){
		return territory[findLocation(Terr)][2].equals(player12);
	}
	
	// returns true if it is a valid Connection, false otherwise. (method exclusive to the move feature)
	public static boolean validConnection(String player, String initTerritory, String finTerritory){
		int iteratorCount = 0;
		ArrayList<String> masterCon = new ArrayList<String>();
		masterCon.add(initTerritory);
		for(int i = 0; i < masterCon.size(); i++){
			masterCon.addAll(territoryGraph.connectedTerr(masterCon.get(i)));
				for(int a = 0; a < masterCon.size(); a++){
				if (playerOwned(player, masterCon.get(a)) == false){
					masterCon.remove(a);
					a -= 1;
				}
			}
			if (iteratorCount == 200){
				break;
			}
			iteratorCount += 1;
		}
		for (int x = 0; x < masterCon.size(); x++){
			if (masterCon.get(x).equals(finTerritory)){
				return true;
			}
		}
		return false;
	}
}
