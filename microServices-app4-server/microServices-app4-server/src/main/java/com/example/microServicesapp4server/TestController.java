package com.example.microServicesapp4server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping(path="/test1")
	public String test1() {
		System.out.println("I am from test1");
		return "i am from test1";
	}
}
