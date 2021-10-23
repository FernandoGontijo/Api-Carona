package com.gontijo.fernando.carona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CaronaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaronaApplication.class, args);
	}

}
