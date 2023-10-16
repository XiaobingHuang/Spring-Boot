package com.jeff.JobListing;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

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

}
