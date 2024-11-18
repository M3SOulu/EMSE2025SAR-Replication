package edu.baylor.ecs.qms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuestionManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionManagementApplication.class, args);
	}

}
