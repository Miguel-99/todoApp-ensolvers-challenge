package com.example.todoapp.dto;

import com.example.todoapp.model.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class TodoDto {
    private String description;

    public static Todo dtoToModel(TodoDto dto) {
        return Todo.builder().description(dto.getDescription()).completed(Boolean.FALSE).build();
    }
}
