package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="bmi")
public class Bmi implements Serializable {
    @Id
    private int id;

    @Column(name ="bmi",nullable = true)
    private double bmi;
}
