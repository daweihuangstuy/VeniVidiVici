import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import cs1.Keyboard;

public class Helper{
	public static ArrayList<String> randomize(ArrayList<String> arr){
		ArrayList<String> tempArr = arr;
		int shuffleCounter = 50;
		while (shuffleCounter >= 0){
			int x = (int)(Math.random() * tempArr.size());
			tempArr.add(tempArr.get(x));
			tempArr.remove(x);
			shuffleCounter -= 1;
		}
		return tempArr;
    }
	
	public static int setInitialTroops(int numberPlayer){
		if (Woo.numPlayer == 2){
			return 40;
		}
		if (Woo.numPlayer == 3){
			return 35;
		}
		if (Woo.numPlayer == 4){
			return 30;
		}
		if (Woo.numPlayer == 5){
			return 25;
		}
		if (Woo.numPlayer == 6){
			return 20;
		}
		return -1;
	}
	
	public static String troopToString(int troops){
		String troopNumber = Integer.toString(troops);
		if (troopNumber.length() == 1){
			troopNumber = "00" + troopNumber;
			return troopNumber;
		}
		if (troopNumber.length() == 2){
			troopNumber = "0" + troopNumber;
			return troopNumber;
		}
		if (troopNumber.length() == 3){
			return troopNumber;
		}
		return "error";
	}
	public static String territoryToString(int territorys){
		String territoryNumber = Integer.toString(territorys);
		if (territoryNumber.length() == 1){
			territoryNumber = "00" + territoryNumber;
			return territoryNumber;
		}
		if (territoryNumber.length() == 2){
			territoryNumber = "0" + territoryNumber;
			return territoryNumber;
		}
		if (territoryNumber.length() == 3){
			return territoryNumber;
		}
		return "error";
	}
	
	public static String terrToString(double percent){
		if (percent < 0){
			return "      ";
		}
		if (Double.toString(percent).length() == 0){
			return ("      " + Double.toString(percent));
		}
		if (Double.toString(percent).length() == 1){
			return ("     " + Double.toString(percent));
		}
		if (Double.toString(percent).length() == 2){
			return ("    " + Double.toString(percent));
		}
		if (Double.toString(percent).length() == 3){
			return ("   " + Double.toString(percent));
		}
		if (Double.toString(percent).length() == 4){
			return ("  " + Double.toString(percent));
		}
		if (Double.toString(percent).length() == 5){
			return (" " + Double.toString(percent));
		}
		if (Double.toString(percent).length() == 6){
			return Double.toString(percent);
		}
		return "error";
	}
	
	public static boolean checkString(String number){
		boolean normdefault = true;
		try{
			int newt = Integer.parseInt(number);
		}
		catch (Exception e){
			normdefault = false;
		}
		return normdefault;
	}
}