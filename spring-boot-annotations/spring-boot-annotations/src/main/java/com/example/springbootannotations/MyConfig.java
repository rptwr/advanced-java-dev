package com.example.springbootannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyConfig {
	
	@Bean
	public Student getStudent() {
		System.out.println("Creating student object");
		return new Student();
	}
	
	@Bean
	public Date getDate() {
		System.out.println("Creating new Date");
		return new Date();
	}
	
}




/*
 
 
 
 inside @Configuration class we can develop method which can return java bean 
 we have not to manage their object 
 Their object will be managed by spring itself
 
 getStudent() method returning object of student then Configuration class 
 is marking that return object is as a bean.
 Which means this object(Student) which is return by  getStudent() method 
 managed by spring container or spring. For that we have to use @Bean annotations.
 This @Bean annotations is telling that bean is returning from there
 NOw this Student object we dont need to create anywhere directly we can autowire because it
  is returning bean 
 
 =============================
 @Configuration means any class we can declare as configuration class
 it means inside that class there will be method which will return spring bean or java beans 
 or object is returning from there .
 
 returning bean object will be managed by spring container. Automatic injection will be possible
 from there 
 
 ==============================
 3) @Bean -- we use @Bean annotations inside @Configuration class to show that bean method is retruning
 bean  which will be managed by spring container 
 
 where ever we inject Date method then this method will inject
 for that we dont have to create object spring will automatically do that
 
 ===========================================
 
 
 
 */