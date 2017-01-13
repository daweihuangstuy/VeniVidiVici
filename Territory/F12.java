public class F12{
    protected int curTroops; // current amount of troops on it
    protected String occupier; // current player occupying this territory

    
    public F12(){
	curTroops = 0;
	occupier = "null";
    }
    
    public int getCurTroops(){
	return curTroops;
    }

    public String getOccupier(){
	return occupier;
    }
}
