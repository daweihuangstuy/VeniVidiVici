public class D14{
    protected int curTroops; // current amount of troops on it
    protected String occupier; // current player occupying this territory

    
    public D14(){
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
