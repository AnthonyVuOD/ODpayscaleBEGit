package com.example.ODpayscale20.Controllers;


import com.example.ODpayscale20.Entities.Optometrist;
import com.example.ODpayscale20.Entities.W2Job;
import com.example.ODpayscale20.Entities.W2JobRequest;
import com.example.ODpayscale20.Repositories.OptometristRepository;
import com.example.ODpayscale20.Services.W2JobService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/w2jobs")
public class W2JobController {

    @Autowired
    private W2JobService w2JobService;
//    @Autowired
//    private OptometristRepository optometristRepository;

    @GetMapping("/getallw2jobs")
    public ResponseEntity<List<W2Job>> getAllW2Jobs(){
        return new ResponseEntity<List<W2Job>>(w2JobService.allW2Jobs(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<W2Job>> getW2JobByObjectId(@PathVariable Long id){
        return new ResponseEntity<Optional<W2Job>>(w2JobService.findW2JobByObjectId(id), HttpStatus.OK);
    }

    @PostMapping("/createw2job")
    public ResponseEntity<W2Job> postCreateW2JobThroughW2JobRequest( @RequestBody W2JobRequest w2job){
        Long optometristId = w2job.getOptometristId();
//        Optometrist optometrist = optometristRepository.getReferenceById(w2job.getOptometrist().getId());
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



        return new ResponseEntity<W2Job>(w2JobService.createW2JobThroughW2JobRequest(
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
                                                                    annualSalaryAndBonus,
                                                                    weeklyHours,
                                                                    patientsPerWeek),HttpStatus.OK);
    }
}
