package com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.model.Todo;

@RestController 
@RequestMapping("/todo")
public class TodoController {

    public final static List<Todo> TODO_LIST=List.of(
            new Todo("user","AWS"),
            new Todo("user","Java")
        );

    @GetMapping("/get/all")
    public List<Todo> getTodos(){
        return TODO_LIST;
    }


    @GetMapping("/user/{userName}/todos")
    public Todo getUserTodos(@PathVariable("userName") String userName){
        System.out.println(userName);
        return TODO_LIST.get(0);
    }

}


