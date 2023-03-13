package com.example.microServicesapp3OpenFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
	private ProxyForApp4Server proxyForApp4Server;
	
	@GetMapping(path="/hello1")
	public String hello1() {
		System.out.println("from hello1");
		String results = proxyForApp4Server.callTest1();
		return "from hello1" + results;
	}
}
