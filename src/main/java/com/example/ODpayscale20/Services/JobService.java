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

}
