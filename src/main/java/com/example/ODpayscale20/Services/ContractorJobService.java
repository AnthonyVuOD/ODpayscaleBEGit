package com.example.ODpayscale20.Services;

import com.example.ODpayscale20.Entities.ContractorJob;
import com.example.ODpayscale20.Entities.Optometrist;
import com.example.ODpayscale20.Repositories.ContractorJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractorJobService {

    @Autowired
    private ContractorJobRepository contractorJobRepository;

    public List<ContractorJob> allContractorJobs(){
        return contractorJobRepository.findAll();
    }

    public Optional<ContractorJob> findContractorJobByObjectId(Long id){
        return contractorJobRepository.findById(id);
    }

    public ContractorJob createContractorJob(
                                             Optometrist optometrist,
                                             Integer year,
                                             String state,
                                             String city,
                                             String practiceMode,
                                             String setting,
                                             Integer paidDaysOff,
                                             Integer healthInsuranceValue,
                                             Integer otherBenefitsValue,
                                             String comments,
                                             Double dailyRateAndBonus,
                                             Double dailyHours,
                                             Integer patientsPerDay){

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
                                                        patientsPerDay
                                                        );
        contractorJobRepository.save(contractorJob);

        return contractorJob;
    }
}
