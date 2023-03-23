package com.example.webServicesapp2returntype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebServicesApp2ReturnTypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServicesApp2ReturnTypeApplication.class, args);
		System.out.println("WebServicesApp2ReturnTypeApplication started...");
	}
	
	@RequestMapping("h1")   // http://localhost:9092/h1  <---  api
	public String hello1() {
		System.out.println("from hello1");
		return "hello from rest API";
	}
	
	@RequestMapping("t1")  // http://localhost:9090/t1
	public int hello2() {
		System.out.println("from hello2");
		return 600;
	}
		// We can return any primitvie type
	@RequestMapping("xyz")
	public Boolean test3() {
		System.out.println("from hello3");   // sop is only for whether it is running or not
		return true;
	}
	
	@RequestMapping("test")
	public int[] hello4() {		//http://localhost:9090/test
		System.out.println("from hello4");
		int[] elements = {10, 20, 30};
		return elements;
	}
	
	@RequestMapping("test1")
	public String[] hello5() {
		System.out.println("from hello5");
		String[] elements = {"abc", "xyz", "test", "hello"};
		return elements;
	}
	
	// collection object also we can return
	@RequestMapping("test2")     
	public ArrayList<String> hello6(){
		System.out.println("from hello6");
		ArrayList<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("xyz");
		list.add("hello");
		return list;
	}
	
	@RequestMapping("test3")
	public HashSet<Integer> test7(){
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(90);
		set.add(900);
		set.add(789);
		set.add(100);
		set.add(9);
		return set;
	}
	
	@RequestMapping("test4")
	public HashMap<String, String> test8(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("firstName", "Ramu");
		map.put("lastName", "Murali");
		map.put("address", "BTM");
		return map;
	}
	
	@RequestMapping("p1")
	public Person getPerson() {
		Person person = new Person();
		person.setFirstName("Vijay");
		person.setLastName("kumar");		
		return person;
	}
	
	@RequestMapping("a1")
	public Address test9() {
		Address add = new Address();
		add.setHouseNo("123/M");
		add.setStreetName("BTM");
		return add;		
	}
	
	// employee with address    // has-a relation
	@RequestMapping("employee")
	public Employee getEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("abc");
		employee.setLastName("xyz");
		employee.setAge(22);
		Address address = new Address();
		address.setHouseNo("234/U");
		address.setStreetName("BTM");
		employee.setAddress(address);
		return employee;
	}
}


