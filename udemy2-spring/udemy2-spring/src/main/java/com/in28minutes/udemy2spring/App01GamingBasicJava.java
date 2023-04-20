package com.in28minutes.udemy2spring;

// 009 Step 08 - Your First Java Spring Bean and Launching Java Spring Configuration
// 010 Step 09 - Creating More Java Spring Beans in Spring Java Configuration File

import game.GameRunner;
import game.MarioGame;
import game.PacmanGame;
import game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		
//		var game = new MarioGame();
//		var game = new SuperContraGame();
		
		var game = new PacmanGame(); //1: Object Creation
		
		var gameRunner = new GameRunner(game); 
			//2: Object Creation + Wiring of Dependencies
			// Game is a Dependency of GameRunner
		
		gameRunner.run();

	}

}
