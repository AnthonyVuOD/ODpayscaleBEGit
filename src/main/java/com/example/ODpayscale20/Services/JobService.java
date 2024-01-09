package com.example.ODpayscale20.Services;

import com.example.ODpayscale20.Entities.Job;
import com.example.ODpayscale20.Repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> allJobs(){
        return jobRepository.findAll();
    }

    public boolean deleteJob(Long jobId) {
        // Check if the job exists before attempting to delete
//        if (jobRepository.existsById(jobId)) {
//            jobRepository.deleteById(jobId);
//            return true;  // Job deleted successfully
//            //but not being updated in MySQL
//        } else {
//            return false; // Job not found
//        }

        if (jobRepository.existsById(jobId)) {
            Job job = jobRepository.findById(jobId).get();
            jobRepository.delete(job);
            return true;  // Job deleted successfully
            //but not being updated in MySQL
        } else {
            return false; // Job not found
        }

    }

//    public List<Job> jobsByOptometristId {return jobRepository.findAllById()};
}
