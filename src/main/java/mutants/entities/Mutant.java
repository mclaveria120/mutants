package mutants.entities;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("mutant")
public class Mutant implements Serializable {

	private String id;
	
	public Mutant(String id) {
		this.setId(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
