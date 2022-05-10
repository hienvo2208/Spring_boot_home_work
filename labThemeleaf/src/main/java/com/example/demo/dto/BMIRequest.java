package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BMIRequest {
    @NotEmpty(message ="{empty.name}")
    private String name;
    @Email
    @NotEmpty
    private String email;
    @Positive
    private float height;
    @Positive
    private float weight;
}
