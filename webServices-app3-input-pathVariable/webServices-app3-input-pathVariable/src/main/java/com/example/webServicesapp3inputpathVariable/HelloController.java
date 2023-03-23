package com.example.webServicesapp3inputpathVariable;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("test1/{id}")    // http://localhost:9093/test1/23  // whatever value we supply in place of id it will be assigning to id automatically
	public String test1(@PathVariable Integer id) {
		System.out.println("from test1");
		return "id value:" + id;   // id value:23
	}
	
	@RequestMapping("test2/{firstName}")  // http://localhost:9093/test2/ravi
	public String test2(@PathVariable String firstName) {
		System.out.println("from test2");
		return "id value:" + firstName;
	}
	
	@RequestMapping("test3/{firstName}/{age}")  // http://localhost:9093/test3/ravi/12
	public String test3(@PathVariable String firstName, @PathVariable Integer age) {
		System.out.println("from test3");
		return "id value:" + firstName + ":" + age;
	}
	
	// Same Api in more meaningful way
	@RequestMapping("test4/firstName/{firstName}/age/{age}")  // http://localhost:9093/test4/firstName/ravi/age/12
	public String test4(@PathVariable String firstName, @PathVariable Integer age) {
		System.out.println("from test4");
		return "id value:" + firstName + ":" + age;
	}
	
	@RequestMapping("test5/{num1}")
	public Integer test5(@PathVariable Integer num1) {
		int squareValue = num1 * num1;
		return squareValue;  // 100
	}  // http://localhost:9093/test5/10
	
	@RequestMapping("test6/num1/{num1}")
	public Integer test6(@PathVariable Integer num1) {
		int squareValue = num1 * num1;
		return squareValue;
	}  // http://localhost:9093/test6/num1/10

	@RequestMapping("test7/{num1}/{num2}")
	public Integer test7(@PathVariable Integer num1, @PathVariable Integer num2) {
		int sumValue = num1 + num2;;
		return sumValue;
	}  // http://localhost:9090/test7/20/10

	@RequestMapping("test8/num1/{num1}/num2/{num2}")
	public Integer test8(@PathVariable Integer num1, @PathVariable Integer num2) {
		int sumValue = num1 + num2;;
		return sumValue;   // 30
	}  // http://localhost:9093/test8/num1/20/num2/10

	@RequestMapping("test9/{param1}")
	public Double test9(@PathVariable("param1") Integer num1) {
		double squareRoot = Math.sqrt(num1);
		return squareRoot;  // 4.47213595499958
	}  // http://localhost:9093/test9/20
	
	@RequestMapping("test10/{hello}")
	public String test10(@PathVariable("hello") String firstName) {
		return "first name:" + firstName;
	}
	
	// http://localhost:9093/test10/ravi
	
	
	
}
