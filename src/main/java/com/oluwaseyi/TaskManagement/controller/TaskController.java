package com.oluwaseyi.TaskManagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.oluwaseyi.TaskManagement.model.Task.Task;
import com.oluwaseyi.TaskManagement.model.User;
import com.oluwaseyi.TaskManagement.repository.TaskRepository.TaskRepository;
import com.oluwaseyi.TaskManagement.repository.UserRepository;
import com.oluwaseyi.TaskManagement.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @GetMapping
    public List<Task> getAllTasks(@AuthenticationPrincipal UserDetails currentUser) {
        User user = UserRepository.findByUsername(currentUser.getUsername());
        return taskRepository.findByUserId(user.getId());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<?> getTaskById(@AuthenticationPrincipal UserDetails currentUser, @PathVariable Long taskId) {
        User user = UserRepository.findByUsername(currentUser.getUsername());
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isPresent() && task.get().getUser().getId().equals(user.getId())) {
            return ResponseEntity.ok(task.get());
        }
        return ResponseEntity.status(403).body("Forbidden");
    }

    @PostMapping
    public Task createTask(@AuthenticationPrincipal UserDetails currentUser, @RequestBody Task task) {
        User user = UserRepository.findByUsername(currentUser.getUsername());
        task.setUser(user);
        return taskRepository.save(task);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<?> updateTask(@AuthenticationPrincipal UserDetails currentUser, @PathVariable Long taskId, @RequestBody Task updatedTask) {
        User user = UserRepository.findByUsername(currentUser.getUsername());
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isPresent() && task.get().getUser().getId().equals(user.getId())) {
            task.get().setTitle(updatedTask.getTitle());
            task.get().setDescription(updatedTask.getDescription());
            task.get().setDueDate(updatedTask.getDueDate());
            task.get().setCompleted(updatedTask.isCompleted());
            return ResponseEntity.ok(taskRepository.save(task.get()));
        }
        return ResponseEntity.status(403).body("Forbidden");
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@AuthenticationPrincipal UserDetails currentUser, @PathVariable Long taskId) {
        User user = UserRepository.findByUsername(currentUser.getUsername());
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isPresent() && task.get().getUser().getId().equals(user.getId())) {
            taskRepository.delete(task.get());
            return ResponseEntity.ok().body("Task deleted");
        }
        return ResponseEntity.status(403).body("Forbidden");
    }
}
