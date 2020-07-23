package mutants.entities;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("human")
public class Human implements Serializable {

	private String id;
	
	public Human(String id) {
		this.setId(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
