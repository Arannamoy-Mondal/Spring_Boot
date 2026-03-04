package com.aranna.learn_spring_framwork;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public interface Game {
    public void up();
    public void down();
    public void left();
    public void right();
}
