package com.example.ODpayscale20.Services;

import com.example.ODpayscale20.Entities.Job;
import com.example.ODpayscale20.Repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    //Get Jobs by OptometristId
    public List<Job> jobsByOptometristId(Long optometristId){

        List<Job> allJobs = jobRepository.findAll();

        // Filter jobs based on optometristId
        return allJobs.stream()
                .filter(job -> job.getOptometrist().getId().equals(optometristId))
                .collect(Collectors.toList());
    }
}
