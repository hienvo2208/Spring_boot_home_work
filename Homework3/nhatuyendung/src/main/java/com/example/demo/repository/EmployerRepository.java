package com.example.demo.repository;

import com.example.demo.dto.EmployerRequest;
import com.example.demo.model.Employer;
import com.example.demo.model.Job;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class EmployerRepository {
    private static ConcurrentHashMap<Integer, Employer> listEmployer = new ConcurrentHashMap<>();

    static {
        listEmployer.put(1, new Employer("FPT", "Ha Noi"));
        listEmployer.put(2, new Employer("Viettel", "Ha Noi"));
        listEmployer.put(3, new Employer("Citigo", "Ha Noi"));
        listEmployer.put(4, new Employer("Tiki", "Sai Gon"));
        listEmployer.put(5, new Employer("Shopee", "Sai Gon"));
    }

    public List<Employer> getListEmployer(){
        List<Employer> newList = listEmployer.values().stream().collect(Collectors.toList());
        return newList;
    }

    public void addEmployer(int key, Employer employer){
        listEmployer.put(key,employer);
    }





}
