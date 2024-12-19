package com.example.socksinstock;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class SocksInStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocksInStockApplication.class, args);
	}

}
