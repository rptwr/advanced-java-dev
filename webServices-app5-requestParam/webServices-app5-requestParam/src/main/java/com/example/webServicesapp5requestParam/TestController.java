package com.example.webServicesapp5requestParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	// It is a get mapping we can go for browser address bar itself
	// in the URL after question mark whatever we are supply is query string // & is separator between the parameters
	@RequestMapping("test1")   //		http://localhost:9095/test1?param1=Hello
	public String test1(@RequestParam String param1) // inside path we are not specifying anything about input field
	{
		System.out.println("from test1");
		return "value of param1:"+ param1;
	}
	
	@RequestMapping("test2")	//  http://localhost:9095/test2?firstName=vijay&lastName=test
	public String test2(@RequestParam String firstName, @RequestParam String lastName) {
		String fullName = firstName + " " + lastName;
		return "Full Name:" + fullName;
	}
	
	@RequestMapping("test3")  //http://localhost:9095/test3?age=25
	public String test3(@RequestParam Integer age) {
		System.out.println("age value:" + age);
		return "Age is : " + age;
	}

	// default value of required is true for the @RequestParam 
	@RequestMapping("test4")	//http://localhost:9095/test4?lastName=abc
	public String test4(@RequestParam(required = false) String lastName) {
		System.out.println("last name:" + lastName);
		return "last name:" + lastName;
	}	//http://localhost:9095/test4    // last name:null
	
	@RequestMapping("test5")	//http://localhost:9095/test5?lastName=abc
	public String test5(@RequestParam(required = true) String lastName) {
		System.out.println("last name:" + lastName);
		return "last name:" + lastName;
	}	
	
	@RequestMapping("test6")	//http://localhost:9095/test6?param1=abc
	public String test6(@RequestParam(name = "param1") String lastName) {
		System.out.println("last name:" + lastName);
		return "last name:" + lastName;
	}	

	@RequestMapping("test7")	//http://localhost:9095/test7?param1=abc
	public String test7(@RequestParam(value = "param1") String lastName) {
		System.out.println("last name:" + lastName);
		return "last name:" + lastName;
	}	

	@RequestMapping("test8")	//http://localhost:9095/test8?lastName=vijay
	public String test8(@RequestParam(defaultValue = "abc") String lastName) {
		System.out.println("last name:" + lastName);
		return "last name:" + lastName;
	}						   //http://localhost:9095/test8   // last name:abc


}


// status 400(Bad input) ---> if input is not proper
// status 404(Not Found) ---> requested resource is not available 
// status 500(Internal Server Error) ---> if any unhandeled exceptiton occurs on server side




