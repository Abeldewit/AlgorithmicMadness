import java.util.*;

public class MSI{
	
	private Vertex[] Graph;
	private Vertex[] baseSet;
	private Vertex[] pivotSet;
	private Vertex[] trashSet;
	private static Vertex[] maxIS;
	private static int maxISC;
	
	public MSI( Vertex[] Graph ){
		
		this.Graph = Graph;
		pivotSet = new Vertex[0];
		trashSet = new Vertex[0];
		baseSet = Graph;
		try{
			MSI( pivotSet, baseSet, trashSet );
		}catch(Exception f){
			
		}
	}
	
	public static int getMaxISC(){
		return(maxISC);
	}
	
	public static Vertex[] getMaxIS(){
		return(maxIS);
	}
	
	public void MSI( Vertex[] pivotSet, Vertex[] baseSet, Vertex[] trashSet) 
	throws Exception{
		
		//base case
		boolean DIE = false;
		if(baseSet.length == 0 && trashSet.length == 0){
			
			System.out.println("reported IS: "+pivotSet.length);
			if(pivotSet.length > maxISC){
				maxISC = pivotSet.length;
				maxIS = pivotSet;
				throw new Exception("That hurts");
				
			}
		}
		//ordering
		baseSet = DegreeSort.sortByDegeneracy(baseSet);
		
		//recursive utility
		for(int i=0;i<baseSet.length;i++){
			Vertex pivotVertex = baseSet[i];
			MSI(
				SetTools.Add(pivotSet,pivotVertex),
				SetTools.Intersection(baseSet,GraphTools.findNN(pivotVertex,Graph)),
				SetTools.Intersection(trashSet,GraphTools.findNN(pivotVertex,Graph))	
			);
			baseSet = SetTools.Remove(baseSet,pivotVertex);
			trashSet = SetTools.Add(trashSet,pivotVertex);
		}
	}
}