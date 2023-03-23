package com.example.webServicesapp9responseentity;

import java.io.File;
import java.io.FileInputStream;
import org.springframework.core.io.InputStreamResource;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	// ResponseEntity - body and status code
	
	@GetMapping("service1")
	public ResponseEntity<String> service1(){
		ResponseEntity<String> responseEntity = 
				new ResponseEntity<String>("success", HttpStatus.OK);
		return responseEntity;		
	}   // 200 OK success
	
	@GetMapping("service2")
	public ResponseEntity<List<String>> service2(){
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("xyz");
		list.add("hello");
		ResponseEntity<List<String>> responseEntity = 
				new ResponseEntity<List<String>>(list, HttpStatus.OK);
		return responseEntity;		
	}
	
	@GetMapping("service3")
	public ResponseEntity<Person> service3(){
		Person person = new Person();
		person.setFirstName("abc");
		person.setFirstName("xyz");
		ResponseEntity<Person> responseEntity = 
				new ResponseEntity<Person>(person, HttpStatus.OK);
		return responseEntity;		
	}
	
	@GetMapping("service4/{age}")
	public ResponseEntity<String> service4(@PathVariable Integer age){
		ResponseEntity<String> responseEntity = null;
		if(age <= 0) {
			responseEntity = new ResponseEntity<String>("age should not be 0 or negative", 
														HttpStatus.BAD_REQUEST);
		}
		else {
			responseEntity = 
			new ResponseEntity<String>("Your age is " + age, HttpStatus.OK);
		}
		return responseEntity;		
	}
	
	@GetMapping("service5/{yearOfBirth}")
	public ResponseEntity<String> service5(@PathVariable Integer yearOfBirth){
		ResponseEntity<String> responseEntity = null;
		Integer age = null;
		if(yearOfBirth > 2020) {
			responseEntity = 
		new ResponseEntity<String>("Year of birth should not be greater than current year", 
														HttpStatus.BAD_REQUEST);
		}
		else {
			age = 2020 - yearOfBirth;
			responseEntity = 
			new ResponseEntity<String>("Your age is " + age, HttpStatus.OK);
		}
		return responseEntity;		
	}  // http://localhost:9099/service5/2021   // 400 Bad Request
	
	
	// most suitable approach
	@GetMapping("service6/{yearOfBirth}")
	public ResponseEntity<String> service6(@PathVariable Integer yearOfBirth){
		ResponseEntity<String> responseEntity = null;
		Integer age = null;
		if(yearOfBirth > 2020) {
			responseEntity = ResponseEntity.badRequest().body("Year of birth should not be greater than current year");
		}
		else {
			age = 2020 - yearOfBirth;
			responseEntity = ResponseEntity.ok().body("Your age is " + age);		
		}
		return responseEntity;		
	}
	
	// ResponseEntity - body, headers and status code
	
	@GetMapping("service7")
	public ResponseEntity<String> service7(){
		return ResponseEntity.ok().body("<h1>Hello to all</h1>");   // responseentity with ok and body(content of the body Hello to all with h1 tag)
	}   // by default REST API output is inform of HTML
	
	@GetMapping("service8")   // plain text
	public ResponseEntity<String> service8(){
		return ResponseEntity.
						 ok().
						 header("content-type", "text/plain").
						 body("<h1>Hello to all</h1>");
	}
	
	@GetMapping("service9")   // specifying as HTML
	public ResponseEntity<String> service9(){
		return ResponseEntity.
						 ok().
						 header("content-type", "text/html").  // some kind of meta information to the browser how this response should be handeled by the browser
						 body("<h1>Hello to all</h1>");
	}	
	
	int counter = 0;
	
	@GetMapping("service10")
	public ResponseEntity<String> service10(){
		counter ++;
		return ResponseEntity.
						 ok().
						 header("content-type", "text/html").
						 header("refresh", "4").
						 body("<h1>counter value: " + counter + "</h1>");
	}	
	
	@GetMapping("service11")
	public ResponseEntity<String> service11(){
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", "text/html");
		headers.add("refresh", "4");
		
		counter ++;
		
		String responseBody = "<h1>counter value: " + counter + "</h1>";
		
		ResponseEntity<String> responseEntity = 
				new ResponseEntity<String>(responseBody,
										   headers,
										   HttpStatus.OK);
		return responseEntity;
	}	
	
	@GetMapping("service12")
	public ResponseEntity<Object> service12() throws Exception{
		File file = new File("src/main/resources/application.properties");
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-disposition", "attachment;filename=" + file.getName());
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		ResponseEntity<Object> responseEntity = 
				ResponseEntity.ok().headers(headers).body(resource);
		return responseEntity;
	}
	
	@GetMapping("service13")
	public ResponseEntity<Object> service13() throws Exception{
		File file = new File("src/main/resources/static/downloads/laralogo.png");
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-disposition", "attachment;filename=" + file.getName());
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		ResponseEntity<Object> responseEntity = 
				ResponseEntity.ok().headers(headers).body(resource);
		return responseEntity;
	}
	
}
