package com.pavan.taskTracker.repository;

import com.pavan.taskTracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
    List<Task> findByDate(String date);
}
