package com.example.mycrud.controller;

import com.example.mycrud.exception.ResourceNotFoundException;
import com.example.mycrud.model.Todo;
import com.example.mycrud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/devices")
public class TodoController{
    @Autowired
    private TodoRepository todoRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Todo>getTodo() {
        return todoRepository.findAll();
    }

    @PostMapping("{create}")
    public Todo createTodo(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }


//    @GetMapping("stat/{id}")
//    public ResponseEntity<Todo> getEmployeeById(@PathVariable  long id){
//        Todo todo = todoRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Device not exist with id:" + id));
//        //todo.getIdleStatus();
//        //return ResponseEntity.ok(todo.getIdleStatus());
//        return ();
//    }

    @GetMapping("/status")
    public String getDeviceStatus(){
       String sampleData = "112130";

       /*List dataResponse = todoRepository.findAll();
        for (Object data:
             dataResponse) {
            System.out.println(data.toString());
        }
        return(dataResponse[0].toString());*

        */
        return(sampleData.toString());
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable long id,@RequestBody Todo todoDetails) {
        Todo updateTodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device with id: " + id + " does not exist."));

                updateTodo.setStatus(todoDetails.getStatus());
                updateTodo.setRelayName(todoDetails.getRelayName());
                updateTodo.setType(todoDetails.getType());
                updateTodo.setScheduleOn(todoDetails.getScheduleOn());
                updateTodo.setScheduleOff(todoDetails.getScheduleOff());
                updateTodo.setIdleStatus(todoDetails.getIdleStatus());

        todoRepository.save(updateTodo);

        return ResponseEntity.ok(updateTodo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteTodo(@PathVariable long id){

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not exist with id: " + id));

        todoRepository.delete(todo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
