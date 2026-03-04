package com.aranna.learn_spring_framwork;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    public GameRunner() {
       
    }

    public void run(Game game) {
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
