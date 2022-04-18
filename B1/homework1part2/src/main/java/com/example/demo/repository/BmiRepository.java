package com.example.demo.repository;

import com.example.demo.Entity.Bmi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BmiRepository extends JpaRepository<Bmi,Integer> {
}
