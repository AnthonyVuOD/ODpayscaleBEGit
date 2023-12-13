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

    public ContractorJob createContractorJob(String dateCreated,
                                             Optometrist associatedOptometristId,
                                             Integer year,
                                             String state,
                                             String city,
                                             String companyName,
                                             String practiceMode,
                                             String setting,
                                             Boolean weekends,
                                             Integer paidDaysOff,
                                             Integer healthInsuranceValue,
                                             Integer otherBenefitsValue,
                                             String comments,
                                             Float totalBenefitsValue,
                                             Integer yearsOfExperience,
                                             Integer dailyRateAndBonus,
                                             Float dailyHours,
                                             Integer patientsPerDay,
                                             Float compPerPatient,
                                             Float compPerHour,
                                             Integer normalizedAnnualComp){

        ContractorJob contractorJob = new ContractorJob(dateCreated,
                                                        associatedOptometristId,
                                                        year,
                                                        state,
                                                        city,
                                                        companyName,
                                                        practiceMode,
                                                        setting,
                                                        weekends,
                                                        paidDaysOff,
                                                        healthInsuranceValue,
                                                        otherBenefitsValue,
                                                        comments,
                                                        totalBenefitsValue,
                                                        yearsOfExperience,
                                                        dailyRateAndBonus,
                                                        dailyHours,
                                                        patientsPerDay,
                                                        compPerPatient,
                                                        compPerHour,
                                                        normalizedAnnualComp);
        contractorJobRepository.save(contractorJob);

        return contractorJob;
    }
}
