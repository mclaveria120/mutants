package mutants.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisProperties {

	private int redisPort;
	private String redisHost;

	public RedisProperties(@Value("${redis.port}") int redisPort,
			@Value("${redis.host}") String redisHost) {
		this.setRedisPort(redisPort);
		this.setRedisHost(redisHost);
	}

	public int getRedisPort() {
		return redisPort;
	}

	public void setRedisPort(int redisPort) {
		this.redisPort = redisPort;
	}

	public String getRedisHost() {
		return redisHost;
	}

	public void setRedisHost(String redisHost) {
		this.redisHost = redisHost;
	}

}