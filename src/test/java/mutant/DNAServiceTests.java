package mutant;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mutants.MutantsApplication;
import mutants.detector.MutantDetector;
import mutants.services.DNAService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TestRedisConfiguration.class, MutantsApplication.class} )
public class DNAServiceTests {
 
    @Autowired
    private DNAService dnaService;
    
    @Autowired
	private MutantDetector mutantDetector;
 
    @Test
    public void savingMutantDNATest() throws InterruptedException {
    	String[] dnaSecuence = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    	mutantDetector.initialValidation(dnaSecuence);
    	boolean isMutatnt = mutantDetector.isMutant(dnaSecuence);
    	dnaService.saveDNA(dnaSecuence, isMutatnt);
    	Thread.sleep(100L);
    	Assert.assertTrue(this.dnaService.getStats().getNumberOfMutants()==1);
    }
    
    @Test
    public void savingHumanDNATest() throws InterruptedException {
    	String[] dnaSecuence = {"ATACCA","CTGTGC","TTATGT","AGAAGG","CCACTA","TCACTG"};
    	mutantDetector.initialValidation(dnaSecuence);
    	boolean isMutatnt = mutantDetector.isMutant(dnaSecuence);
    	dnaService.saveDNA(dnaSecuence, isMutatnt);
    	Thread.sleep(100L);
    	Assert.assertTrue(this.dnaService.getStats().getNumberOfHumans()==1);
    }
    
    @Test
    public void checkingHumanDNAExistanceTest() throws InterruptedException {
    	String[] dnaSecuence = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    	mutantDetector.initialValidation(dnaSecuence);
    	boolean isMutatnt = mutantDetector.isMutant(dnaSecuence);
    	dnaService.saveDNA(dnaSecuence, isMutatnt);
    	Thread.sleep(100L);
    	Assert.assertTrue(dnaService.checkDNA(dnaSecuence));
    }
}