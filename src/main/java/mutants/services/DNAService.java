package mutants.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import mutants.entities.Human;
import mutants.entities.Mutant;
import mutants.entities.Stats;
import mutants.reposotory.HumanRepository;
import mutants.reposotory.MutantRepository;

@Service
public class DNAService {

	@Autowired
	private MutantRepository mutantRepository;
	
	@Autowired
	private HumanRepository humanRepository;
	
	@Async
	public void saveDNA(String[] dna, boolean isMutant){
		String data = String.join(" ", dna);
		if(isMutant){
			this.mutantRepository.save(new Mutant(data));
		}else{
			this.humanRepository.save(new Human(data));
		}
	}
	
	public boolean checkDNA(String[] dna){
		String data = String.join(" ", dna);
		return this.mutantRepository.findById(data).isPresent() ||
		this.humanRepository.findById(data).isPresent();
	}
	
	private int getNumberOfMutants(){
		return (int) this.mutantRepository.count();
	}
	
	private int getNumberOfHumans(){
		return (int) this.humanRepository.count();
	}
	
	public Stats getStats(){
		Stats stats = new Stats();
		stats.setNumberOfHumans(this.getNumberOfHumans());
		stats.setNumberOfMutants(this.getNumberOfMutants());
		return stats;	
	}
}
