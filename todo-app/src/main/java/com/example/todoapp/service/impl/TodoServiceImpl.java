package com.example.todoapp.service.impl;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;
import com.example.todoapp.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

@Service
public class TodoServiceImpl implements ITodoService {

    @Autowired
    private TodoRepository todoRepository;


    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getOne(Long id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        return todo;
    }

    @Override
    public Todo createTodo(TodoDto todoDto) {
        Todo todo = TodoDto.dtoToModel(todoDto);
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, Todo todo) {
        Todo updatedTodo = todoRepository.findById(id).orElse(null);
        updatedTodo.setDescription(todo.getDescription());
        updatedTodo.setCompleted(todo.getCompleted());
        return todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("entity doesnt exists"));
        todoRepository.delete(todo);
    }
}
