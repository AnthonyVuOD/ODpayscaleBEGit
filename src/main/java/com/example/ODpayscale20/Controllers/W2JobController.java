package com.example.ODpayscale20.Controllers;


import com.example.ODpayscale20.Entities.Optometrist;
import com.example.ODpayscale20.Entities.W2Job;
import com.example.ODpayscale20.Services.W2JobService;
import jakarta.persistence.criteria.CriteriaBuilder;
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
    public ResponseEntity<W2Job> postCreateW2Job( @RequestBody W2Job w2job){
        Optometrist optometrist = w2job.getOptometrist();
        Integer year = w2job.getYear();
        String state = w2job.getState();
        String city = w2job.getCity();
        String practiceMode = w2job.getPracticeMode();
        String setting = w2job.getSetting();
        Integer paidDaysOff = w2job.getPaidDaysOff();
        Integer healthInsuranceValue = w2job.getHealthInsuranceValue();
        Integer otherBenefitsValue = w2job.getOtherBenefitsValue();
        String comments= w2job.getComments();
        Double annualSalaryAndBonus = w2job.getAnnualSalaryAndBonus();
        Double weeklyHours = w2job.getWeeklyHours();
        Integer patientsPerWeek = w2job.getPatientsPerWeek();

        return new ResponseEntity<W2Job>(w2JobService.createW2Job(
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
                                                                    annualSalaryAndBonus,
                                                                    weeklyHours,
                                                                    patientsPerWeek),HttpStatus.OK);
    }
}
