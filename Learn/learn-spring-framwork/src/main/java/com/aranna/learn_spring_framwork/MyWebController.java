package com.aranna.learn_spring_framwork;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyWebController {
    @Autowired
    private BussinessService bussinessService;
    public long returnValueFromBussinessService(){
        return bussinessService.calculateSum();
    }
}

@Component
class BussinessService {
    @Autowired
    private DataService dataService;
    @SuppressWarnings("null")
    public long calculateSum(){
        List<Integer> data= dataService.getData();
        return data.stream().reduce(Integer::sum).get(); 
    }   
    
}

@Component
class DataService{
    public List<Integer> getData(){
        return List.of(10,20,30,40,50);
    }
}
