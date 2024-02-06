package com.example.ODpayscale20.Services;


import com.example.ODpayscale20.Entities.Job;
import com.example.ODpayscale20.Entities.Optometrist;
import com.example.ODpayscale20.Repositories.OptometristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//Services access data from repository.
@Service
public class OptometristService {

    //refers to repository interface
    @Autowired
    private OptometristRepository optometristRepository;

    public List<Optometrist> allOptometrists(){ return optometristRepository.findAll();}

    public Optional<Optometrist> singleOptometrist(Long id){
        return optometristRepository.findById(id);
    }

    public String deleteOptometrist(Long id){
        optometristRepository.deleteById(id);
        return "OD "+ id +" deleted." ;
    }


    public Optional<Optometrist> updateOptometrist( Long id,
                                                    Integer yearGraduated,
                                                    String residency,
                                                    Integer initialDebt,
                                                    String gender,
                                                    String race
                                                    ) {

        Optional<Optometrist> optometristToUpdate = optometristRepository.findById(id);
        if (optometristToUpdate.isPresent()){
            Optometrist optometrist = optometristToUpdate.get();

            optometrist.setYearGraduated(yearGraduated);
            optometrist.setResidency(residency);
            optometrist.setInitialDebt(initialDebt);
            optometrist.setGender(gender);
            optometrist.setRace(race);

            optometristRepository.save(optometrist);

            return Optional.of(optometrist);
        } else {
            return Optional.empty();
        }

//        optometristToUpdate.get().setYearGraduated(yearGraduated);
//        optometristToUpdate.get().setResidency(residency);
//        optometristToUpdate.get().setInitialDebt(initialDebt);
//        optometristToUpdate.get().setGender(gender);
//        optometristToUpdate.get().setRace(race);
//
//        optometristRepository.save(optometristToUpdate);
////
//        return optometristToUpdate;
    }


    public Optometrist createOptometrist(
                                         Integer yearGraduated,
                                         String residency,
                                         Integer initialDebt,
                                         String gender,
                                         String race,
                                         Set<Job> jobs
                                                        ){

        Optometrist optometrist = new Optometrist(yearGraduated,residency,initialDebt,gender,race, jobs);

        optometristRepository.save(optometrist);

        return optometrist;
    }
    
}
