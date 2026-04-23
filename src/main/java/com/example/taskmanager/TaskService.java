package com.example.taskmanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
    return repository.findByDeletedFalse(); 
    }

    public Task createTask(Task task) {
    task.setDeleted(false); // Force it to be active
    // Log the action (Innovation 1)
    AuditService.logActivity("Creating task: " + task.getTitle());
    // Save the object that was sent from Postman
    return repository.save(task); 
    }
    public Task updateTask(Long id, Task taskDetails) {
    return repository.findById(id)
        .map(task -> {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setCompleted(taskDetails.isCompleted());
            return repository.save(task);
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found with id: " + id));
    }

    public void deleteTask(Long id) {
    Task task = repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
     task.setDeleted(true);
     repository.save(task);
    }
    
    public Map<String, Long> getTaskStats() {
    List<Task> allTasks = repository.findAll();
    Map<String, Long> stats = new HashMap<>();
    stats.put("total", (long) allTasks.size());
    stats.put("completed", allTasks.stream().filter(Task::isCompleted).count());
    stats.put("pending", allTasks.stream().filter(t -> !t.isCompleted()).count());
    return stats;
   }
}