package com.example.springbootannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import myPack.Dog;

@SpringBootApplication
@ComponentScan(basePackages = {"myPack"})
public class SpringBootAnnotationsApplication implements CommandLineRunner{
	
	@Autowired
	private Student student;
	@Autowired
	private Date date;
	@Autowired
	private Emp emp;
	
	@Autowired
	private Dog dog;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAnnotationsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		this.student.studying();
		this.emp.whatsYourName();
		this.dog.eating();
	}
}


/*
  4) @Autowired simply means it will do auto wiring. It will inject dependecies 
  Spring container will check wheather we have Student component object 
 is available or not which is matching Student type  or not . If its matching 
 Student type object then it will inject Student object.
 
 @Autowired we can do that on property, constructor, setter 
 
 
 
 
 
 
 */