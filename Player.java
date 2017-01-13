/* VeniVidiVici
   Yu Qi Wu, Dawei Huang, Fabiola Radosav
   pd 4
*/

import java.lang.*;
import java.lang.Object;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Player{

    protected String name;
	protected int intialTroops;
    protected int numTroop; //indicated size of troops
    protected int occuTerr; //int represents percent of overall territory occupied by the player
    protected ArrayList<String> territory;

    /* Constructor */

    public Player(){
	numTroop = 40;
	occuTerr = 0;
	intialTroops = 40;
    }

    public int getNumTroop(){
	return numTroop;
    }

    /*
      attack- attack strength increases with numTroops
      random num generator 1 - 3 indicates successful attack
      random num generator 4 - 6 indicates failed attack
     */

    public void attack(int attTroops, String Territory){
	int attStat; //status of attack, win or fail
	if ( attTroops > 3 ){
	    System.out.println("Sorry, you can only have a maximum number of 3 troops");
	    this.attack(attTroops, Territory);
	}
	for (int ctr = 0; ctr < attTroops; ctr++){
	    attStat = (int) (Math.random() * 6);
	    if (attStat > 3){
		// ClassTerritory.win(); defense lose 1 troops
	    }
	    else{
		numTroops -= 1;
	    }
	}
    }
}
