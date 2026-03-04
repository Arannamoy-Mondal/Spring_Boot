package com.aranna.learn_spring_framwork;

import org.springframework.stereotype.Component;

@Component
public class Pacman implements Game{

   @Override
    public void up() {
        System.out.println("Pacman jump");
    }
    @Override
    public void down(){
        System.out.println("Pacman down into a hole");
    }

    @Override
    public void left(){
        System.out.println("Pacman stop");
    }
    @Override
    public void right(){
        System.out.println("Pacman accelerate");
    }
}
