package mutants.detector;


public class Matrix {

	public static char[][] createMatrix (String[]  data, int n, int m) {
	     char[][] matrix = new char[n][m];
	      for (int i = 0; i < n; i++) {
	         for (int j = 0; j < m; j++) {
	            matrix[i][j] = data[i].charAt(j);
	         }
	      }
	      return matrix; 
	}
	
	public  static void transposeMatrix(char matrix[][],  int n, int m) { 
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < m; j++){ 
                 char temp = matrix[i][j]; 
                 matrix[i][j] = matrix[j][i]; 
                 matrix[j][i] = temp; 
            }
        }
	} 

	public static void printMatrix(char[][] matrix, int n, int m){
		for (int i = 0; i < n; i++) {
	         for (int j = 0; j < m; j++) {
	            System.out.print(matrix[i][j]+" ");
	         }
	         System.out.println(" ");
	      }
	}
	
	public static  String[] getDiagonals(char mat[][], int n) { 
		String[] diagonals ={"",""};
		for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) { 
            	if (i == j) diagonals[0]+=mat[i][j]+"";
            	if ((i + j) == (n - 1)) diagonals[1]+=mat[i][j]+"";
            } 
        } 
       return diagonals;
    } 
	
	public static String[] toStringArray (char[][] matrix, int n) {
		String[] data = new String[n];
	      for (int i = 0; i < n; i++) {
	        	data[i] = new String(matrix[i]);
	      }
	      return data; 
	}
}
