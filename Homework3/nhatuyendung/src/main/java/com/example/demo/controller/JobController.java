package com.example.demo.controller;

import com.example.demo.dto.JobRequest;
import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class JobController {
    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/job-list")
    public String getListJob(Model model) {
        model.addAttribute("jobs", jobRepository.getListJobs());
        return "job-list";
    }

    @GetMapping ("/add-job")
    public String addJob(Model model) {
        model.addAttribute("jobRequest",new JobRequest());
        return "job-form";
    }

    @PostMapping ("/add-job")
    public String handlingNewJob(@ModelAttribute("jobRequest") @Valid JobRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "job-form";
        }

        int key = jobRepository.getListJobs().size()+1;
        Job newJob = new Job(request.getName(),request.getEmployer(),request.getSalary());
        jobRepository.addJob(key,newJob);
        return "redirect:/job-list";
    }




}
