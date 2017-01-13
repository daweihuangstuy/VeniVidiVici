import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import cs1.Keyboard;

public class Woo {
    //class variables
    static int numPlayer = 0;
	static String playerTurn;

	//instantialize players
	Player1 player1 = new Player1();
	Player2 player2 = new Player2();
	A11 game = new A11();
	
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
		startGame();
		renderMap();
		//player 1 placement
		playerTurn = "player1";
		
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
		System.out.println(playerNum);
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
			line2 = line2.replace("(GREEN)",ANSI_GREEN + "(GREEN)" + ANSI_RESET); //PLAYER 2
			}
			if (numPlayer >= 3){
			line2 = line2.replace("(RED)",ANSI_RED + "(RED)" + ANSI_RESET); //PLAYER 3
			}
			if (numPlayer >= 4){
			line2 = line2.replace("(YELLOW)",ANSI_YELLOW + "(YELLOW)" + ANSI_RESET); //PLAYER 4
			}
			if (numPlayer >= 5){
			line2 = line2.replace("(PURPLE)",ANSI_PURPLE + "(PURPLE)" + ANSI_RESET); //PLAYER 5
			}
			if (numPlayer == 6){
			line2 = line2.replace("(CYAN)",ANSI_CYAN + "(CYAN)" + ANSI_RESET); //PLAYER 6
			}
			System.out.println(line2);
		}
	}
//*******************************************************************************
	// public static void placement(String player, String territory){
		// System.out.println("Select a territory to place one troop");	
		// String placementSelect = cs1.Keyboard.readString();
		// territoryGraph.allTerritory
	// }
}
