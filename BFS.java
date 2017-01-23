public class BFS{
	
	private Vertex[] Graph;
	private Vertex[] trashSet;
	private static boolean biparite;
	
	public BFS(Vertex[] Graph){
		
		this.Graph = Graph;
		trashSet = new Vertex[0];
		Vertex pivot = Graph[0];
		pivot.setColor(1);
		doBFS(pivot);
		biparite = GraphTools.isAllValid(Graph);
	}
	
	public void doBFS(Vertex pivot){
		
		Vertex[] newBreadth = pivot.getAdjacent();
		int parity = 2;
		colorBreadth(newBreadth,parity);
		while(!GraphTools.isColored(Graph)){
			parity = swapParity(parity);
			newBreadth = findNewBreadth(newBreadth);
			colorBreadth(newBreadth,parity);
		}
	}
	
	public Vertex[] findNewBreadth( Vertex[] set ){
		
		Vertex[] newBreadth = new Vertex[0];
		for(int i=0;i<set.length;i++){
			Vertex[] adj = set[i].getAdjacent();
			for(int j=0;j<adj.length;j++){
				if(!SetTools.Contains(trashSet,adj[j])){
					newBreadth = SetTools.Add(newBreadth,adj[j]);
				}
			}
		}
		return newBreadth;
	}
	
	public void colorBreadth( Vertex[] set, int c ){
		
		for (int i=0;i<set.length;i++){
			System.out.println("colored: "+set[i].getID());
			trashSet = SetTools.Add(trashSet,set[i]);
			set[i].setColor(c);
		}
	}
	
	public int swapParity ( int p ){
		
		if(p == 1){
			return 2;
		}else{
			return 1;
		}
	}
	
	public static boolean getValue(){
		return biparite;
	}
}