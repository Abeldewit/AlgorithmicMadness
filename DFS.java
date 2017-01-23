public class DFS{

	private static int chr;
	
	public DFS( int LB, int HB, int[][] matrix ){

		GraphColoring dfs = new GraphColoring();
		int noc = LB;
		
		while(dfs.graphColor(matrix,noc) == 0 &&
			  noc<=HB){
		 	noc++;
		}
		
		chr = dfs.graphColor(matrix,noc);
		System.out.println("Chromatic number:"+chr);
	}
	
	public static int getChr(){
		return chr;
	}
}
class GraphColoring
{
    private int noc;
    private int[] color;
    private int[][] matrix;
	private int length;

    /** Function to assign color **/
    public int graphColor(int[][] matrix, int noc)
    {
        
		this.noc = noc;
		this.matrix = matrix;
		length = matrix.length;
        color = new int[length];
 
        try
        {
            Solve(0);
            System.out.println("No solution");
						return 0;
        }
        catch (Exception e)
        {
            System.out.println("\nSolution exists ");
            int chroma = display();
						return chroma;
        }
    }
    //assign colors recursively
    public void Solve(int v) throws Exception
    {
        /** base case - solution found **/
        if (v == length)
            throw new Exception("Solution found");
        /** try all colours **/
        for (int c = 1; c <= noc; c++)
        {
            if (isPossible(v, c))
            {
                /** assign and proceed with next vertex **/
                color[v] = c;
                Solve(v + 1);
                /** wrong assignement **/
                color[v] = 0;
            }
        }
    }
    /** function to check if it is valid to allot that color to vertex **/
    public boolean isPossible(int v, int c)
    {
        for (int i = 0; i < length; i++)
            if (matrix[v][i] == 1 && c == color[i])
                return false;
        return true;
    }
    /** display solution **/
    public int display()
    {
				int max=0;
        System.out.print("\nColors : ");
        for (int i = 0; i < length; i++)
            System.out.print(color[i] +" ");
        System.out.println();
				for (int i = 0; i<length; i++ ) {
						if(color[i] > max) {
							max = color[i];
						}
				}
				return max;
    }
}
