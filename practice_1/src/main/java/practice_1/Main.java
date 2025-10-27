package practice_1;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setCpu("Ryzen 5 5625U");
        l1.setRam(16);
        l1.setSsd("512 Gb");
        l1.setId(1);
        Student std1 = new Student();
        std1.setName("User One");
        std1.setAge(23);
        std1.setLaptop(Arrays.asList(l1));
        Configuration cfg = new Configuration().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class)
                .configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        // session.persist(l1);
        // session.merge(l1);
        // session.persist(std1);
        session.merge(std1);
        Laptop result=session.find(Laptop.class,2);
        System.out.println("Result: "+result);
        transaction.commit();
        sf.close();
    }
}