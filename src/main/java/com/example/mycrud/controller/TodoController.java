package com.example.mycrud.controller;

import com.example.mycrud.exception.ResourceNotFoundException;
import com.example.mycrud.model.Todo;
import com.example.mycrud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todos")
public class TodoController{
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public List<Todo>getTodo() {
        return todoRepository.findAll();
    }

    @PostMapping("{create}")
    public Todo createTodo(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> getEmployeeById(@PathVariable  long id){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not exist with id:" + id));
        return ResponseEntity.ok(todo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable long id,@RequestBody Todo todoDetails) {
        Todo updateTodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not exist with id: " + id));

        updateTodo.setUsername(todoDetails.getUsername());
        updateTodo.setDescription(todoDetails.getDescription());
        updateTodo.setTargetDate(todoDetails.getTargetDate());
        todoRepository.save(updateTodo);

        return ResponseEntity.ok(updateTodo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteTodo(@PathVariable long id){

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not exist with id: " + id));

        todoRepository.delete(todo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
