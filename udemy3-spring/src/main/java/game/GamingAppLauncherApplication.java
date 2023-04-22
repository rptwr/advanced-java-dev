package game;

//001 Step 01 - Getting Spring Framework to Create and Manage Your Java Objects

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// programmer is only defining @ComponentScan and other annotations in different class
// the actual work of creating the objects wiring them together is done by spring framework 

@Configuration
@ComponentScan("package game")
public class GamingAppLauncherApplication {

	
//	@Bean
//	public GameRunner gameRunner(GamingConsole game) {
//		// instance of PackMangame is created and its wired in here
//		System.out.println("Parameter: " + game);  // Parameter: game.PacmanGame@7975d1d8 
//		var gameRunner = new GameRunner(game);
//		return gameRunner;
//	}

	public static void main(String[] args) {
		
		try (var context = 
				new AnnotationConfigApplicationContext
					(GamingAppLauncherApplication.class)) {

			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();

		}
	}
}

// we can ask the bean to create bean for us
// spring is not able to find packmanGame reason is we need to tell 
// spring where to search packmangame 

/*
 packmangame is create in different package we need to tell spring to search there 
 for that we need to add @ComponentScan over there we can configure the package
 
 we want spring to create beans for packmangame
 
 now spring has created the instance of packmangame and autowired in Gaming Console
 
 
 */