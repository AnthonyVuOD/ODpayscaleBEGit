package com.example.ODpayscale20.Controllers;//package com.project.ODpayscale.Controllers;
//
//import com.project.ODpayscale.Entities.Job;
//import com.project.ODpayscale.Services.JobService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/v1/jobs")
//public class JobController {
//    @Autowired
//    private JobService jobService;
//
//    @GetMapping
//    public ResponseEntity<List<Job>> getAllJobs(){
//        return new ResponseEntity<List<Job>>(jobService.allJobs(), HttpStatus.OK);
//    }
//
//}
