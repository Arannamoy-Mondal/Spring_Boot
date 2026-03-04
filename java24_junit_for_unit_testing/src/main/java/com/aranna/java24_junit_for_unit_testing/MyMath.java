package com.aranna.java24_junit_for_unit_testing;

public class MyMath {
    public int calculateSum(int[] numbers){
        int sum=0;
        for(int i:numbers){
            sum+=i;
        }
        return sum;
    }
}
