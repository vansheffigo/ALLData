package com.Spring.littlebitofspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.Spring.littlebitofspring.game.GameRunner;
import com.Spring.littlebitofspring.game.GamingConsole;
import com.Spring.littlebitofspring.game.MarioGame;
import com.Spring.littlebitofspring.game.SuperContraGame;

@SpringBootApplication
public class LittlebitofspringApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context=	SpringApplication.run(LittlebitofspringApplication.class, args);
//		MarioGame game = new MarioGame();
//		GameRunner runner= new GameRunner(game);
//		SuperContraGame game =new SuperContraGame(); 
//		GameRunner runner = new GameRunner(game);
		GameRunner runner =context.getBean(GameRunner.class);
		runner.run();
	}

}
