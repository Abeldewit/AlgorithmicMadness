import java.util.*;

public class RLF{
	

	private static int chr;
	private static int MNIC; //maximum neighbours in common
	
	public RLF ( Vertex[] Graph ){
		
		RLF(Graph);
	}
	
	public static int getHigherBound(){
		return chr;
	}
	
	public void RLF ( Vertex[] Graph ){
		
		while(!isColored(Graph)){
			
			chr++;
			Vertex pivotA = findMaxVertex(Graph);
			pivotA.setColor(chr);
			System.out.println("pivot "+pivotA.getID());
			Vertex[] NN = findNonNeighbours(pivotA,Graph);
			while(NN.length>0){
				
				listNN(NN);
				System.out.println("NN length is "+NN.length);
				MNIC = 0;
				Vertex pivotB = findMNIC(pivotA,NN);
				if(MNIC == 0){
					pivotB = findMaxVertex(NN);
				}
				System.out.println("mnic vertex is: "+pivotB.getID());
				pivotB.setColor(chr);
				//System.out.println("colored: "+pivotB.getID());
				NN = updateNonNeighbours(NN,Graph);
			}
			Graph = RemovePivot(Graph,pivotA);
		}
	}
	
	public boolean isColored ( Vertex[] Graph ){
		
		for(int i=0;i<Graph.length;i++){
			if(Graph[i].getColor() == 0){
				//System.out.println("V is not col: "+Graph[i].getID());
				return false;
			}
		}
		return true;
	}
	
	public Vertex findMaxVertex (Vertex[] Graph){
		
		Vertex max = Graph[0];
		
		for(int i=0;i<Graph.length;i++){
			if(Graph[i].getDegree()>max.getDegree()){
				max = Graph[i];
			}
		}
		return max;
	}
	
	public Vertex[] findNonNeighbours ( Vertex vertex, Vertex[] Graph ){
		
		Vertex[] array = Graph;
		Vertex[] adj = vertex.getAdjacent();
		array = SetTools.RemoveSet(array,adj);
		array = SetTools.Remove(array,vertex);
		return array;
	}
	
	public Vertex[] updateNonNeighbours ( Vertex[] NN, Vertex[] Graph ){
		
		Vertex[] newSet = new Vertex[0];
		for(int i=0;i<Graph.length;i++){
			if(Graph[i].getColor() == 0){
				newSet = SetTools.Add(newSet,Graph[i]);
			}
		}
		
		for(int i=0;i<newSet.length;i++){
			Vertex[] adj = newSet[i].getAdjacent();
			Vertex v = newSet[i];
			for(int j=0;j<adj.length;j++){
				if(adj[j].getColor() == chr){
					//System.out.println("Removed by adj: "+v.getID());
					newSet = SetTools.Remove(newSet,v);
					i--;
					break;
				}
			}
		}
		return newSet;
	}
	
	public Vertex findMNIC ( Vertex vertexA, Vertex[] Graph ){
		
		Vertex pivotB = null;
		Vertex[] baseHood = vertexA.getAdjacent();
		
		for(int i=0;i<Graph.length;i++){
			Vertex[] set = SetTools.Intersection(Graph[i].getAdjacent(),baseHood);
			if(set.length>MNIC ||(pivotB != null && set.length==MNIC && Graph[i].getDegree()>pivotB.getDegree())){
				MNIC = set.length;
				pivotB = Graph[i];
			}
		}
		return pivotB;
	}
	
	public Vertex[] RemovePivot (Vertex[] Graph, Vertex vertex){
		
		Vertex[] newGraph = SetTools.Remove(Graph,vertex);
		
		for(int i=0;i<Graph.length;i++){
			if(SetTools.Contains(Graph[i].getAdjacent(),vertex)){
				Graph[i].removeSingleEdge(vertex);
			}
		}
		return newGraph;
	}
	
	public void listNN(Vertex[] NN){
		
		for(int i=0;i<NN.length;i++){
			System.out.println("V "+NN[i].getID()+" colored "+NN[i].getColor());
		}
	}
}