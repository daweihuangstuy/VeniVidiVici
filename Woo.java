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
	public static void placement(String player, String territory){
		System.out.println("Select a territory to place one troop");	
		String placementSelect = cs1.Keyboard.readString();
		territoryGraph.allTerritory
	}
	
//*******************************************************************************
	// instantialize territories
		A11 gameA11 = new A11();
		A12 gameA12 = new A12();
		A13 gameA13 = new A13();
		A14 gameA14 = new A14();
		A15 gameA15 = new A15();
		A16 gameA16 = new A16();
		A17 gameA17 = new A17();
		A18 gameA18 = new A18();
		A19 gameA19 = new A19();
		A04 gameA04 = new A04();
		B11 gameB11 = new B11();
		B12 gameB12 = new B12();
		B13 gameB13 = new B13();
		C11 gameC11 = new C11();
		C12 gameC12 = new C12();
		C13 gameC13 = new C13();
		C14 gameC14 = new C14();
		C15 gameC15 = new C15();
		C16 gameC16 = new C16();
		C17 gameC17 = new C17();
		D11 gameD11 = new D11();
		D12 gameD12 = new D12();
		D13 gameD13 = new D13();
		D14 gameD14 = new D14();
		D15 gameD15 = new D15();
		D16 gameD16 = new D16();
		E11 gameE11 = new E11();
		E12 gameE12 = new E12();
		E13 gameE13 = new E13();
		E14 gameE14 = new E14();
		E15 gameE15 = new E15();
		E16 gameE16 = new E16();
		E17 gameE17 = new E17();
		E18 gameE18 = new E18();
		E19 gameE19 = new E19();
		E21 gameE21 = new E21();
		E22 gameE22 = new E22();
		E23 gameE23 = new E23();
		F11 gameF11 = new F11();
		F12 gameF12 = new F12();
		F13 gameF13 = new F13();
		F14 gameF14 = new F14();
}
