package com.example.ODpayscale20.Controllers;


import com.example.ODpayscale20.Entities.ContractorJob;
import com.example.ODpayscale20.Entities.Optometrist;
import com.example.ODpayscale20.Services.ContractorJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/contractorjobs")
public class ContractorJobController {

    @Autowired
    private ContractorJobService contractorJobService;

    @GetMapping
    public ResponseEntity<List<ContractorJob>> getAllContractorJobs(){
        return new ResponseEntity<List<ContractorJob>>(contractorJobService.allContractorJobs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ContractorJob>> getContactorJobByObjectId(@PathVariable Long id){
        return new ResponseEntity<Optional<ContractorJob>>(contractorJobService.findContractorJobByObjectId(id),HttpStatus.OK);
    }

    @PostMapping("/createcontractorjob")
    public ResponseEntity<ContractorJob> postCreateContractorJob(String dateCreated,
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

        return new ResponseEntity<ContractorJob>(contractorJobService.createContractorJob(  dateCreated,
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
                                                                                            normalizedAnnualComp), HttpStatus.OK);

    }

}
