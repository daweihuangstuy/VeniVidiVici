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
}
