package com.example.ODpayscale20.Services;

import com.example.ODpayscale20.Entities.ContractorJob;
import com.example.ODpayscale20.Entities.Job;
import com.example.ODpayscale20.Entities.W2Job;
import com.example.ODpayscale20.Repositories.ContractorJobRepository;
import com.example.ODpayscale20.Repositories.JobRepository;
import com.example.ODpayscale20.Repositories.W2JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private W2JobRepository w2JobRepository;
    @Autowired
    private ContractorJobRepository contractorJobRepository;

    public List<Job> allJobs(){
        return jobRepository.findAll();
    }

    public String deleteJob(Long jobId){
        // Delete associated contractor jobs first
//        ContractorJob contractorJob =contractorJobRepository.getReferenceById(jobId);
//        contractorJobRepository.delete(contractorJob);

        // Delete associated W2 jobs
//        W2Job w2Job = w2JobRepository.getReferenceById(jobId);
//        w2JobRepository.delete(w2Job);


        // Delete the job itself
        jobRepository.deleteById(jobId);
        return ("Job "+ jobId + " deleted.");
    }

//    public boolean deleteJob(Long jobId) {
//        // Check if the job exists before attempting to delete
////        if (jobRepository.existsById(jobId)) {
////            jobRepository.deleteById(jobId);
////            return true;  // Job deleted successfully
////            //but not being updated in MySQL
////        } else {
////            return false; // Job not found
////        }
//
//        if (jobRepository.existsById(jobId)) {
//            jobRepository.deleteById(jobId);
//            return true;  // Job deleted successfully
//            //but not being updated in MySQL
//        } else {
//            return false; // Job not found
//        }
//
//    }

    //Get Jobs by OptometristId
    public List<Job> jobsByOptometristId(String optometristId){

        List<Job> allJobs = jobRepository.findAll();

        // Filter jobs based on optometristId
        return allJobs.stream()
                .filter(job -> job.getOptometrist().getId().equals(optometristId))
                .collect(Collectors.toList());
    }
}
