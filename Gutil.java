public class Gutil{
	
	ColEdge[] data;
	Vertex[] Graph;
	int[][] matrix;
	
	public Gutil(){
		
		//Read in the graph
		String[] graphtxt = {"TestGraphs3/block3_graph01.txt"};
		data = ReadGraph.Read(graphtxt);

		//Construct objects
		Graph = createGraph(data);
		matrix = createMatrix(data);
		Graph = DegreeSort.sortByDegree(Graph);
		
		//Debugging tools:
		//listDegree();
		//listColor();
		//listAdjacent();
		
		//Shape Detection
		//new ShapeDetection(Graph);
		
		//Find Max clique (Bron-Kerbosch method)
		//new MaxClique(Graph);
		//int LB = MaxClique.getLowerBound();
		//System.out.println("lower bound: "+LB);
		
		//Find upperbound (Welsh-Powell method)
		//new WelshPowell(Graph);
		//int HB = WelshPowell.getHigherBound();
		//System.out.println("higher bound: "+HB);
		
		//Find upperbound (DSATUR)
		//new DSatur(Graph);
		//int HB = DSatur.getHigherBound();
		//System.out.println("DSATUR: "+HB);
		
		//Find upperbound (Recursive Largest First)
		//new RLF(Graph);
		//int HB = RLF.getHigherBound();
		//System.out.println("RLF: "+HB);
		
		//Find optimal coloring by means of exact (BruteForce)
		//new DFS(LB,HB,matrix);
		//int CHR = DFS.getChr();
		//System.out.println("chroma: "+CHR);
		
		//Test tripariteness
		//new BFST(Graph);
		//boolean BF = BFST.getValue();
		//System.out.println("triparite: "+BF);
		
		//Find MIS
		//new MSI(Graph);
		//int maxISC = MSI.getMaxISC();
		//System.out.println("misc "+maxISC);
	}
	
	public Vertex[] createGraph(ColEdge[] data){
		
		Graph = new Vertex[data[0].n];
		
		for(int i=0;i<Graph.length;i++){
			Graph[i] = new Vertex(i+1);
		}
		for(int i=0;i<data.length;i++){
			getVertexByID(data[i].u).addAdjacent(getVertexByID(data[i].v));
			getVertexByID(data[i].v).addAdjacent(getVertexByID(data[i].u));
		}
		return Graph;
	}
	
	public int[][] createMatrix(ColEdge[] data){
		
		int[][] matrix = new int[data[0].n][data[0].n];
		
		for(int i=0;i<data.length;i++){
			matrix[data[i].u-1][data[i].v-1] = 1;
			matrix[data[i].v-1][data[i].u-1] = 1;
		}
		return matrix;
	}
	
	public void listDegree(){
		
		for(int i=0;i<Graph.length;i++){
			System.out.println("ID: "+Graph[i].getID()+" Degree: "+Graph[i].getDegree());
		}
	}
	
	public void listColor(){
		
		for(int i=0;i<Graph.length;i++){
			System.out.println("ID: "+Graph[i].getID()+" Colored: "+Graph[i].getColor()+" Adjacent colored: ");
			Vertex[] adj = Graph[i].getAdjacent();
			for(int j=0;j<adj.length;j++){
				System.out.print(adj[j].getColor()+",");
			}
			System.out.println("\n");
		}
	}
	
	public void listAdjacent(){
		
		for(int i=0;i<Graph.length;i++){
			System.out.print("\n");
			System.out.println("ID: "+Graph[i].getID());
			System.out.print("ADJ: ");
			Vertex[] adj = Graph[i].getAdjacent();
			for(int j=0;j<adj.length;j++){
				System.out.print(adj[j].getID()+", ");
			}
			System.out.print("\n");
		}
	}
	
	public Vertex getVertexByID(int id){
		
		for(int i=0;i<Graph.length;i++){
			if(Graph[i].getID() == id){
				return(Graph[i]);
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		new Gutil();
	}
}