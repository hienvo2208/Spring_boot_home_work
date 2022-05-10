package com.example.demo.service;

import com.example.demo.dto.BMIRequest;
import com.example.demo.model.BMIResult;
import org.springframework.stereotype.Service;

@Service
public interface BMIService {
     public BMIResult calculateBMI(BMIRequest bmiParams);
}
