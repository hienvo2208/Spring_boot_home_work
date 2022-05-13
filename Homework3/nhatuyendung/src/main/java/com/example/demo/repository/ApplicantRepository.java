package com.example.demo.repository;

import com.example.demo.model.Applicant;
import com.example.demo.model.Employer;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
@Component
public class ApplicantRepository {
    private static ConcurrentHashMap<Integer, Applicant> applicantList = new ConcurrentHashMap<>();
    static {
        applicantList.put(1,new Applicant("Hanh Than","31-07-1999","Doctor",5));
        applicantList.put(2,new Applicant("Hien Vo","22-08-1999","Unknow...",5));
    }

    public List<Applicant> getListApplicant(){
        List<Applicant> newList = applicantList.values().stream().collect(Collectors.toList());
        return newList;
    }

    public void addEmployer(int key, Applicant applicant){
        applicantList.put(key,applicant);
    }
}
