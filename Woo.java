import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Woo {

    public static void main(String args[]) throws FileNotFoundException {
	startGraphic();
    }  

    public static void startGraphic() throws FileNotFoundException {
	File text1 = new File("Cover.txt");
	Scanner scanner1 = new Scanner(text1);
	while (scanner1.hasNextLine()){
	    String line1 = scanner1.nextLine();
	    System.out.println(line1);
	}
	File text2 = new File("WorldMap.txt");
	Scanner scanner2 = new Scanner(text2);
	while (scanner2.hasNextLine()){
	    String line2 = scanner2.nextLine();
	    System.out.println(line2);
	}
    }
}