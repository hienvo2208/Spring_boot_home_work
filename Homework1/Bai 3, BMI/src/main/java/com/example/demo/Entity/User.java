package com.example.demo.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="name")
    private String name;

    @Column(name ="weight")
    private double weight;

    @Column(name="height")
    private double height;

    @Column(name ="bmi")
    private double bmi;
}
