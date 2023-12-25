package com.example.ODpayscale20.Controllers;

import com.example.ODpayscale20.Entities.Job;
import com.example.ODpayscale20.Entities.Optometrist;
import com.example.ODpayscale20.Services.OptometristService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/optometrists")
public class OptometristController {

    //refers to service class which in turn refers to repo interface
    @Autowired
    private OptometristService optometristService;

    @GetMapping("getalloptometrists")
    public ResponseEntity<List<Optometrist>> getAllOptometrists(){
        return new ResponseEntity<List<Optometrist>>(optometristService.allOptometrists(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Optometrist>> getSingleOptometrist(@PathVariable Long id){
        return new ResponseEntity<Optional<Optometrist>>(optometristService.singleOptometrist(id), HttpStatus.OK);
    }

    @PostMapping("/createoptometrist")
    public ResponseEntity<Optometrist> postCreateOptometrist( @RequestBody Optometrist optometrist){
        Integer yearGraduated = optometrist.getYearGraduated();
        String residency = optometrist.getResidency();
        Integer initialDebt = optometrist.getInitialDebt();
        String gender = optometrist.getGender();
        String race = optometrist.getRace();
        Set<Job> jobs = optometrist.getJobs();

        return new ResponseEntity<Optometrist>(optometristService.createOptometrist(yearGraduated,
                                                                                    residency,
                                                                                    initialDebt,
                                                                                    gender,
                                                                                    race,
                                                                                    jobs ), HttpStatus.CREATED);
    }
}
