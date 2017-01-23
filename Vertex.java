import java.util.*;

public class Vertex{
	
	private int id;
	private int colour;
	private Vertex[] adjacent;
	
	public Vertex(int id){
		this.id = id;
		adjacent = new Vertex[0];
	}
	
	//Edges
	public void addAdjacent(Vertex v){
		if(!SetTools.Contains(adjacent,v)){
			adjacent = SetTools.Add(adjacent,v);
		}
	}
	public int getID(){
		return id;
	}
	public Vertex[] getAdjacent(){
		return(adjacent);
	}
	public int getDegree(){
		return (adjacent.length);
	}
	
	public void removeSingleEdge(Vertex v){
		for(int i=0;i<adjacent.length;i++){
			if(adjacent[i] == v){
				adjacent = SetTools.Remove(adjacent,v);
			}
		}
	}
	public void setColor(int i){
		this.colour = i;
	}
	public int getColor(){
		return colour;
	}
	public int getSatur(){
		
		int[] colorset = new int[0];
		for(int i=0;i<adjacent.length;i++){
			if(!SetTools.Contains(colorset,adjacent[i].getColor())){
				colorset = SetTools.Add(colorset,adjacent[i].getColor());
			}
		}
		return colorset.length;
	}
}