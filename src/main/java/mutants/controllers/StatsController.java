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
		if(stats.getNumberOfHumans()!=0){
			statsDTO.setRatio(stats.getNumberOfMutants()/stats.getNumberOfHumans());
		}else{
			statsDTO.setRatio(0);
		}
		return statsDTO;
	}
}
