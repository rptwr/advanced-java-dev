package com.example.springbootannotations;

import org.springframework.stereotype.Component;

@Component
public class Emp {
	
	public void whatsYourName() {
		System.out.println("MY name is Ram");
	}
}





/*
 5) @Component 
 if we are using @Component on any class it become the component of spring 
 and which object is managed by spring container.
 Inside @Component there are some specific controller which are 
 5.1) @Controller 
 5.2) @Service
 5.3) @Repository
 -------------------------------
 @Controller is component (it will do the work of Component as well as MVC Controller)
 @Contoller is used for to make MVC layer on presentation layer
 --------------------
 @Service is used on business logic
 ------------------
 @Repository is used to provide DAO facility 
 -------------------------------------------------------
 
 SpringBoot will scan the package and it have to manage the object life
 cycle of this component then it will do the auto wiring after injection
 it create the object object before injecting
 
 THere are two methods to create object
 1) By declaring @Configuration to a class and returning a @Bean method
 by calling this method it will do the autowiring.
 2) By declaring @Component
 
 
 
 
 */