package com.example.webServicesapp4requestBody;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")  // hello is class level path /URL
public class TestController {

	@RequestMapping("/h1")	// http://localhost:9094/hello/h1
	public String hello1() {
		return "from hello1";
	}
	
	@RequestMapping("/h2")  // http://localhost:9094/hello/h2
	public String hello2() {
		return "from hello2";
	}
	
	@RequestMapping()  // http://localhost:9094/hello
	public String hello3() {
		return "from hello3";
	} 
	
	@RequestMapping("/h4")   // http://localhost:9094/hello/h4
	public String hello4() {
		return "i am from hello4";
	}

	@RequestMapping(path = "h5", method = RequestMethod.POST)
	public Person hello5(@RequestBody Person person) {
		System.out.println("from hello5:" + person.getFirstName());
		System.out.println("from hello5:" + person.getLastName());
		return person;
	}
	
}

// http://localhost:9094/hello/h5

//{
//	"firstName": "abc",
//  	"lastName": "xyz"
//}










