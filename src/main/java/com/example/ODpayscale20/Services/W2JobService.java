package com.example.ODpayscale20.Services;

import com.example.ODpayscale20.Entities.Job;
import com.example.ODpayscale20.Entities.Optometrist;
import com.example.ODpayscale20.Entities.W2Job;
import com.example.ODpayscale20.Repositories.OptometristRepository;
import com.example.ODpayscale20.Repositories.W2JobRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class W2JobService {

//    @Autowired
    private final W2JobRepository w2JobRepository;
//    @Autowired
    private final OptometristRepository optometristRepository;

    @Autowired
    public W2JobService (W2JobRepository w2JobRepository, OptometristRepository optometristRepository){
        this.optometristRepository=optometristRepository;
        this.w2JobRepository=w2JobRepository;
    }

    public List<W2Job> allW2Jobs(){
        return w2JobRepository.findAll();
    }

    public Optional<W2Job> findW2JobByObjectId(Long id){
        return w2JobRepository.findById(id);
    }

    public W2Job createW2JobThroughW2JobRequest(
                              Long optometristId,
                              Integer year,
                              String state,
                              String city,
                              String practiceMode,
                              String setting,
                              Integer paidDaysOff,
                              Integer healthInsuranceValue,
                              Integer otherBenefitsValue,
                              String comments,
                              Double annualSalaryAndBonus,
                              Double weeklyHours,
                              Integer patientsPerWeek){

        Optometrist optometrist = optometristRepository.findById(optometristId)
                .orElseThrow(() -> new EntityNotFoundException("Optometrist with id not found"));

        W2Job w2Job = new W2Job(
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
                                    patientsPerWeek);

//        w2Job.setOptometrist(optometrist);
//        w2Job.setYear(year);
//        w2Job.setState(state);
//        w2Job.setCity(city);
//        w2Job.setPracticeMode(practiceMode);
//        w2Job.setSetting(setting);
//        w2Job.setPaidDaysOff(paidDaysOff);
//        w2Job.setHealthInsuranceValue(healthInsuranceValue);
//        w2Job.setOtherBenefitsValue(otherBenefitsValue);
//        w2Job.setComments(comments);
//        w2Job.setAnnualSalaryAndBonus(annualSalaryAndBonus);
//        w2Job.setWeeklyHours(weeklyHours);
//        w2Job.setPatientsPerWeek(patientsPerWeek);


//        Set<Job> jobs= optometrist.getJobs();
//        jobs.add(w2Job);
//        optometristRepository.save(optometrist);

        w2JobRepository.save(w2Job);

        return w2Job;
    }
}
