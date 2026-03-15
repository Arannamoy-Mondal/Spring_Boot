package com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.model.Todo;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    public static final List<Todo> TODO_LIST = List.of(
            new Todo("user", "AWS"),
            new Todo("user", "Java"));

    @GetMapping("/get/all")
    public List<Todo> getTodos() {
        return TODO_LIST;
    }

    @GetMapping("/user/{userName}/todos")
    public Todo getUserTodos(@PathVariable("userName") String userName) {
        System.out.println(userName);
        return TODO_LIST.get(0);
    }

    @PostMapping("/user/{userName}/todo")
    public List<Todo> getUserTodo(@PathVariable("userName") String userName, @RequestBody Todo entity) {
        try {
            TODO_LIST.add(entity);
            log.info(entity);
            return TODO_LIST;
        } catch (Exception e) {
            // TODO: handle exception
            log.info("error: "+" "+e);
            return List.of();
        }

    }

}
