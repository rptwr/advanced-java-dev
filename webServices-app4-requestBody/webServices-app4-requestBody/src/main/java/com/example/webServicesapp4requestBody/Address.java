package com.example.webServicesapp4requestBody;

// USing Address class in another class(customer) with has-a relation
public class Address {
	private String houseNo;
	private String streetName;
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
}

