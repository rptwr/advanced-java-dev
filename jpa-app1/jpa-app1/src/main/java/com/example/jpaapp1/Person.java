package com.example.jpaapp1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity    
public class Person // Now Person class is qualified as Entity class
{
	@Id 
	private Integer personId;
	private String firstName;
	private String lastName;
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
