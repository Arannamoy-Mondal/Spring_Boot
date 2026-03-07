package com.aranna.java18_spring_security.resources;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Log4j2              
public class TodoResources {
    public static final List<Todo> todos = List.of(new Todo("AWS", "Learn AWS"),
            new Todo("Java", "Learn Java"));

    @GetMapping("/todo")
    public List<Todo> retrieveAllTodos() {

        return todos;
    }

    @GetMapping("/users/{userName}/todo")
    public Todo getTodoForASpecificUser(@PathVariable("userName") String userName) {
        return todos.get(0);
    }

    @PostMapping("/users/todo/{userName}")
    public Todo createTodoForSpecificUser(
        @PathVariable("userName") String userName
    // ,
            // @RequestBody Todo todo
        ) {
            System.out.println(1);
        return todos.get(0); 
    }

}

record Todo(String userName, String description) {
}
