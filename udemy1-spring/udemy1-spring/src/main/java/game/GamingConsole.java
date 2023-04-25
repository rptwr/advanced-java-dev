package game;

public interface GamingConsole {
	void up();
	void down();
	void left();
	void right();
}


/*
 Loose coupling through interface
 Once you create an interface and make your game classes implement
 that interface we can make use of the interface from the game runner class
 
 and therefore now GameRunner class is disconnected or lossely coupled to 
 specific implementation
 
 
 */