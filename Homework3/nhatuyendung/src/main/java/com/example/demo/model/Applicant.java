package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Applicant {
    private String name;
    private String dob;
    private String skill;
    private int experience;

}
