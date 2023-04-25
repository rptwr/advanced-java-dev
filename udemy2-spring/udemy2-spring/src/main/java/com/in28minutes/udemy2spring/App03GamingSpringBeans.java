package com.in28minutes.udemy2spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import game.GameRunner;
import game.GamingConsole;


public class App03GamingSpringBeans {

	public static void main(String[] args) {
		
		// try with resources
		try (var context = 
				new AnnotationConfigApplicationContext
					(GamingConfiguration.class)) {

			context.getBean(GamingConsole.class).up();
			
//			context.getBean(GameRunner.class).run();

		}
	}
}

// 016 Step 15 - Using Spring Framework to Manage Beans for Java Gaming App