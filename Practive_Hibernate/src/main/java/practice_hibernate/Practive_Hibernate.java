/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package practice_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author algo-3
 */
public class Practive_Hibernate {

    public static void main(String[] args) {
        Student std1 = new Student();
        std1.setRoll(4);
        std1.setName("User Four");
        std1.setAge(23);
        Laptop laptop1=new Laptop();
        laptop1.setBrand("Lenovo");
        laptop1.setModel("LOQ 13");
        laptop1.setRam(16);
        std1.setLaptop(laptop1);
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Student.class);
        configuration.configure();
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(std1); /* create */
        // session.merge(std1); /*update */
        Student std2=session.get(Student.class,2); /*read */
        // session.remove(std2); /* delete */
        transaction.commit();
        
        System.out.println(std2);
        session.close();

        sf.close();
    }
}
