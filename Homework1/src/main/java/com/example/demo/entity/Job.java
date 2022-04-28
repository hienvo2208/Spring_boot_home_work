package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Job {
    private String id;
    private String title;
    private String description;
    private Location location;
    private int minSalary;
    private int maxSalary;
    private String emailTo;
}
