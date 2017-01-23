import java.util.*;

public class MaxClique{
	
	private Vertex[] baseSet;
	private Vertex[] pivotSet;
	private Vertex[] trashSet;
	private static Vertex[] maxClique;
	private static int LB;
	
	public MaxClique( Vertex[] Graph ){
		
		pivotSet = new Vertex[0];
		trashSet = new Vertex[0];
		baseSet = Graph;
		BronKerbosch( pivotSet, baseSet, trashSet );
	}
	
	public static int getLowerBound(){
		return(LB);
	}
	
	public static Vertex[] getMaxClique(){
		return(maxClique);
	}
	
	public void BronKerbosch( Vertex[] pivotSet, Vertex[] baseSet, Vertex[] trashSet){
		
		//base case
		
		if(baseSet.length == 0 && trashSet.length == 0){
			
			if(pivotSet.length > LB){
				LB = pivotSet.length;
				maxClique = pivotSet;
				System.out.println("reported clique: "+pivotSet.length);
			}
		}
		//additional pivoting for efficiency
		Vertex[] PVset = SetTools.Union(baseSet,trashSet);
		Vertex[] stackSet;
		if(PVset.length > 0){
			Vertex PVvertex = PVset[0];
			stackSet = SetTools.RemoveSet( baseSet,PVvertex.getAdjacent());
		}else{
			stackSet = baseSet;
		}
		//recursive utility
		for(int i=0;i<stackSet.length;i++){
			Vertex pivotVertex = stackSet[i];
			BronKerbosch(
				SetTools.Add(pivotSet,pivotVertex),
				SetTools.Intersection(baseSet,pivotVertex.getAdjacent()),
				SetTools.Intersection(trashSet,pivotVertex.getAdjacent())	
			);
			baseSet = SetTools.Remove(baseSet,pivotVertex);
			trashSet = SetTools.Add(trashSet,pivotVertex);
		}
	}
}