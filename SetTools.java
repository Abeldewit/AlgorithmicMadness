import java.util.*;

public class SetTools{
	
	// Set modification tools
	
	public static Vertex[] Add(Vertex[] set, Vertex v){
		
		Vertex[] newSet = new Vertex[set.length+1];
		
		for(int i=0;i<set.length;i++){
			newSet[i] = set[i];
		}
		newSet[newSet.length-1] = v;
		return newSet;
	}
	
	public static int[] Add(int[] set, int e){
		
		if(!Contains(set,e)){
			int[] newSet = new int[set.length+1];
		
			for(int i=0;i<set.length;i++){
				newSet[i] = set[i];
			}
			newSet[newSet.length-1] = e;
			return newSet;
		}else{
			return set;
		}
	}
	
	public static Vertex[] Union(Vertex[] set1, Vertex[] set2){
		
		Vertex[] newSet = set1;
		
		for(int i=0;i<set2.length;i++){
			newSet = Add(newSet,set2[i]);
		}
		return newSet;
	}
	
	public static Vertex[] Intersection(Vertex[] set1, Vertex[] set2){
		
		Vertex[] newSet = new Vertex[0];
		for(int i=0;i<set1.length;i++){
			for(int j=0;j<set2.length;j++){
				if(set1[i] == set2[j]){
					newSet = Add(newSet,set1[i]);
				}
			}
		}
		return newSet;
	}
	

	
	public static Vertex[] Remove(Vertex[] set, Vertex v){
		
		Vertex[] newSet = new Vertex[0];

		for(int i=0;i<set.length;i++){
			if(set[i] != v){
				newSet = Add(newSet,set[i]);
			}
		}
		return newSet;
	}
	
	public static Vertex[] RemoveSet(Vertex[] set1, Vertex[] set2){
		
		for(int i=0;i<set1.length;i++){
			if(Contains(set2,set1[i])){
				set1 = Remove(set1, set1[i]);
				i--;
			}
		}
		return set1;
	}
	
	public static boolean Contains(Vertex[] set, Vertex v){
		
		for(int i=0;i<set.length;i++){
			if(set[i].getID() == v.getID()){
				return true;
			}
		}
		return false;
	}
	
	public static boolean Contains(int[] set, int e){
		
		for(int i=0;i<set.length;i++){
			if(set[i] == e){
				return true;
			}
		}
		return false;
	}
	
	public static void printElements (Vertex[] set){
		
		System.out.println("\nElements:");
		for(int i=0;i<set.length;i++){
			System.out.print(set[i].getID()+", ");
		}
		System.out.println("\n");
	}
}