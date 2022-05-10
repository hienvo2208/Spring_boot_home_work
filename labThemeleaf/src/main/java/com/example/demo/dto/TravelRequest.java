package com.example.demo.dto;

import com.example.demo.model.TravelType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class TravelRequest {
    private String nationality;
    private List<String> visitedCountries;
    private TravelType travelType;
    public TravelRequest(){
        visitedCountries= new ArrayList<>();
        travelType = TravelType.BASIC;

    }
}
