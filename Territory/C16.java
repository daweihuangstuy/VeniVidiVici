public class C16{
    protected int curTroops; // current amount of troops on it
    protected String occupier; // current player occupying this territory

    
    public C16(){
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
