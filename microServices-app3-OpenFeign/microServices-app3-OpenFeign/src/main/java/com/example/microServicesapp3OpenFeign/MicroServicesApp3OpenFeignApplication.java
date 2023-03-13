package com.example.microServicesapp3OpenFeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.example.microServicesapp3OpenFeign")
public class MicroServicesApp3OpenFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesApp3OpenFeignApplication.class, args);
		System.out.println("MicroServicesApp3OpenFeignApplication started...");
	}

}
