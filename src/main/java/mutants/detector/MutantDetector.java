package mutants.detector;

import org.springframework.stereotype.Service;

import mutants.exceptions.InvalidDNAException;

@Service
public class MutantDetector {

	public void initialValidation(String[] data){
		String validSecuence = NitrogenousBaseType.DNA.getName();
		int length = data.length;
		for (int i = 0; i < length; i++) {
			if (!data[i].matches("["+validSecuence+"]*") || data[i].length() != length) {
				throw new InvalidDNAException();
			}
		}
	}
	
	public boolean isMutant(String[] dnaSecuence){
			int counter = 0;
			counter+=horizontalSearch(dnaSecuence);
			if(counter>1){
				 return true;
			 }
			counter+=verticalSearch(dnaSecuence);
			if(counter>1){
				 return true;
			 }
			counter+=diagonalSearch(dnaSecuence);
			if(counter>1){
				return true;
			}
		return false;
	}
	
	private boolean isAMatch(String nitrogenouysBase){
		return  (nitrogenouysBase.contains("AAAA") || nitrogenouysBase.contains("CCCC") 
				|| nitrogenouysBase.contains("TTTT") || nitrogenouysBase.contains("GGGG"));
	}
	
	private  int horizontalSearch(String[] data) {
		int counter=0;
		for (int i = 0; i < data.length; i++) {
			String word = data[i];
			 if(this.isAMatch(word)){
				counter++;
			 }
			 if(counter>1){
				 return counter;
			 }
		}
		return counter;
	}
	
	private int verticalSearch(String[] data) {
		int n =  data[0].length();
		char[][] matrix = Matrix.createMatrix(data, n,n);
		Matrix.transposeMatrix(matrix, n,n);
		data = Matrix.toStringArray(matrix, n);
		return horizontalSearch(data);
	}
	
	private int diagonalSearch(String[] data){
		int n =  data[0].length();
		char[][] matrix = Matrix.createMatrix(data, n,n);
		data = Matrix.getDiagonals(matrix,n);
		return horizontalSearch(data);
	}
}
