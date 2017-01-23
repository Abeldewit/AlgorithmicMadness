public class DegreeSort{
  
    public static Vertex[] sortByDegree(Vertex[] array) {
        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i].getDegree() < array[k].getDegree()) {
                    swap(i, k, array);
                }
            }
        }
		return array;
    }
	
	public static Vertex[] sortByDegeneracy(Vertex[] array) {
        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i].getDegree() > array[k].getDegree()) {
                    swap(i, k, array);
                }
            }
        }
		return array;
    }
	
	public static Vertex[] sortBySatur(Vertex[] array) {
        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i].getSatur() < array[k].getSatur()) {
                    swap(i, k, array);
                }
            }
        }
		return array;
    }
  
    private static void swap(int i, int j, Vertex[] array) {
  
        Vertex temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}