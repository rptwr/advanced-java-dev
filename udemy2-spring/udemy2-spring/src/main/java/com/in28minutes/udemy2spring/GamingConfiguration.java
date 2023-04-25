package com.in28minutes.udemy2spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import game.GameRunner;
import game.GamingConsole;
import game.MarioGame;
import game.PacmanGame;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game() {
		var game = new MarioGame();
		return game;
	}
	
	// we are creating a MarioGame and wiring it into gameRunner
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}

}
