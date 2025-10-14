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

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        try {
            Student std1 = new Student();
        std1.setRoll(4);
        std1.setName("User Four");
        std1.setAge(23);
        Laptop laptop1=new Laptop();
        laptop1.setBrand("Lenovo");
        laptop1.setModel("LOQ 13");
        laptop1.setRam(16);
        laptop1.setId(01);
        std1.setLaptop(laptop1);
        Configuration configuration = new Configuration().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class).configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(std1); /* create */
        session.persist(laptop1);
        // session.merge(std1); /*update */
        Student std2=session.get(Student.class,2); /*read */
        // session.remove(std2); /* delete */
        transaction.commit();
        
        System.out.println(std2);
        session.close();

        sessionFactory.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
