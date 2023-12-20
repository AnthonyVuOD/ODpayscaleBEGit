package com.example.ODpayscale20.Controllers;

import com.example.ODpayscale20.Entities.Job;
import com.example.ODpayscale20.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("getalljobs")
    public ResponseEntity<List<Job>> getAllJobs(){
        return new ResponseEntity<List<Job>>(jobService.allJobs(), HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<Job>> getAllJobsByOptometristId(){
//        return new ResponseEntity<List<Job>>(jobService.allJobs().stream().filter())
//    }
//    DeleteMapping
}
