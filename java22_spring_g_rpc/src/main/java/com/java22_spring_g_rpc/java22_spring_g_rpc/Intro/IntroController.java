package com.java22_spring_g_rpc.java22_spring_g_rpc.Intro;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.java22_spring_g_rpc.Address;
import com.java22_spring_g_rpc.BodyStyle;
import com.java22_spring_g_rpc.Book;
import com.java22_spring_g_rpc.Car;
import com.java22_spring_g_rpc.CarDealer;
import com.java22_spring_g_rpc.Credentials;
import com.java22_spring_g_rpc.LastUpdated;
import com.java22_spring_g_rpc.Library;
import com.java22_spring_g_rpc.Phone;
import com.java22_spring_g_rpc.School;
import com.java22_spring_g_rpc.Student;

public class IntroController {
    public static final Logger LOGGER=LoggerFactory.getLogger(IntroController.class);
    public static void main(String[] args) {
       var address=Address.newBuilder()
       .setStreet("Times Square")
       .setCity("New York")
        .setState("New York");
        var student=Student.newBuilder().setAddress(address)
        .setName("Hello")
        .build();
       var school=School.newBuilder()
       .setId(1)
       .setAddress(address
    ).setName("NASDAQ")
       .build();


       var book1=Book.newBuilder()
       .setTitle("harry potter -part 1")
       .setAuthor("j k rowling")
       .setPublicationYear(1997)
       .build();

       var book2=book1.toBuilder()
       .setTitle("harry potter - part 2")
       .setPublicationYear(1998)
       .build();


       var library1=Library.newBuilder()
       .addAllBooks(List.of(book1,book2))
       .build();

       var library2=library1.toBuilder().addAllBooks(Set.of(book1,book2));

       var car1=Car.newBuilder()
       .setVendor("Honda")
       .setModel("Civic")
       .setYear(2016)
       .setBodyStyle(BodyStyle.SEDAN)
       .build();
       var car2=car1.toBuilder()
       .setModel("CR-V")
       .setYear(2026)
       .setBodyStyle(BodyStyle.SUV)
       .build();

       var carDealer1=CarDealer.newBuilder()
       .putInventory(car1.getYear(),car1)
       .putInventory(car2.getYear(), car2)
       .build();

       var credentials_=Credentials.newBuilder()
       .setPhone(Phone.newBuilder().setCode(1234).setNumber(1234567).build()).build();

   
    LOGGER.info(student.toString());
    LOGGER.info(address.toString());
    LOGGER.info(school.toString());
    LOGGER.info(book1.toString());
    LOGGER.info(book2.toString());
    LOGGER.info(library1.toString());
    System.out.println(library1.getBooksList());
    System.out.println(library2);
    System.out.println(car1);
    System.out.println(car2);
    System.out.println("Car dealer: "+carDealer1);
    login(credentials_);
   
    }

    public static void login(Credentials credentials){
      switch (credentials.getCredentialCase()) {
         case EMAIL:
            System.out.println(credentials.getEmail());
            break;
         case PHONE:
            System.out.println(credentials.getPhone());
            break;
         default:
            break;
      }
    }
}
