package com.example.webServicesapp4requestBody;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emp")
public class EmployeeController {

	@RequestMapping(path = "save", method = RequestMethod.POST)
	public Employee saveEmp(@RequestBody Employee employee) {
		System.out.println("Id:" + employee.getId());
		System.out.println("First Name:" + employee.getFirstName());
		System.out.println("Last Name:" + employee.getLastName());
		System.out.println("Mail accounts:" + Arrays.toString(employee.getMailAccounts()));  // to print and read content of array use Arrays.toString
		return employee;
	}
}

//http://localhost:9094/emp/save


//{
//  	"id": 101,
//	"firstName": "abc",
//  	"lastName": "xyz",
//  	"mailAccounts": ["a@abc.com", "b@bbc.com"]
//}

