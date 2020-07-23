package mutants.reposotory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mutants.entities.Human;

@Repository
public interface HumanRepository extends CrudRepository<Human, String> {
	
}
