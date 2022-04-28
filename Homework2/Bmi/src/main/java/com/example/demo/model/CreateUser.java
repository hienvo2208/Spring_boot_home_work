package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUser {
    @JsonProperty("name")
    private String name;

    @JsonProperty("weight")
    private double weight;

    @JsonProperty("height")
    private double height;
}
