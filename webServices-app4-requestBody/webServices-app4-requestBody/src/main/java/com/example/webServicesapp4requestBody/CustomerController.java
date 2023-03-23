package com.example.webServicesapp4requestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@PostMapping
	public Customer save(@RequestBody Customer customer) {
		System.out.println("id:" + customer.getCustomerId());
		System.out.println("first name:" + customer.getFirstName());
		System.out.println("last name:" + customer.getLastName());
		System.out.println("house no:" + customer.getCustomerAddress().getHouseNo());
		System.out.println("street name:" + customer.getCustomerAddress().getStreetName());		
		return customer;
	}
	
}

// http://localhost:9094/customer

//{
//	"customerId": "A101",
//	"firstName": "ravi",
//	"lastName": "tiwari",
//	"customerAddress": {
//		"houseNo": "121/M",
//		"streetName": "BTM"
//	}
//}