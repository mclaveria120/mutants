package mutant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mutants.detector.MutantDetector;
import mutants.exceptions.InvalidDNAException;

public class MutantDetectorTest {

	private MutantDetector mutantDetector;
	
	@Before
	public void initialize() {
		mutantDetector = new MutantDetector();
	}
	
	
	@Test(expected=InvalidDNAException.class)
	public void invalidSecuenceOnDNATest() {
		String[] dnaSecuence = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCAZVVCTG"};
		this.mutantDetector.initialValidation(dnaSecuence); 
	}
	
	@Test(expected=InvalidDNAException.class)
	public void innvalidSecuenceNumberOfDNATest() {
		String[] dnaSecuence = {"ATGCGA","CAGTGC","TTATGT","AGAAGAAAAAG","CCCCTA","TCAZVVCTG", "A"};
		this.mutantDetector.initialValidation(dnaSecuence); 
	}
	
	@Test
	public void validMutantTest() {
		String[] dnaSecuence = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		this.mutantDetector.initialValidation(dnaSecuence); 
		Assert.assertTrue(this.mutantDetector.isMutant(dnaSecuence));
	}
	
	@Test
	public void validHumanTest() {
		String[] dnaSecuence = {"ATACCA","CTGTGC","TTATGT","AGAAGG","CCACTA","TCACTG"};
		this.mutantDetector.initialValidation(dnaSecuence); 
		Assert.assertFalse(this.mutantDetector.isMutant(dnaSecuence));
	}
	
	@Test
	public void validMutantHorizontalMatchTest() {
		String[] dnaSecuence = {"ATGCGA","CAGTGC","TTTTGT","AGAAGG","CCCCTA","TCACTG"};
		this.mutantDetector.initialValidation(dnaSecuence); 
		Assert.assertTrue(this.mutantDetector.isMutant(dnaSecuence));
	}
	
	@Test
	public void validMutantHorizontalandDiagonalMatchTest() {
		String[] dnaSecuence = {"TTGCGA","CTGTGC","TATAGT","AGATGG","CCCCTA","TCACTG"};
		this.mutantDetector.initialValidation(dnaSecuence); 
		Assert.assertTrue(this.mutantDetector.isMutant(dnaSecuence));
	}
	
	@Test
	public void validMutantHorizonalAndVerticalMatchTest() {
		String[] dnaSecuence = {"GTGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		this.mutantDetector.initialValidation(dnaSecuence); 
		Assert.assertTrue(this.mutantDetector.isMutant(dnaSecuence));
	}
	
}
