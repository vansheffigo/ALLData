package com.Spring.littlebitofspring.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole {

	public void up() {
		System.out.println("up");
	}

	public void down() {
		System.out.println("down into a hole");
	}

	public void left() {
		System.out.println("left");
	}

	public void right() {
		System.out.println("accelerate");
	}
}
