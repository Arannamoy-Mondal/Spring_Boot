package Starting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class StartingApplication {

	public static void main(String[] args) {
		
		ApplicationContext context=SpringApplication.run(StartingApplication.class, args);

		ToDo todo1=context.getBean(Todo.class);
		todo1.details();
	}

}
