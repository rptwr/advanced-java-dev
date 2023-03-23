package com.example.webServicesapp11emailverify;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	public Person findByUsername(String email);
}
