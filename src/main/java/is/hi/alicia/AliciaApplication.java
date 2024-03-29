package is.hi.alicia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AliciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AliciaApplication.class, args);
	}
}
