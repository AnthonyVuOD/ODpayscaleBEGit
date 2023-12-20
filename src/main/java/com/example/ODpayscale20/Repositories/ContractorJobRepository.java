package com.example.ODpayscale20.Repositories;

import com.example.ODpayscale20.Entities.ContractorJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorJobRepository extends JpaRepository<ContractorJob ,Long> {}
