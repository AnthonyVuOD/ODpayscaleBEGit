package com.example.ODpayscale20.Controllers;

import com.example.ODpayscale20.Entities.Job;
import com.example.ODpayscale20.Services.ContractorJobService;
import com.example.ODpayscale20.Services.JobService;
import com.example.ODpayscale20.Services.W2JobService;
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

//    @Autowired
//    private ContractorJobService contractorJobService;
    @Autowired
    private JobService jobService;

//    public JobController (ContractorJobService contractorJobService, JobService jobService){
//        this.contractorJobService=contractorJobService,
//        this.jobService=jobService;
//    }

    @GetMapping("getalljobs")
    public ResponseEntity<List<Job>> getAllJobs(){
        return new ResponseEntity<List<Job>>(jobService.allJobs(), HttpStatus.OK);
    }
    @DeleteMapping("/deletesinglejob/{id}")
//    public ResponseEntity<String> deleteSingleJob(@PathVariable Long id){
    public String deleteSingleJob(@PathVariable Long id){

        System.out.println("The API was successfully called. " + id);

        return jobService.deleteJob(id);

//        return ResponseEntity.ok(result);
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
    public ResponseEntity<List<Job>> getJobsByOptometristId(@PathVariable String optometristId) {
        return new ResponseEntity<List<Job>>(jobService.jobsByOptometristId(optometristId),HttpStatus.OK);
    }
}


