package com.example.demo.service;

import com.example.demo.entity.Job;
import com.example.demo.entity.Location;
import com.example.demo.exception.DuplicateException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.request.CreateJob;
import com.example.demo.model.request.UpdateJob;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class JobImp implements JobService {
    private static List<Job> jobs = new ArrayList<>();

    static {
        jobs.add(new Job("1", "Tuyển dụng java dev", "Java,Spring FrameWork", Location.HA_NOI, 500, 2000, "Nam@gmail.com"));
        jobs.add(new Job("2", "Tuyển dụng Front end", "JavaScript, React", Location.HO_CHI_MINH, 400, 1500, "Nam@gmail.com"));
        jobs.add(new Job("3", "Tuyển dụng back end", "Node.js,Spring boot", Location.DA_NANG, 1000, 2000, "Nam123@gmail.com"));
        jobs.add(new Job("4", "Tuyển dụng auto test, BA", "Automation tester , BA", Location.HAI_PHONG, 300, 3000, "Nam112233@gmail.com"));
        jobs.add(new Job("5", "Tuyển dụng fullstack", "CSS,JS,HTML,Node.JS", Location.HAI_PHONG, 100, 1000, "Nam11222233@gmail.com"));
        //   Copyright of Huy Nam.
    }

    @Override
    public List<Job> getAllJob() {
        if (!jobs.isEmpty()) {
            return jobs;
        }
        throw new NotFoundException("Not found list");
    }

    @Override
    public Job createJob(CreateJob createJob) {
        String uuid = UUID.randomUUID().toString();
        Job newJob = new Job();
        jobs.stream().forEach(job -> {
            if (job.getEmailTo().equals(createJob.getEmailTo())) {
                throw new DuplicateException("Email is already");
            }
        });

        newJob.setId(uuid);
        newJob.setTitle(createJob.getTitle());
        newJob.setDescription(createJob.getDescription());
        newJob.setEmailTo(createJob.getEmailTo());
        newJob.setMaxSalary(createJob.getMaxSalary());
        newJob.setMinSalary(createJob.getMinSalary());
        newJob.setLocation(createJob.getLocation());

        return newJob;
    }

    @Override
    public Job modifyJob(String id, UpdateJob updateJob) {
        Job uJob = new Job();
        for (Job j : jobs) {
            if (j.equals(id)) {
                j.setTitle(updateJob.getTitle());
                j.setDescription(updateJob.getDescription());
                j.setMaxSalary(updateJob.getMaxSalary());
                j.setMinSalary(updateJob.getMinSalary());
                j.setLocation(updateJob.getLocation());
                return j;
            }
        }
        throw new NotFoundException("Find not id");
    }

    @Override
    public void DeleteJob(String id) {
        for (Job j : jobs) {
            if (j.getId().equals(id)) {
                jobs.remove(j);
            }
        }
    }

    @Override
    public List<Job> sortedJobOrderLocation() {
        List<Job> result = jobs.stream().sorted(Comparator.comparing(Job::getLocation)).collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new NotFoundException("Job list is empty");
        }
        return result;
    }

    @Override
    public List<Job> findJobBySalary(double salary) {
        List<Job> result = jobs.stream().filter(s -> (s.getMaxSalary() > salary) && (s.getMinSalary() < salary)).collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new NotFoundException("Job list is empty");
        }
        return result;
    }

    @Override
    public List<Job> findJobByTitleOrDescription(String titleOrDescription) {
        List<Job> result = jobs.stream().filter(s -> (s.getDescription().toLowerCase().contains(titleOrDescription)) || s.getTitle().toLowerCase().contains(titleOrDescription)).collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new NotFoundException("Job list is empty");
        }
        return result;
    }

    public List<Job> findJobByTitleOrDescriptionOrKeyword(Location location, String title) {
        List<Job> result = jobs.stream().filter(s -> ((s.getTitle().toLowerCase().contains(title)) || s.getTitle().toLowerCase().contains(title)))
                .filter(s->s.getLocation().equals(location))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new NotFoundException("Job list is empty");
        }
        return result;
    }
}
//
