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

	// initialize connect
	connect[0][0] = "A11"; connect[0][1] = "0"; connect[0][2] = "no";
	connect[1][0] = "A12"; connect[1][1] = "0"; connect[1][2] = "no";
	connect[2][0] = "A13"; connect[2][1] = "0"; connect[2][2] = "no";
	connect[3][0] = "A14"; connect[3][1] = "0"; connect[3][2] = "no";
	connect[4][0] = "A15"; connect[4][1] = "0"; connect[4][2] = "no";
	connect[5][0] = "A16"; connect[5][1] = "0"; connect[5][2] = "no";
	connect[6][0] = "A17"; connect[6][1] = "0"; connect[6][2] = "no";
	connect[7][0] = "A18"; connect[7][1] = "0"; connect[7][2] = "no";
	connect[8][0] = "A19"; connect[8][1] = "0"; connect[8][2] = "no";
	connect[9][0] = "B11"; connect[9][1] = "0"; connect[9][2] = "no";
	connect[10][0] = "B12";connect[10][1] = "0";connect[10][2] = "no";
	connect[11][0] = "B13";connect[11][1] = "0";connect[11][2] = "no";
	connect[12][0] = "B14";connect[12][1] = "0";connect[12][2] = "no";
	connect[13][0] = "C11";connect[13][1] = "0";connect[13][2] = "no";
	connect[14][0] = "C12";connect[14][1] = "0";connect[14][2] = "no";
	connect[15][0] = "C13";connect[15][1] = "0";connect[15][2] = "no";
	connect[16][0] = "C14";connect[16][1] = "0";connect[16][2] = "no";
	connect[17][0] = "C15";connect[17][1] = "0";connect[17][2] = "no";
	connect[18][0] = "C16";connect[18][1] = "0";connect[18][2] = "no";
	connect[19][0] = "C17";connect[19][1] = "0";connect[19][2] = "no";
	connect[20][0] = "D11";connect[20][1] = "0";connect[20][2] = "no";
	connect[21][0] = "D12";connect[21][1] = "0";connect[21][2] = "no";
	connect[22][0] = "D13";connect[22][1] = "0";connect[22][2] = "no";
	connect[23][0] = "D14";connect[23][1] = "0";connect[23][2] = "no";
	connect[24][0] = "D15";connect[24][1] = "0";connect[24][2] = "no";
	connect[25][0] = "D16";connect[25][1] = "0";connect[25][2] = "no";
	connect[26][0] = "E11";connect[26][1] = "0";connect[26][2] = "no";
	connect[27][0] = "E12";connect[27][1] = "0";connect[27][2] = "no";
	connect[28][0] = "E13";connect[28][1] = "0";connect[28][2] = "no";
	connect[29][0] = "E14";connect[29][1] = "0";connect[29][2] = "no";
	connect[30][0] = "E15";connect[30][1] = "0";connect[30][2] = "no";
	connect[31][0] = "E16";connect[31][1] = "0";connect[31][2] = "no";
	connect[32][0] = "E17";connect[32][1] = "0";connect[32][2] = "no";
	connect[33][0] = "E18";connect[33][1] = "0";connect[33][2] = "no";
	connect[34][0] = "E19";connect[34][1] = "0";connect[34][2] = "no";
	connect[35][0] = "E21";connect[35][1] = "0";connect[35][2] = "no";
	connect[36][0] = "E22";connect[36][1] = "0";connect[36][2] = "no";
	connect[37][0] = "E23";connect[37][1] = "0";connect[37][2] = "no";
	connect[38][0] = "F11";connect[38][1] = "0";connect[38][2] = "no";
	connect[39][0] = "F12";connect[39][1] = "0";connect[39][2] = "no";
	connect[40][0] = "F13";connect[40][1] = "0";connect[40][2] = "no";
	connect[41][0] = "F14";connect[41][1] = "0";connect[41][2] = "no";
    }
    
    public String[][] getTerritoryInfo(){
	return territory;
    }
    
    public static int findLocation(String location){
	for (int i = 0; i < territory.length; i++){
	    if (territory[i][0].equals(location)){
		return i;
	    }
	}
	return -1;
    }
    
    public ArrayList<Integer> troopPresent (){
	ArrayList<Integer> arr1 = new ArrayList<Integer>();
	for (int i = 0; i < territory.length; i++){
	    if (Integer.parseInt(territory[i][1]) > 0){
		arr1.add(i);
	    }
	}
	return arr1;
    }
    
    public ArrayList<String> terriOccupier (String occupier){
	ArrayList<String> arr2 = new ArrayList<String>();
	for (int i = 0; i < territory.length; i++){
	    if (territory[i][2].equals(occupier)){
		arr2.add(territory[i][0]);
	    }
	}
	return arr2;
    }
    
    public static int troopNumber(String player){
	int troopNum = 0;
	for (int i = 0; i < territory.length; i++){
	    if (territory[i][2].equals(player)){
		troopNum += Integer.parseInt(territory[i][1]);
	    }
	}
	return troopNum;
    }
    
    public static int territoryNumber(String player){
	int territoryNum = 0;
	for (int i = 0; i < territory.length; i++){
	    if (territory[i][2].equals(player)){
		territoryNum += 1;
			}
	}
	return territoryNum;
    }

    public static String findOwner(String target){
	for (int i = 0; i < territory.length; i++){
	    if (territory[i][0].equals(target)){
		return territory[i][0];
	    }
	}
	return "";
    }
    
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

    public static boolean updateStat(String target, String offense, int numWin){
	int loc = findLocation(target);
	String defense = occupier(target);
	if (territory[loc][1].equals("0")){
	    territory[loc][2] = offense;
	    territory[loc][1] = numWin + "";
	    //Woo.update(
	    Woo.removeTerritory(target, defense);
	    Woo.subtractTerritory(defense);
	    Woo.addTerritory(target, offense);
	    Woo.removeTerritory(defense, target);
	    return true;
	}
	return false;
    }
	
	public static boolean isVictory (String player, double winMargin){
		if (territoryNumber(player) > (int)(winMargin * 42)){
			return true;
		}
		else {
			return false;
		}
    }    
	public static String occupier(String terr){
		return territory[findLocation(terr)][2];
	}
	
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
}

public static ArrayList<String> avaliTerritory(String player){
    ArrayList<String> retArr = new ArrayList<String>();
    for(int i = 0; i < territory.length; i++){
	if(territory[i][2].equals("no") || territory[i][2].equals(player)){
	    retArr.add(territory[i][0];
		       }
	}
    }
    return retArr;
}

}
