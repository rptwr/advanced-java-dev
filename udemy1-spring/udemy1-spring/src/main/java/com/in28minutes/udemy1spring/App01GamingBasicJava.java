package com.in28minutes.udemy1spring;


import game.GameRunner;
import game.MarioGame;
import game.PacmanGame;
import game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		
		// IOC - inversion of control
		// programmer is explicitly writing code to create objects and 
		// wire the dependecies
//		var game = new MarioGame();
//		var game = new SuperContraGame();
		
		var game = new PacmanGame(); //1: Object Creation
		
		var gameRunner = new GameRunner(game); 
			//2: Object Creation + Wiring of Dependencies
			// Game is a Dependency of GameRunner
		
		gameRunner.run();

	}

}
