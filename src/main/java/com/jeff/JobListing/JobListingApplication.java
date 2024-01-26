package com.jeff.JobListing;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication


public class JobListingApplication {

	@Bean
    public GroupedOpenApi controllerApi() {
        return GroupedOpenApi.builder()
                .group("controller-api")
                .packagesToScan("com.jeff.JobListing") // Specify the package to scan
                .build();
    }

	public static void main(String[] args) {
		SpringApplication.run(JobListingApplication.class, args);
	}

    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/posts").allowedOrigins("http://localhost:3000");
                //registry.addMapping("/posts").allowedOrigins("http://job-hunting-app-cb9818296d91.herokuapp.com/posts");
			}
		};
	}

}
