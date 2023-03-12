package com.example.webServicesapp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebServicesApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(WebServicesApp1Application.class, args);
		System.out.println("WebServicesApp1Application started...");
	}
	@GetMapping("hello")
	public String hello() {
		System.out.println("hello is executng");
		return "This message is from hello";
	}
}
