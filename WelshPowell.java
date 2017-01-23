public class WelshPowell{
	
	private static int HB = 1;
	
	public WelshPowell(Vertex[] Graph){
		
		//Sort vertices by valence (heuristic ordering)
		Graph = DegreeSort.sortByDegree(Graph);
		WelshPowell(Graph);
	}
	
	//The graph is already in heuristic ordering
	public void WelshPowell(Vertex[] Graph){
		
		while(!GraphTools.isColored(Graph)){
			
			Vertex[] diminishSet = new Vertex[0];
			
			//Coloring phase
			for(int i=0;i<Graph.length;i++){
				if(Graph[i].getColor() == 0 &&
				   GraphTools.isValidColoring(Graph[i],HB)){
					   Graph[i].setColor(HB);
					   diminishSet = SetTools.Add(diminishSet,Graph[i]);
				   }
			}
			
			//Diminishing phase
			Graph = SetTools.RemoveSet( Graph,diminishSet );
			HB++;
		}
	}

	public static int getHigherBound(){
		return HB;
	}
}