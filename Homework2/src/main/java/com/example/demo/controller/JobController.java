package com.example.demo.controller;

import com.example.demo.entity.Job;
import com.example.demo.entity.Location;
import com.example.demo.model.request.CreateJob;
import com.example.demo.model.request.UpdateJob;
import com.example.demo.service.JobService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;


    @GetMapping("/list")
    public ResponseEntity<?> getAllJob() {
        List<Job> result = jobService.getAllJob();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateJob createjob) {
        Job newJob = jobService.createJob(createjob);
        return ResponseEntity.ok(newJob);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyJob(@PathVariable("id") String id, @RequestBody UpdateJob updateJob) {
        Job newJob = jobService.modifyJob(id, updateJob);
        return ResponseEntity.ok(newJob);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable("id") String id) {
        jobService.DeleteJob(id);
        return ResponseEntity.ok("Xoa thanh cong");
    }

    @GetMapping("/sortbylocation")
    public ResponseEntity<?> getJobSortByLocation(){
        List<Job> list = jobService.sortedJobOrderLocation();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/salary/{salary}")
    public ResponseEntity<?> getJobSortBySalary(@PathVariable("salary") double salary){
        List<Job> list = jobService.findJobBySalary(salary);
        return ResponseEntity.ok(list);
    }

    @GetMapping("keyword/{keyword}")
    public ResponseEntity<?> getJobByKeyword(@PathVariable("keyword") String keyword){
        List<Job> list = jobService.findJobByTitleOrDescription(keyword);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/query")
    public ResponseEntity<?> getJobByQuery(@RequestParam("location") Location location, @RequestParam("keyword") String key){
        List<Job> list = jobService.findJobByTitleOrDescriptionOrKeyword(location,key.toLowerCase());
        return ResponseEntity.ok(list);
    }

}
