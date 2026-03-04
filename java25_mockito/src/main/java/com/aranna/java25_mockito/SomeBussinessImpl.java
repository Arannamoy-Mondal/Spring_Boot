package com.aranna.java25_mockito;

public class SomeBussinessImpl {
    private DataService dataService;
    public SomeBussinessImpl(DataService dataService) {
        this.dataService = dataService;
    }
    public int findTheGreatestFromAllData(){
        int[] data=dataService.retrieveAllData();
        int greatestValue=Integer.MIN_VALUE;
        for(int value:data){
            if (value>greatestValue) {
                greatestValue=value;
            }
        }
        return greatestValue;
    }
}


interface DataService {

    int[] retrieveAllData();
}