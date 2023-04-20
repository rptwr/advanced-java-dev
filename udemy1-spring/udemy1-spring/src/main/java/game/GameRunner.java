package game;

//PacmanGame
public class GameRunner {
	
	// create instance of MarioGame
//	private MarioGame game;
//	// constructor
//	public GameRunner(MarioGame game) {
//		this.game = game;
//	}    // MarioGAme is tightly coupled

	// create instance of SuperContraGame
//	private SuperContraGame game;
//	// constructor
//	public GameRunner(SuperContraGame game) {
//		this.game = game;
//	}
	
	private GamingConsole game;
	// constructor
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

// Game Runner class is tightly coupled to specific class

/*
 Earlier the GameRunner class was tightly couple to a specific game 
 if i would want to change the game i need to change the GameRunnerClass
 code.
 However now by bringing in a gaming console interface the GameRunner 
 class is disconnected from the specific game. The GameRunner class is 
 no longer coupled to a specific game it is only coupled with specific interface 
 and therefore the game you are playing can be changed without changing the GameRunner class
 
 
 
 
 */