package com.in28minutes.udemy2spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {

		//1: Launch a Spring Context
		try(var context = 
				new AnnotationConfigApplicationContext
						(HelloWorldConfiguration.class)) {
			
			//2: Configure the things that we want Spring to manage - 
			//HelloWorldConfiguration class - @Configuration
			// inside @Configuration we created a name method with @Bean annotation 
			//name - @Bean
			
			//3: Retrieving Beans managed by Spring
			System.out.println(context.getBean("name"));
			// spring is managing name bean for us
			// spring managing custom objects
			
			System.out.println(context.getBean("age"));
			
			// spring managing custom class
			System.out.println(context.getBean("person"));
			
			System.out.println(context.getBean("person2MethodCall"));
			
			System.out.println(context.getBean("person3Parameters"));
			
			System.out.println(context.getBean("address2"));
			
//			System.out.println(context.getBean(Person.class));
			
			System.out.println(context.getBean(Address.class));
			
//			System.out.println(context.getBean("person5Qualifier"));
			
			
			//System.out.println
//			Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);
			
		}
		
		
		
		
	}

}
