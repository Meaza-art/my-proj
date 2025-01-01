package spring.api.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Matches all endpoints
						.allowedOrigins("http://localhost:3000") // Specify trusted origins, e.g., your frontend URL
						.allowedMethods("GET", "POST", "PUT", "DELETE") // Limit allowed methods
						.allowedHeaders("*")
						.allowCredentials(true) // Allow credentials (use with caution if `allowedOrigins` is "*")
						.maxAge(3600); // Cache pre-flight responses for 1 hour
			}
		};
	}
}
