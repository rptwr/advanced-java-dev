package com.example.jpaapp2;

import java.util.ArrayList;
import java.util.List;

public class AllPersons {
	
	private List<Person> persons = new ArrayList<Person>();

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
}
