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
}
