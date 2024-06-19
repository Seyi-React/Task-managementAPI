package com.oluwaseyi.TaskManagement.repository.TaskRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oluwaseyi.TaskManagement.model.Task.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
}

