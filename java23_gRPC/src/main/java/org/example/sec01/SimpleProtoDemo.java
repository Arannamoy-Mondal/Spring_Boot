package org.example.sec01;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {
    private static  final Logger LOGGER= LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(String[] args) {
        Person p1=Person.newBuilder().setAge(22).setName("hello").build();
        LOGGER.info("p1:"+p1);
    }
}
