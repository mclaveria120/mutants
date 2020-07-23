package mutants.reposotory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mutants.entities.Mutant;

@Repository
public interface MutantRepository extends CrudRepository<Mutant, String> {
	
}
