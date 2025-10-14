package com.hibernate.hibernate_concept;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HibernateConceptApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateConceptApplication.class, args);
		Student std1=new Student();
		std1.setsName("User");
		std1.setRollNo(24);
		std1.setsAge(22);
		std1.console_print();
		Configuration cfg=new Configuration();
		cfg.addAnnotatedClass(Student.class);
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(std1);
		transaction.commit();
		sf.close();
		System.out.println(std1);

	}

}
