/* VeniVidiVici
   Yu Qi Wu, Dawei Huang, Fabiola Radosav
   pd 4
*/


public class Player{

    protected String name;
    protected int numTroop; //indicated size of troops
    protected int occuTerr; //int represents percent of overall territory occupied by the player
    protected ArrayList<String> occuTerr;

    /* Constructor */

    public Player(){
	numTroop = 40;
	occuTerr = 0;
	occuTerr = new ArrayList<String>();
    }

    public int getNumTroop(){
	return numTroop;
    }

    /*
      attack- attack strength increases with numTroops
      random num generator 1 - 5 indicates successful attack
      random num generator 6 - 10 indicates failed attack
     */

    public void attack(int attTroops, String Territory){
	int attStat; //status of attack, win or fail
	if ( attTroops > 3 ){
	    System.out.println("Sorry, you can only have a maximum number of 3 troops");
	    // attack(attTroops, Territory);
	}
	for (int ctr = 0; ctr < attTroops; ctr++){
	    attStat = (int) (Math.random() * 6);
	    if (attStat > 3){
		// ClassTerritory.win(); defense lose 1 troops
	    }
	    else{
		// ClassTerritory.lose(); offense lose 1 troops
	    }
	}
    }

    public void move(name Player, int Territory){
	
    }

    /*
      vision - allows player to see how many troops are in enemy's territory
    */
    
    public int vision(name Player, String Continent){
	name.getNumTroop();

    }

}
