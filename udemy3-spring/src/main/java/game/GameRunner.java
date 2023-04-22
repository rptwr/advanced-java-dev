package game;

// 003 Step 02 - Exploring Primary and Qualifier Annotations for Spring Components

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
//	private GamingConsole game;
//	// constructor
//	public GameRunner(GamingConsole game) {
//		this.game = game;
//	}
	private GamingConsole game;
	// we are directly specifying a specific bean we are saying this is the qualifier 
	// which need to be autowired in
	public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
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

/*
This game runner will automatically scanned and picked up

by adding @Component here we are able to reduce code App03GamingSpringBeans

 instead of manually creating GameRunner and App03GamingSpringBeans we wre now 
 having spring framework create them for us.
 
 Based on @Component and @ComponentScan spring is able to scan the right packages
 find the components and find the instances autowire them for us and get the entire 
 application up and running.
 */