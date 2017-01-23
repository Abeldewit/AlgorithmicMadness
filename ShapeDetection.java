import java.util.*;

public class ShapeDetection{
	
	private static String shape = "unknown";
	private static boolean complete;
	
	public ShapeDetection( Vertex[] Graph ){
		
		TestCompleteness(Graph);
	}
	
	public void TestCompleteness ( Vertex[] Graph ){
		
		for(int i=0;i<Graph.length;i++){
			if((n-1) != Graph[i].getDegree()){
				return;
			}
		}
		complete = true;
		shape = "complete graph";
		return;
	}
	
	public static boolean isComplete(){
		return complete;
	}
}