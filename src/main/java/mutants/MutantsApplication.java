package mutants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication()
@EnableAsync
public class MutantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutantsApplication.class, args);
	}

	@Bean
	public TaskExecutor getAsyncExecutor(@Value("${spring.async.corepoolsize}") int corePoolSize,
			@Value("${spring.async.maxpoolsize}") int maxPoolSize) {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(corePoolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setThreadNamePrefix("Async-");
		return executor;
	}
}