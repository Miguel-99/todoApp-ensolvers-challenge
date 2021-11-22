package com.example.todoapp.controller;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.model.Todo;
import com.example.todoapp.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/todos")
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @GetMapping
    ResponseEntity<?> getAllTodos() {
        return ResponseEntity.ok(todoService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getOneTodo(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getOne(id));
    }

    @PostMapping
    ResponseEntity<?> createTodo(@RequestBody TodoDto todo) {
        return ResponseEntity.ok(todoService.createTodo(todo));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody Todo dto) {
        Todo updateTodo = todoService.updateTodo(id, dto);
        return ResponseEntity.ok(updateTodo);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }
}
