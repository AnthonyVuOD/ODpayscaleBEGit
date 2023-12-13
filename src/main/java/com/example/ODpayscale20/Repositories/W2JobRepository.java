package com.example.ODpayscale20.Repositories;

import com.example.ODpayscale20.Entities.W2Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface W2JobRepository extends JpaRepository<W2Job,Long> {
}
