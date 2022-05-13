package com.example.demo.repository;

import com.example.demo.model.Job;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class JobRepository {
    private static ConcurrentHashMap<Integer, Job> listJob = new ConcurrentHashMap<>();

    static {
        listJob.put(1, new Job("Java", "Citigo", 200));
        listJob.put(2, new Job("nodeJs", "FPT", 400));
        listJob.put(3, new Job(".Net", "Viettel", 500));
        listJob.put(4, new Job("Spring", "Tiki", 1000));
        listJob.put(5, new Job("React", "Shopee", 500));
    }

    public List<Job> getListJobs() {
        List<Job> list = listJob.values().stream().collect(Collectors.toList());
        return list;
    }

    public void addJob(int key, Job job){
        listJob.put(key, job);
    }

}
