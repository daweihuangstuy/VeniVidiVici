
public ArrayList occupied = new ArrayList;

if (playerTurn.equals("player1")){
    occupied = player1Occupied;
}
if (playerTurn.equals("player2")){
    occupied = player2Occupied;
}
if (playerTurn.equals("player3")){
    occupied = player3Occupied;
}
if (playerTurn.equals("player4")){
    occupied = player4Occupied;
    }
if (playerTurn.equals("player5")){
    occupied = player5Occupied;
}
if (playerTurn.equals("player6")){
    occupied = player6Occupied;
}

public static void move(ArrayList<String> occupied, int numTroops, String origin, String destination){
    int ctrO = 0;
    int ctrD = 0;
    for ( String terr : occupied ){
	if (origin == terr){
	    ctrO = indexOf(origin);
	    troopPresent[ctrO] -= numTroops;
	    System.out.println("Moving troops from " + origin);
	}
	System.out.println("Sorry, you do not occupy " + origin + ". Please choose another territory to move your troops from.");	
    }
    for ( String terr : occupied ) {
	if (destination == terr) {
	    ctrD = indexOf(destination);
	    troopPresent[ctrD] += numTroops;
	    System.out.println("Moving troops to " + destination);
	}
	System.out.println("Sorry, you do not occupy " + destination + ". Please choose another territory to move your troops to.");
    }
    
    /*
      find index of origin in list of territories aquired
      return index, index in troopPresent + numTroops
     */
 
	//	if (numTroops @ origin  > 0){
    //troops @ origin -= numToops;
    //troops @destination += numTroops;
    
}
else{
    System.out.println("Sorry, you do not have enough troops to move to the destination. Please try moving troops from a different territory.");

}


//troopPresent
//terrioccupier
/*
if (playerTurn.equals("player6")){
    // player6Occupied = game.terriOccupier(playerTurn);
    // }
*/
