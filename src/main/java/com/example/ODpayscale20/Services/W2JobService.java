package com.example.ODpayscale20.Services;

import com.example.ODpayscale20.Entities.Optometrist;
import com.example.ODpayscale20.Entities.W2Job;
import com.example.ODpayscale20.Repositories.W2JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class W2JobService {

    @Autowired
    private W2JobRepository w2JobRepository;

    public List<W2Job> allW2Jobs(){
        return w2JobRepository.findAll();
    }

    public Optional<W2Job> findW2JobByObjectId(Long id){
        return w2JobRepository.findById(id);
    }

    public W2Job createW2Job( String dateCreated,
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
                              Integer annualSalaryandBonus,
                              Float weeklyHours,
                              Integer patientsPerWeek,
                              Float compPerPatient,
                              Float compPerHour,
                              Integer normalizedAnnualComp){

        W2Job w2Job = new W2Job(    dateCreated,
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
                                    annualSalaryandBonus,
                                    weeklyHours,
                                    patientsPerWeek,
                                    compPerPatient,
                                    compPerHour,
                                    normalizedAnnualComp);

        w2JobRepository.save(w2Job);
        return w2Job;
    }
}
