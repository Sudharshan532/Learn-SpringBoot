package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacMan implements GamingConsole{
	
	public void up() {
		System.out.println("PacMan: Up");
	}
	
	public void down() {
		System.out.println("PacMan: Down");
	}
	
	public void left() {
		System.out.println("PacMan: Left");
	}
	
	public void right() {
		System.out.println("PacMan: Right");
	}

}
