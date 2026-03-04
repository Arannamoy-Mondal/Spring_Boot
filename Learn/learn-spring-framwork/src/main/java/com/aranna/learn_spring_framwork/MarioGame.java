package com.aranna.learn_spring_framwork;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements Game {
    @Override
    public void up() {
        System.out.println("MarioGame jump");
    }
    @Override
    public void down(){
        System.out.println("MarioGame down into a hole");
    }

    @Override
    public void left(){
        System.out.println("MarioGame stop");
    }
    @Override
    public void right(){
        System.out.println("MarioGame accelerate");
    }
    
}
