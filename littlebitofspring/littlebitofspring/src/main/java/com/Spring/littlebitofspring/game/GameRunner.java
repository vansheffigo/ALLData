package com.Spring.littlebitofspring.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.Spring.littlebitofspring")
public class GameRunner {
//	private MarioGame game ;
//	private SuperContraGame game;
//	public GameRunner(MarioGame game) {
//	
//		this.game=game;
//		
//	}
	@Autowired
	GamingConsole game ;
    public GameRunner(GamingConsole game)
    {
    	this.game =game;
    }
	public void run() {
		// TODO Auto-generated method stub
		game.up();
		game.down();
		game.left();
		game.right();
	}

}
