import java.lang.*;
import java.lang.Object;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class territoryGraph{
    public static ArrayList<String> targetObj; 
    
    //represents the territories adjacent to a given territory
    public static ArrayList<ArrayList<String>> teriGraph = new ArrayList<ArrayList<String>>();
    
    //initialize each territory
    public static String[] Territories = new String[]{"A11", "A12", "A13", "A14", "A15", "A16", "A17", "A18", "A19",
						      "B11","B12","B13","B14",
						      "C11","C12","C13","C14","C15","C16","C17",					      
						      "D11","D12","D13","D14","D15","D16",
						      "E11","E12","E13","E14","E15","E16","E17","E18","E19","E21","E22","E23",
						      "F11","F12","F13","F14"};
    public static String[] TerritoryCode = new String[]{"AAA","AAB","AAC","AAD",
							"AAE","AAF","AAG","AAH",
							"AAI",
							"BAA","BAB","BAC","BAD",
							"CAA","CAB","CAC","CAD",
							"CAE","CAF","CAG",
							"DAA","DAB","DAC",
							"DAD","DAE","DAF",
							"EAA","EAB","EAC","EAD",
							"EAE","EAF","EAG","EAH",
							"EAI","EBA","EBB","EBC",
							"FAA","FAB","FAC","FAD",};
    
    public static boolean validTerritory(String inputTeri){
	boolean booleanFlag = false;
	for (String x : Territories){
	    if (x.equals(inputTeri)){
		booleanFlag = true;
	    }
	}
	return booleanFlag;
    }
    public static ArrayList<String> A11 = new ArrayList<String>();
    public static ArrayList<String> A12 = new ArrayList<String>();
    public static ArrayList<String> A13 = new ArrayList<String>();
    public static ArrayList<String> A14 = new ArrayList<String>();
    public static ArrayList<String> A15 = new ArrayList<String>();
    public static ArrayList<String> A16 = new ArrayList<String>();
    public static ArrayList<String> A17 = new ArrayList<String>();
    public static ArrayList<String> A18 = new ArrayList<String>();
    public static ArrayList<String> A19 = new ArrayList<String>();
    public static ArrayList<String> B11 = new ArrayList<String>();
    public static ArrayList<String> B12 = new ArrayList<String>();
    public static ArrayList<String> B13 = new ArrayList<String>();
    public static ArrayList<String> B14 = new ArrayList<String>();
    public static ArrayList<String> C11 = new ArrayList<String>();
    public static ArrayList<String> C12 = new ArrayList<String>();
    public static ArrayList<String> C13 = new ArrayList<String>();
    public static ArrayList<String> C14 = new ArrayList<String>();
    public static ArrayList<String> C15 = new ArrayList<String>();
    public static ArrayList<String> C16 = new ArrayList<String>();
    public static ArrayList<String> C17 = new ArrayList<String>();
    public static ArrayList<String> D11 = new ArrayList<String>();
    public static ArrayList<String> D12 = new ArrayList<String>();
    public static ArrayList<String> D13 = new ArrayList<String>();
    public static ArrayList<String> D14 = new ArrayList<String>();
    public static ArrayList<String> D15 = new ArrayList<String>();
    public static ArrayList<String> D16 = new ArrayList<String>();
    public static ArrayList<String> E11 = new ArrayList<String>();
    public static ArrayList<String> E12 = new ArrayList<String>();
    public static ArrayList<String> E13 = new ArrayList<String>();
    public static ArrayList<String> E14 = new ArrayList<String>();
    public static ArrayList<String> E15 = new ArrayList<String>();
    public static ArrayList<String> E16 = new ArrayList<String>();
    public static ArrayList<String> E17 = new ArrayList<String>();
    public static ArrayList<String> E18 = new ArrayList<String>();
    public static ArrayList<String> E19 = new ArrayList<String>();
    public static ArrayList<String> E21 = new ArrayList<String>();
    public static ArrayList<String> E22 = new ArrayList<String>();
    public static ArrayList<String> E23 = new ArrayList<String>();
    public static ArrayList<String> F11 = new ArrayList<String>();
    public static ArrayList<String> F12 = new ArrayList<String>();
    public static ArrayList<String> F13 = new ArrayList<String>();
    public static ArrayList<String> F14 = new ArrayList<String>();
    //add more etc*****************************************************
    
    public static void main(String args[]){
	//add territories adjacent to A11
	A11.add("A13"); A11.add("A15"); A11.add("A16"); A11.add("C11");
	teriGraph.add(A11);
	
	//add territories adjacent to A12
	A12.add("E13"); A12.add("A13"); A12.add("A14");
	teriGraph.add(A12);
	
	//add territories adjacent to A13
	A13.add("A12"); A13.add("A11"); A13.add("A15"); A13.add("A14");
	teriGraph.add(A13);
	
	//add territories adjacent to A14
	A14.add("A12"); A14.add("A13"); A14.add("A15"); A14.add("A17");
	teriGraph.add(A14);
	
	//add territories adjacent to A15
	A15.add("A13"); A15.add("A14"); A15.add("A18"); A15.add("A16");
	A15.add("A11");
	teriGraph.add(A15);
	
	//add territories adjacent to A16
	A16.add("A15"); A16.add("A18"); A16.add("A11");
	teriGraph.add(A16);
	
	//add territories adjacent to A17
	A17.add("A14"); A17.add("A18"); A17.add("A19");
	teriGraph.add(A17);
	
	//add territories adjacent to A18
	A18.add("A15"); A18.add("A17"); A18.add("A19"); A18.add("A16");
	teriGraph.add(A18);
	
	//add territories adjacent to A19
	A19.add("A17"); A19.add("A18"); A19.add("B11");
	teriGraph.add(A19);
	
	//add territories adjacent to B11
	B11.add("A19");	B11.add("B13"); B11.add("B12");
	teriGraph.add(B11);

	//add territories adjacent to B12
	B12.add("B11");	B12.add("B13"); B12.add("B14");B12.add("D12");
	teriGraph.add(B12);
	
	//add territories adjacent to B13
	B13.add("B11");	B13.add("B14"); B13.add("B12");
	teriGraph.add(B13);
	
	//add territories adjacent to B14
	B14.add("B13");	B14.add("B12");
	teriGraph.add(B14);
	
	//add territories adjacent to C11
	C11.add("A11"); C11.add("C12"); C11.add("C13");
	teriGraph.add(C11);
	
	//add territories adjacent to C12
	C12.add("C11"); C12.add("C15"); C12.add("C13"); C12.add("14");
	teriGraph.add(C12);
	
	//add territories adjacent to C13
	C13.add("C11"); C13.add("C12"); C13.add("C14"); C13.add("C16");
	teriGraph.add(C13);
	
	//add territories adjacent to C14
	C14.add("C12"); C14.add("C13"); C14.add("C15"); C14.add("C16");
	C14.add("C17");
	teriGraph.add(C14);

	//add territories adjacent to C15
	C15.add("C12"); C15.add("C14"); C15.add("C17"); C15.add("E15");
	C15.add("E16"); C15.add("E23");
	teriGraph.add(C15);

	//add territories adjacent to C16
	C16.add("C13"); C16.add("C14"); C16.add("C17"); C16.add("D12");
	teriGraph.add(C16);

	//add territories adjacent to C17
	C17.add("C15"); C17.add("C14"); C17.add("C16"); C17.add("D11");
	teriGraph.add(C17);
	
	//add territories adjacent to D11
	D11.add("C17"); D11.add("E23"); D11.add("D13"); D11.add("D12");
	teriGraph.add(D11);

	//add territories adjacent to D12
	D12.add("C16"); D12.add("D11"); D12.add("D13"); D12.add("D14");
	D12.add("B12");
	teriGraph.add(D12);

	//add territories adjacent to D13
	D13.add("D11"); D13.add("D12"); D13.add("D14"); D13.add("D15");
	D13.add("D16"); D13.add("E23");
	teriGraph.add(D13);
	
	//add territories adjacent to D14
	D14.add("D12"); D14.add("D13"); D14.add("D15"); D14.add("B12");
	teriGraph.add(D14);

	//add territories adjacent to D15
	D15.add("D14"); D15.add("D13"); D15.add("D16");
	teriGraph.add(D15);

	//add territories adjacent to D16
	D16.add("D15"); D16.add("D13");
	teriGraph.add(D16);

	//add territories adjacent to E11
	E11.add("E12"); E11.add("E13"); E11.add("E14");
	teriGraph.add(E11);

	//add territories adjacent to E12
	E12.add("E11"); E12.add("E14"); E12.add("E17");	
	E12.add("E18"); E12.add("E15");
	teriGraph.add(E12);
	
	//add territories adjacent to E13
	E13.add("E11"); E13.add("E14"); E13.add("E21");	E13.add("E17");
	teriGraph.add(E13);

	//add territories adjacent to E14
	E14.add("E11"); E14.add("E12"); E14.add("E13");	E14.add("E17");
	teriGraph.add(E14);

	//add territories adjacent to E15
	E15.add("E12"); E15.add("E18"); E15.add("E16");	E15.add("C15");
	teriGraph.add(E15);

	//add territories adjacent to E16
	E16.add("E15"); E16.add("E18"); E16.add("E19");	E16.add("E23");
	E16.add("C17");	E16.add("C14");
	teriGraph.add(E16);

	//add territories adjacent to E17
	E17.add("E12"); E17.add("E14"); E17.add("E13");	E17.add("E21");
	E17.add("E18");
	teriGraph.add(E17);

	//add territories adjacent to E18
	E18.add("E12"); E18.add("E14"); E18.add("E22");	
	E18.add("E19"); E18.add("E16"); E18.add("E15");
	teriGraph.add(E18);

	//add territories adjacent to E19
	E19.add("E16"); E19.add("E18"); E19.add("E22");	E19.add("E23");
	teriGraph.add(E19);

	//add territories adjacent to E21
	E21.add("E13"); E21.add("E27");
	teriGraph.add(E21);

	//add territories adjacent to E22
	E22.add("E18"); E23.add("E19"); E22.add("F11");
	teriGraph.add(E23);

	//add territories adjacent to E23
	E23.add("E16"); E23.add("E19"); E23.add("D13");
	E23.add("D11");	E23.add("C17");	E23.add("C15");
	teriGraph.add(E23);

	//add territories adjacent to F11
	F11.add("E22"); F11.add("F12"); F11.add("F13");
	teriGraph.add(F11);

	//add territories adjacent to F12
	F12.add("F11"); F12.add("F13"); F12.add("F14");
	teriGraph.add(F12);

	//add territories adjacent to F13
	F13.add("R11"); F13.add("F12"); F13.add("F14");
	teriGraph.add(F13);

	//add territories adjacent to F14
        F14.add("F12"); F14.add("F13");
	teriGraph.add(F14);
	
	//add more etc*****************************************************
    }
    
    public static void convertStrToObject(String obj){
	if (obj.equals("A11")){
	    targetObj = A11;
	} 
	if (obj.equals("A12")){
	    targetObj = A12;
	} 
	if (obj.equals("A13")){
	    targetObj = A13;
	}
	if (obj.equals("A14")){
	    targetObj = A14;
	}
	if (obj.equals("A15")){
	    targetObj = A15;
	}
	if (obj.equals("A16")){
	    targetObj = A16;
	}
	if (obj.equals("A17")){
	    targetObj = A17;
	}
	if (obj.equals("A18")){
	    targetObj = A18;
	}
	if (obj.equals("A19")){
	    targetObj = A19;
	}
	if (obj.equals("B11")){
	    targetObj = B11;
	}
	if (obj.equals("B12")){
	    targetObj = B12;
	}
	if (obj.equals("B13")){
	    targetObj = B13;
	}
	if (obj.equals("B14")){
	    targetObj = B14;
	}
	if (obj.equals("C11")){
	    targetObj = C11;
	}	
	if (obj.equals("C12")){
	    targetObj = C12;
	}	
	if (obj.equals("C13")){
	    targetObj = C13;
	}	
	if (obj.equals("C14")){
	    targetObj = C14;
	}	
	if (obj.equals("C15")){
	    targetObj = C15;
	}
	if (obj.equals("C16")){
	    targetObj = C16;
	}
	if (obj.equals("C17")){
	    targetObj = C17;
	}	
	if (obj.equals("D11")){
	    targetObj = D11;
	}
	if (obj.equals("D12")){
	    targetObj = D12;
	}
	if (obj.equals("D13")){
	    targetObj = D13;
	}
	if (obj.equals("D14")){
	    targetObj = D14;
	}
	if (obj.equals("D15")){
	    targetObj = D15;
	}
	if (obj.equals("D16")){
	    targetObj = D16;
	}
	if (obj.equals("E11")){
	    targetObj = E11;
	}
	if (obj.equals("E12")){
	    targetObj = E12;
	}
	if (obj.equals("E13")){
	    targetObj = E13;
	}
	if (obj.equals("E14")){
	    targetObj = E14;
	}
	if (obj.equals("E15")){
	    targetObj = E15;
	}
	if (obj.equals("E16")){
	    targetObj = E16;
	}
	if (obj.equals("E17")){
	    targetObj = E17;
	}
	if (obj.equals("E18")){
	    targetObj = E18;
	}
	if (obj.equals("E19")){
	    targetObj = E19;
	}
	if (obj.equals("E21")){
	    targetObj = E21;
	}
	if (obj.equals("E22")){
	    targetObj = E22;
	}
	if (obj.equals("E23")){
	    targetObj = E23;
	}
	if (obj.equals("F11")){
	    targetObj = F11;
	}
	if (obj.equals("F12")){
	    targetObj = F12;
	}
	if (obj.equals("F13")){
	    targetObj = F13;
	}
	if (obj.equals("F14")){
	    targetObj = F14;
	}
    }
    
    public boolean isConnect(ArrayList<String> obj, String target){
	for (int i = 0; i < obj.size(); i++){
	    if (obj.get(i).equals(target)){
		return true;
	    }
	}
	return false;
    }
    
    public boolean isIn(String target){
	for (String x : Territories){
	    if (x == target){
		return true;
	    }
	}
	return false;
    }
}
