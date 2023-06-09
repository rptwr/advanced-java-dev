package com.example.jpaapp2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	// framework only providing value to PersonRepository because of autowired // we dont require to develop subclass to the interface 
	// creating an object to subclass automatically we will be getting object from the framework
	// framework will take care of developing a subclass to person repository interface creating an object assigning that object to our attribute 
	// just because of autowired.
	
	@Autowired   // object type will be automatically wiring by the framework
	private PersonRepository personRepository; // now we can use method from PersonRepository
	
	@RequestMapping(path = "save", method = RequestMethod.POST)
	public Person save(@RequestBody Person person) {
		personRepository.save(person);
		return person;
		// personRepository containing save method straight away we are using 
		// save method and returning saved object back to the consumer
	}
	
	@RequestMapping(path = "savePersons", method = RequestMethod.POST)
	public String savePersons(@RequestBody AllPersons allPersons) {
		personRepository.saveAll(allPersons.getPersons());  
		return "success";
	}
	
	@RequestMapping(path = "update", method = RequestMethod.PUT)
	public Person update(@RequestBody Person person) {
		personRepository.save(person);
		return person;
	}
	
	@RequestMapping(path = "patch", method = RequestMethod.PATCH)
	public Person patching(@RequestBody Person person) {
		Person dbPerson = personRepository.findById(person.getId()).get();
		if(person.getFirstName() != null ) {
			dbPerson.setFirstName(person.getFirstName());
		}
		if(person.getLastName() != null ) {
			dbPerson.setLastName(person.getLastName());
		}
		personRepository.save(dbPerson);
		return dbPerson;
	}
	
	
	
	
	
}












/*
 Inside Person Controller declare PersonRepository as attribute
 
 */

//{
//	"persons": [
//	            {
//	            	"id": 101,
//	            	"firstName": "abc",
//	            	"lastName": "xyz"
//	            }, 
//	            {
//	            	"id": 102,
//	            	"firstName": "tuv",
//	            	"lastName": "xyz"
//	            },
//	            {
//	            	"id": 103,
//	            	"firstName": "pqr",
//	            	"lastName": "xyz"
//	            }
//	           ]
//}