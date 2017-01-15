import java.util.ArrayList;

public class Territory{
    public String[][] territory = new String[42][3];
    public Territory(){	
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
	territory[12][0] = "B14"; territory[12][1] = "0"; territory[12][2] = "no";
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
	
	public int findLocation(String location){
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
	
	public int troopNumber(String player){
		int troopNum = 0;
		for (int i = 0; i < territory.length; i++){
			if (territory[i][2].equals(player)){
				troopNum += Integer.parseInt(territory[i][1]);
			}
		}
		return troopNum;
	}
	
	public int territoryNumber(String player){
		int territoryNum = 0;
		for (int i = 0; i < territory.length; i++){
			if (territory[i][2].equals(player)){
				territoryNum += 1;
			}
		}
		return territoryNum;
	}
    
}
    
