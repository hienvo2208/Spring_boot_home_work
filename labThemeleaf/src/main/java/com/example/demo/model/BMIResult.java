package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true,setterPrefix = "with")
public class BMIResult {
    private float bmiIndex;
    private String category;
    private String recommendation;

}
