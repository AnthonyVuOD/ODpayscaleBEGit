package com.example.ODpayscale20.Repositories;

import com.example.ODpayscale20.Entities.Optometrist;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

//Repositories accesses data from database
@Repository
public interface OptometristRepository extends JpaRepository<Optometrist,Long> {
}
