public class DSatur{
	
	private Vertex[] Graph;
	private static int HB;
	private int maxDegree;
	private int colored;
	
	public DSatur(Vertex[] Graph){
		
		this.Graph = Graph;
		Graph = DegreeSort.sortByDegree(Graph);
		maxDegree = Graph[0].getDegree();
		DSatur(Graph);
	}
	
	public void DSatur(Vertex[] Graph){
		
		while(!GraphTools.isColored(Graph)){
			
			for(int i=0;i<Graph.length;i++){
				if(Graph[i].getColor()==0){
					int curcol = findSmallestCol(Graph[i]);
					Graph[i].setColor(curcol);
					colored++;
					System.out.println("colored "+colored+" of "+Graph.length);
					Graph = DegreeSort.sortBySatur(Graph);
				}
			}
		}
	}
	
	public int findSmallestCol ( Vertex vertex ){
		
		for(int i=1;i<Graph.length;i++){
			if(GraphTools.isValidColoring(vertex,i)){
				if(i>HB){
					HB = i;
				}
				return i;
			}
		}
		return 0;
	}
	
	public static int getHigherBound(){
		return HB;
	}
}