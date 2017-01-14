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
}