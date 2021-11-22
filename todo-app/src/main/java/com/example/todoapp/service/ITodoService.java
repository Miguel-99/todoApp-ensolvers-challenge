package com.example.todoapp.service;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.model.Todo;

import java.util.List;

public interface ITodoService {
    List<Todo> getAll();
    Todo getOne(Long id);
    Todo createTodo(TodoDto todo);
    Todo updateTodo(Long id, Todo dto);
    void deleteTodo(Long id);
}
