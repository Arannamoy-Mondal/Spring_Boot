package com.aranna.java24_junit_for_unit_testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.never;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class MyMathTest {

    @Test
    public void test(){
        MyMath myMath=new MyMath();
        int [] numbers={1,2,3,4,5};
        int ans=myMath.calculateSum(numbers);
        int expected_result=15;
        assertEquals(expected_result,ans);
        System.out.println(ans);
    }


    @Test
    public void test2(){
        MyMath myMath=new MyMath();
        int [] numbers={4,5,6,4};
        assertEquals(10, myMath.calculateSum(numbers));
        fail("Okay");
    }

    @Test
    public void test3(){
        List<String> clouds=List.of("AWS","Azure","GCP");
        assertEquals(true, clouds.contains("Azure"));
    }
}
