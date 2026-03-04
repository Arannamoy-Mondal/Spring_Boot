package com.aranna.learn_spring_framwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearnSpringFramworkApplication {

	public static void main(String[] args) {
		ApplicationContext context=
		SpringApplication.run(LearnSpringFramworkApplication.class, args);
			MarioGame marioGame=context.getBean(MarioGame.class);
			SuperContraGame superContraGame=context.getBean(SuperContraGame.class);
			Pacman pacman=context.getBean(Pacman.class);
			GameRunner runner=context.getBean(GameRunner.class);
			MyWebController myWebController=context.getBean(MyWebController.class);
			System.out.println(myWebController.returnValueFromBussinessService());
			runner.run(marioGame);
			runner.run(superContraGame);
			runner.run(pacman);

	}

}
