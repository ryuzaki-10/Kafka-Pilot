package kafka.sample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaPilotApplication {

	public static void main(String[] args) {

		SpringApplication.run(KafkaPilotApplication.class, args);
		System.out.println("hello world");
	}
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			for(int i=0;i<10_000;i++)
				kafkaTemplate.send("event-topic","hello-kafka "+i);
		};
	}

}
