package com.example.ODpayscale20.Services;

import com.example.ODpayscale20.Entities.ContractorJob;
import com.example.ODpayscale20.Entities.Job;
import com.example.ODpayscale20.Entities.W2Job;
import com.example.ODpayscale20.Repositories.ContractorJobRepository;
import com.example.ODpayscale20.Repositories.JobRepository;
import com.example.ODpayscale20.Repositories.W2JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobService {
//    @Autowired
    private final JobRepository jobRepository;
//    @Autowired
    private final W2JobRepository w2JobRepository;
//    @Autowired
    private final ContractorJobRepository contractorJobRepository;

    @Autowired
    public JobService(JobRepository jobRepository,
                      W2JobRepository w2JobRepository,
                      ContractorJobRepository contractorJobRepository){
        this.jobRepository=jobRepository;
        this.w2JobRepository=w2JobRepository;
        this.contractorJobRepository=contractorJobRepository;

    }

    public List<Job> allJobs(){
        return jobRepository.findAll();
    }


    public String deleteJob(Long jobId){
        System.out.println("The service was successfully accessed.");

        try {
            // Delete the ContractorJob
            contractorJobRepository.deleteById(jobId);
            // Also delete the associated Job
            jobRepository.deleteById(jobId);

            System.out.println("Success?");
            return "ContractorJob with ID " + jobId + " deleted successfully.";
        } catch (EmptyResultDataAccessException e) {
            // Handle case where the job with the given ID does not exist
            return "ContractorJob with ID " + jobId + " not found.";
        } catch (Exception e) {
            // Handle other exceptions, such as database errors
            return "Error deleting ContractorJob with ID " + jobId + ": " + e.getMessage();
        }
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
