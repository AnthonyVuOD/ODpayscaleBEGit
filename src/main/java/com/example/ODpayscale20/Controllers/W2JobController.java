package com.example.ODpayscale20.Controllers;


import com.example.ODpayscale20.Entities.Optometrist;
import com.example.ODpayscale20.Entities.W2Job;
import com.example.ODpayscale20.Services.W2JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/w2jobs")
public class W2JobController {

    @Autowired
    private W2JobService w2JobService;

    @GetMapping
    public ResponseEntity<List<W2Job>> getAllW2Jobs(){
        return new ResponseEntity<List<W2Job>>(w2JobService.allW2Jobs(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<W2Job>> getW2JobByObjectId(@PathVariable Long id){
        return new ResponseEntity<Optional<W2Job>>(w2JobService.findW2JobByObjectId(id), HttpStatus.OK);
    }

    @PostMapping("/createw2job")
    public ResponseEntity<W2Job> postCreateW2Job(String dateCreated,
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
                                                 Integer annualSalaryAndBonus,
                                                 Float weeklyHours,
                                                 Integer patientsPerWeek,
                                                 Float compPerPatient,
                                                 Float compPerHour,
                                                 Integer normalizedAnnualComp){

        return new ResponseEntity<W2Job>(w2JobService.createW2Job(  dateCreated,
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
                                                                    annualSalaryAndBonus,
                                                                    weeklyHours,
                                                                    patientsPerWeek,
                                                                    compPerPatient,
                                                                    compPerHour,
                                                                    normalizedAnnualComp),HttpStatus.OK);
    }
}
