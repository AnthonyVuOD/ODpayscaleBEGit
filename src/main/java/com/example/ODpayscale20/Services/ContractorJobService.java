package com.example.ODpayscale20.Services;

import com.example.ODpayscale20.Entities.ContractorJob;
import com.example.ODpayscale20.Entities.ContractorJobRequest;
import com.example.ODpayscale20.Entities.Job;
import com.example.ODpayscale20.Entities.Optometrist;
import com.example.ODpayscale20.Repositories.ContractorJobRepository;
import com.example.ODpayscale20.Repositories.OptometristRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ContractorJobService {

    private final ContractorJobRepository contractorJobRepository;
    private final OptometristRepository optometristRepository;

    @Autowired
    public ContractorJobService(ContractorJobRepository contractorJobRepository,
                                OptometristRepository optometristRepository){
        this.contractorJobRepository = contractorJobRepository;
        this.optometristRepository = optometristRepository;
    }

    public List<ContractorJob> allContractorJobs(){
        return contractorJobRepository.findAll();
    }

    public Optional<ContractorJob> findContractorJobByObjectId(Long id){
        return contractorJobRepository.findById(id);
    }

    public ContractorJob createContractorJobThroughContractorRequest(
                                             String optometristId,
                                             Integer year,
                                             String state,
                                             String city,
                                             String practiceMode,
                                             String setting,
                                             Double paidDaysOff,
                                             Integer healthInsuranceValue,
                                             Integer retirementBenefitsValue,
                                             Integer otherBenefitsValue,
                                             String comments,
                                             Double dailyRateAndBonus,
                                             Double dailyHours,
                                             Double patientsPerDay){

        Optometrist optometrist = optometristRepository.findById(optometristId)
                .orElseThrow(() -> new EntityNotFoundException("Optometrist with id:"+optometristId+" not found"));

        ContractorJob contractorJob = new ContractorJob(
                                                        optometrist,
                                                        year,
                                                        state,
                                                        city,
                                                        practiceMode,
                                                        setting,
                                                        paidDaysOff,
                                                        healthInsuranceValue,
                                                        retirementBenefitsValue,
                                                        otherBenefitsValue,
                                                        comments,
                                                        dailyRateAndBonus,
                                                        dailyHours,
                                                        patientsPerDay);
        //This saves contractorJob to OD Set<jobs>
//        Set<Job> jobs = optometrist.getJobs();
//        jobs.add(contractorJob);
//        optometristRepository.save(optometrist);

        // Saves new contractorJob
        contractorJobRepository.save(contractorJob);

        return contractorJob;
    }

//    @Transactional
//    public String deleteContractorJob(Long jobId){
//        System.out.println("The contractorJobService was successfully accessed.");
//
////        ContractorJob contractorJob = contractorJobRepository.findById(jobId)
////                .orElseThrow(() -> new RuntimeException("Contractor job not found for job with id: " + jobId));
//
//        try {
//            contractorJobRepository.deleteById(jobId);
//            System.out.println("succesfully deleted");
//        } catch (Exception e){
//            System.out.println("Error!");
//        }
//
//        return "Hello";
//    }
}
