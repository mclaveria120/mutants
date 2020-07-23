package mutant;

import org.junit.Assert;
import org.junit.Test;

import mutants.detector.Matrix;

public class MatrixTests {

	@Test
	public void createMatrixTest() {
		String[] data = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		char[][] matrix = Matrix.createMatrix(data,data.length, data.length);
		for (int i = 0; i < matrix.length; i++) {
			Assert.assertTrue((new String(matrix[i]).compareTo(data[i])==0));
		}
	}
	
	@Test
	public void transposeMatrixTest() {
		String[] data = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		char[][] matrix = Matrix.createMatrix(data,data.length, data.length);
		Matrix.transposeMatrix(matrix,data.length, data.length);
		Matrix.transposeMatrix(matrix,data.length, data.length);
		for (int i = 0; i < matrix.length; i++) {
			Assert.assertTrue((new String(matrix[i]).compareTo(data[i])==0));
		}
	}
	
	@Test
	public void diagonalsMatrixTest() {
		String[] data = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		char[][] matrix = Matrix.createMatrix(data,data.length, data.length);
		String[] diagonals = Matrix.getDiagonals(matrix, data.length);
		Assert.assertTrue((new String(diagonals[0]).compareTo("AAAATG")==0));
		Assert.assertTrue((new String(diagonals[1]).compareTo("AGTACT")==0));
	}
	
}
