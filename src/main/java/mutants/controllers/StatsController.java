package mutants.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mutants.dtos.StatsDTO;
import mutants.entities.Stats;
import mutants.services.DNAService;

@RestController
public class StatsController {

	@Autowired
	private DNAService dnaService;
	
	@GetMapping(value = "/stats")
	public StatsDTO getStats() {
			Stats stats = this.dnaService.getStats();  
			return convertStartsToStastDTO(stats);
	}
	
	private StatsDTO convertStartsToStastDTO(Stats stats){
		StatsDTO statsDTO = new StatsDTO();
		statsDTO.setCount_human_dna(stats.getNumberOfHumans());
		statsDTO.setCount_mutant_dna(stats.getNumberOfMutants());
		statsDTO.setRatio(stats.getNumberOfHumans()!=0 ? stats.getNumberOfMutants()* 1.0/stats.getNumberOfHumans() : 0);
		return statsDTO;
	}
}
