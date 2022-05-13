package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobRequest {
    @NotEmpty(message = "{empty.name}")
    private String name;
    @NotEmpty
    private String employer;
    @Positive
    private double salary;
}
