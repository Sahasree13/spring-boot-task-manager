package com.example.taskmanager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTitleContaining(String keyword);
    List<Task> findByCompleted(boolean status);
    List<Task> findByDeletedFalse();
}