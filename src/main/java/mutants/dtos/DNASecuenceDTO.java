package mutants.dtos;

import java.io.Serializable;

public class DNASecuenceDTO implements Serializable{

	private String[] dna;
	
	public DNASecuenceDTO(String[] dna) {
		this.dna = dna;
	}
	public DNASecuenceDTO(){
		
	}
	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}
}
