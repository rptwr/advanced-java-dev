package com.example.microServicesapp2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App2Controller {
	
	@RequestMapping("app2Service")
	public String app2Service() {
		System.out.println("App2Controller - service");
		return "success from app2 - service";
	}  
}
