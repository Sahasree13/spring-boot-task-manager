package com.example.taskmanager;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity // 1. Tells Spring to create a table named 'Task' in the DB
@Data   // 2. Automatically creates your getters, setters, and toString
public class Task {

    @Id // 3. Marks this as the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Auto-increments IDs (1, 2, 3...)
    private Long id;
    
    @NotBlank(message = "Title is mandatory")
    private String title;
    private String description;
    private boolean completed;

    @JsonIgnore // This hides it from the Postman response
    private boolean deleted = false;
}