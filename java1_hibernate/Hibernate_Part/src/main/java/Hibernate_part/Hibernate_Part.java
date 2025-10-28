/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Hibernate_part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author algo-3
 */
public class Hibernate_Part {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Student std1 = new Student();
        std1.setName("User");
        std1.setAge(22);
        std1.setRollNo(1);
        System.out.println(std1);
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(std1);
        transaction.commit();
        sf.close();
        System.out.println(std1);
    }
}
