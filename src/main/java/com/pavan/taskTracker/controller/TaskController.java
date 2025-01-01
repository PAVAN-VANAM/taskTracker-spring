package com.pavan.taskTracker.controller;

import com.pavan.taskTracker.model.Task;
import com.pavan.taskTracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskService service;

    @RequestMapping("/")
    public String greet(){
        return "Hello World!!";
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return service.getAllTasks();
    }

    @PostMapping("/tasks")
    public ResponseEntity<?> addTasks(@RequestBody Task task){
        Task task1 = service.addTask(task);
        if(task1!=null){
            return new ResponseEntity<>(task1,HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("Failed" , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/tasks/data")
    public ResponseEntity<?> getTaskByDate(@RequestParam String date){
        try{
            List<Task> tasks = service.getTaskBydate(date);
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable int id){
        try{
            Task task = service.getTaskById(id);
            return ResponseEntity.ok(task);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/tasks")
    public ResponseEntity<String> updateTask(@RequestBody Task task){
        Task task1 = service.updateTask(task);
        if(task1!=null){
            return ResponseEntity.ok("Successfully updated");
        }else{
            return new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id){
        try {
            Task task = service.getTaskById(id);
                service.deleteTask(id);
            return ResponseEntity.ok("Successfully Deleted");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
