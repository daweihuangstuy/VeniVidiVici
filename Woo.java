import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import cs1.Keyboard;

public class Woo {

    public static void main(String args[]) throws FileNotFoundException {
	startGraphic();
    }  

    public static void startGraphic() throws FileNotFoundException {
		
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
	
	// print world map in terminal
	File text2 = new File("WorldMap.txt");
	Scanner scanner2 = new Scanner(text2);
	while (scanner2.hasNextLine()){
	    String line2 = scanner2.nextLine();
	    System.out.println(line2);
	}
	
	
    }
}