public class GraphTools{
	
	public static boolean isColored (Vertex[] Graph){
		
		for(int i=0;i<Graph.length;i++){
			if(Graph[i].getColor() == 0){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidColoring (Vertex vertex, int color){
		
		Vertex[] adj = vertex.getAdjacent();
		for(int i=0;i<adj.length;i++){
			if(adj[i].getColor() == color){
				return false;
			}
		}
		return true;
	}
	
	public static Vertex[] RemoveVertex (Vertex[] Graph, Vertex vertex){
		
		Vertex[] newGraph = SetTools.Remove(Graph,vertex);
		return newGraph;
	}
	
	public static boolean isAllValid (Vertex[] Graph){
		
		for(int i=0;i<Graph.length;i++){
			Vertex[] adj = Graph[i].getAdjacent();
			for(int j=0;j<adj.length;j++){
				if(Graph[i].getColor() == adj[j].getColor()){
					System.out.println("Not valid coloring!");
					System.out.println("V "+Graph[i].getID()+" V "+adj[j].getID()+" colored "+Graph[i].getColor());
					return false;
				}
			}
		}
		return true;
	}
	
	public static Vertex[] findNN ( Vertex vertex, Vertex[] Graph ){
		
		Vertex[] array = Graph;
		Vertex[] adj = vertex.getAdjacent();
		array = SetTools.RemoveSet(array,adj);
		array = SetTools.Remove(array,vertex);
		return array;
	}
}