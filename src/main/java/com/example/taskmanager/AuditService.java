package com.example.taskmanager;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AuditService {
    @Async
    public static void logActivity(String activity) {
        // Imagine this sends an email or logs to a cloud service
        System.out.println("Async Audit Log: " + activity + " at " + LocalDateTime.now());
    }
}
