package com.besmartexim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "MasterdataManagement API", version = "1.0", description = "Masterdata Related APIs"))
@SpringBootApplication
public class BesmarteximMasterdataManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BesmarteximMasterdataManagementApplication.class, args);
	}

}
