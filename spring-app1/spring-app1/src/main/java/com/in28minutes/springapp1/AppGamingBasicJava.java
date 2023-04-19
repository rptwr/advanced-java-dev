package com.in28minutes.springapp1;

import com.in28minutes.springapp1.game.GameRunner;
import com.in28minutes.springapp1.game.MarioGame;
import com.in28minutes.springapp1.game.PacmanGame;
import com.in28minutes.springapp1.game.SuperContraGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {

//		 var game = new MarioGame();
//		 var game = new SuperContraGame();

		var game = new PacmanGame(); // 1: Object Creation

		var gameRunner = new GameRunner(game);
//		// 2: Object Creation + Wiring of Dependencies
//		// Game is a Dependency of GameRunner
//
		gameRunner.run();

	}

}

// Here we will create GameRunner class instance
