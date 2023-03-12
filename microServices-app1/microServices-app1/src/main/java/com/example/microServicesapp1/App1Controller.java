package com.example.microServicesapp1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class App1Controller {
	
	@RequestMapping("app1Service")
	public String app1Service() {
		System.out.println("App1Controller - service");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:9092/app2Service", 
																			String.class);   // by using restTemplate giving call to getForEntity and specifying the
																				// the target service URL to which service we are making call & second argument is return type of API
		String response = responseEntity.getBody();  // get the body content from responseEntity
		return "success from app1 - service ===> " + response;
	}   
}

// Define a RestTemplate inside that there is a method getForEntity() supplying the URL and return type the getBody()
// RestTemplate is the oldest way 