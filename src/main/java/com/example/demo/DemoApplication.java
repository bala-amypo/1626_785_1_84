package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class, 
    HibernateJpaAutoConfiguration.class,
    JpaRepositoriesAutoConfiguration.class
}, scanBasePackages = {
    "com.example.demo.config"
})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	static class SimpleController {
		@GetMapping("/api/health")
		@Operation(summary = "Health check")
		public String health() {
			return "OK";
		}
	}
}
