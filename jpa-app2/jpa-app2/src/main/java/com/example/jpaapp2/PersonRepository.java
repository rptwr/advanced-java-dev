package com.example.jpaapp2;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	
}

// CrudRepository<Person, Integer> first field is for which entity we are trying to develop a repository
// second field is Primary key attribute data type.
// For the CrudRepository several method inherited to interface