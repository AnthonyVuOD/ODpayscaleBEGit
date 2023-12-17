package com.example.ODpayscale20.Controllers;


import com.example.ODpayscale20.Entities.ContractorJob;
import com.example.ODpayscale20.Entities.Optometrist;
import com.example.ODpayscale20.Services.ContractorJobService;
import jakarta.persistence.criteria.CriteriaBuilder;
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
    public ResponseEntity<ContractorJob> postCreateContractorJob(  @RequestBody ContractorJob contractorJob){
        Optometrist optometrist = contractorJob.getOptometrist();
        Integer year = contractorJob.getYear();
        String state = contractorJob.getState();
        String city = contractorJob.getCity();
        String practiceMode = contractorJob.getPracticeMode();
        String setting = contractorJob.getSetting();
        Integer paidDaysOff = contractorJob.getPaidDaysOff();
        Integer healthInsuranceValue = contractorJob.getHealthInsuranceValue();
        Integer otherBenefitsValue = contractorJob.getOtherBenefitsValue();
        String comments = contractorJob.getComments();
        Double dailyRateAndBonus = contractorJob.getDailyRateAndBonus();
        Double dailyHours = contractorJob.getDailyHours();
        Integer patientsPerDay =contractorJob.getPatientsPerDay();

        return new ResponseEntity<ContractorJob>(contractorJobService.createContractorJob(  optometrist,
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
                                                                                            patientsPerDay), HttpStatus.OK);

    }
}
