package com.pavan.taskTracker.service;

import com.pavan.taskTracker.model.Task;
import com.pavan.taskTracker.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepo repo;

    public List<Task> getAllTasks() {
        System.out.println(repo.findAll());
        return  repo.findAll();
    }

    public Task addTask(Task task) {
        return repo.save(task);
    }

    public Task getTaskById(int id) {
        return repo.findById(id).get();
    }

    public Task updateTask(Task task) {
        return repo.save(task);
    }

    public void deleteTask(int id) {
        repo.deleteById(id);
        return;
    }

    public List<Task> getTaskBydate(String date) {
        return repo.findByDate(date);
    }
}
