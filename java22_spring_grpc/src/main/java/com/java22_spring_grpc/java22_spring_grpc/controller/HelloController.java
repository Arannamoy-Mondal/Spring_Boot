package com.java22_spring_grpc.java22_spring_grpc.controller;
import com.java22_spring_grpc.Hello;
public class HelloController {
    public static void main(String[] args) {
        Hello hello=Hello.newBuilder().setId("111").build();
        System.out.println(hello);
    }
}
