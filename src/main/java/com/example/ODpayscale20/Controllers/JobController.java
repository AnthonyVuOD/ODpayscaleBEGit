package com.example.ODpayscale20.Controllers;

import com.example.ODpayscale20.Entities.Job;
import com.example.ODpayscale20.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    @Autowired
    private JobService jobService;


    @GetMapping("getalljobs")
    public ResponseEntity<List<Job>> getAllJobs(){
        return new ResponseEntity<List<Job>>(jobService.allJobs(), HttpStatus.OK);
    }
    @DeleteMapping("/deletesinglejob/{id}")
    public String deleteSingleJob(@PathVariable Long id){
        return jobService.deleteJob(id);
    }

//    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
//        // Logic to delete the job with the given ID
//        // You might want to check if the job exists before deleting it
//
//        // For demonstration purposes, let's assume a service method is used
//        // to delete the job. Replace this with your actual deletion logic.
//        boolean isDeleted = jobService.deleteJob(id);
//
//        if (isDeleted) {
//            return ResponseEntity.ok("Job deleted successfully");
//        } else {
//            return ResponseEntity.status(404).body("Job not found");
//        }
//    }

    //New
    @GetMapping("/getjobsbyoptometristid/{optometristId}")
    public ResponseEntity<List<Job>> getJobsByOptometristId(@PathVariable Long optometristId) {
        return new ResponseEntity<List<Job>>(jobService.jobsByOptometristId(optometristId),HttpStatus.OK);
    }
}


