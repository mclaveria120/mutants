package mutants.controllers;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mutants.detector.MutantDetector;
import mutants.dtos.DNASecuenceDTO;
import mutants.services.DNAService;

@RestController
public class DNAAnalyzerController {

	private static final Logger logger = LoggerFactory.getLogger(DNAAnalyzerController.class);
	
	@Autowired
	private MutantDetector mutantDectors;
	
	@Autowired
	private DNAService dnaAnalyzerService;
	
	@PostMapping(value = "/mutant")
	public void isMutant(@RequestBody DNASecuenceDTO dnaSecuence, HttpServletResponse response) throws InterruptedException { 
			String[] dna = dnaSecuence.getDna();
			this.mutantDectors.initialValidation(dna);
			boolean isMutant = this.mutantDectors.isMutant(dna);
			this.dnaAnalyzerService.saveDNA(dna, isMutant);
			response.setStatus(isMutant ? HttpServletResponse.SC_OK : HttpServletResponse.SC_FORBIDDEN);
	}
}
