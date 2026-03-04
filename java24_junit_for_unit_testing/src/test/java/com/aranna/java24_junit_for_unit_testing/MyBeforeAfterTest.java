package com.aranna.java24_junit_for_unit_testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyBeforeAfterTest {

    @BeforeEach
    void beforeEach(){
        System.out.println("beforeEach");
    }

    @Test
    public void test1(){
        System.out.println("Test1");
    }


    @Test
    public void test2(){
        System.out.println("Test2");
    }


    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }
}
