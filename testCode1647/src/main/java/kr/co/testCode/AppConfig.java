package kr.co.testCode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	Corn corn() {
		return new Corn();
	}
}
