public class Player{

    protected String name;
    protected int numTroop; //indicated size of troops
    protected int occuTerr; //int represents percent of overall territory occupied by the player

    /* Constructor */

    public Player(){
	numTroop = 40;
	occuTerr = 100/42;
    }

    public int getNumTroop(){
	return numTroop;
    }

    /*
      attack- attack strength increases with numTroops
      random num generator 1 - 5 indicates successful attack
      random num generator 6 - 10 indicates failed attack
     */

    public void attack(name Player, int Territory){
	int attStat; //status of attack, win or fail
	if ( numTroop <= 40 ){
	    attStat = (int) (Math.random() * 5 + 5);
	}
	if ( numTroop > 40 && numTroop <= 65 ){
	    attStat = (int) (Math.random() + 5 + 3);
	}
	if (numTroop > 65 ){
	    attStat = (int) (Math.random() * 5 + 1);
	}
	if (attStat <= 5){
	    numTroops += name.getNumTroop();
	}
    }

    /*
      vision - allows player to see how many troops are in enemy's territory
    */
    
    public int vision(name Player, String Continent){
	name.getNumTroop();

    }

}
