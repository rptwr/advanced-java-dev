package com.in28minutes.springapp1.game;

public class GameRunner {
//	MarioGame game;
//	
//	public GameRunner(MarioGame game) {
//		this.game = game;
//	}

//	private SuperContraGame game;
//	
//	public GameRunner(SuperContraGame game) {
//		this.game = game;
//	}
	
	private GamingConsole game;
	
	public GameRunner(GamingConsole game) {
		this.game = game;
	}

	public void run() {
		System.out.println("Running game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}


// GameRunner is tightly coupled with marioGame 
// We are able to run SuperContra game but the problem we are having is that 
// our GameRunner class is tightly coupled with Specific game

// if i have to go back to the MarioGame then again i need to make
// GameRunner use the MarioGame

// We understood that our GameRunner class is tightly coupled to specific 
// game if i want to change from one game to another i need to make change to 
// the GameRunner class.
