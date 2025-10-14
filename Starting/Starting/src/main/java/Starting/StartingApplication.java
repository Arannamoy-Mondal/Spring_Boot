package Starting;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class StartingApplication {

	public static void main(String[] args) {
		
		ApplicationContext context=SpringApplication.run(StartingApplication.class, args);

		ToDo todo1=context.getBean(ToDo.class);
		todo1.details();
		Student s1=new Student();
        s1.setsName("Aranna");
        s1.setRollNo(101);
        s1.setsAge(22);
        System.out.println(s1);
        System.out.println("Hello");
		Configuration cfg=new Configuration();
		cfg.addAnnotatedClass(Starting.Student.class);
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=new Session();
	}

}
