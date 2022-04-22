package com.example.demo.service;

import com.example.demo.entity.Job;
import com.example.demo.model.request.CreateJob;
import com.example.demo.model.request.UpdateJob;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {
   public List<Job> getAllJob();
   public Job createJob(CreateJob createJob);
   public Job modifyJob(String id, UpdateJob updateJob);
   public void DeleteJob(String id);
   public List<Job> sortedJobOrderLocation();
   public List<Job> findJobBySalary(double salary);
}
