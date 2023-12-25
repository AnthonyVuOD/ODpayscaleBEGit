package com.example.ODpayscale20.Controllers;


import com.example.ODpayscale20.Entities.ContractorJob;
import com.example.ODpayscale20.Entities.ContractorJobRequest;
import com.example.ODpayscale20.Entities.Optometrist;
import com.example.ODpayscale20.Repositories.OptometristRepository;
import com.example.ODpayscale20.Services.ContractorJobService;
import com.example.ODpayscale20.Services.OptometristService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/v1/contractorjobs")
public class ContractorJobController {

    @Autowired
    private ContractorJobService contractorJobService;
    @Autowired
    private OptometristRepository optometristRepository;

    @GetMapping("/getallcontractorjobs")
    public ResponseEntity<List<ContractorJob>> getAllContractorJobs(){
        return new ResponseEntity<List<ContractorJob>>(contractorJobService.allContractorJobs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ContractorJob>> getContactorJobByObjectId(@PathVariable Long id){
        return new ResponseEntity<Optional<ContractorJob>>(contractorJobService.findContractorJobByObjectId(id),HttpStatus.OK);
    }

    @PostMapping("/createcontractorjob")
    public ResponseEntity<ContractorJob> postCreateContractorJobThroughContractorJobRequest( @RequestBody ContractorJobRequest contractorJob){
        Long optometristId = contractorJob.getOptometristId();
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

        return new ResponseEntity<ContractorJob>(contractorJobService.createContractorJobThroughContractorRequest(
                                                                optometristId,
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
