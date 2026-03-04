package com.aranna.learn_spring_framwork;

import org.springframework.stereotype.Component;

@Component
public class SuperContraGame implements Game {
    @Override
    public void up() {
        System.out.println("SuperContraGame jump");
    }
    @Override
    public void down(){
        System.out.println("SuperContraGame down into a hole");
    }
    @Override
    public void left(){
        System.out.println("SuperContraGame stop");
    }
    @Override
    public void right(){
        System.out.println("SuperContraGame accelerate");
    }
}
