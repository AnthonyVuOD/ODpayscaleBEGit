package com.example.ODpayscale20.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContractorJobRequest {
    private String optometristId;
    private Integer year;
    private String state;
    private String city;
    private String practiceMode;
    private String setting ;
    private Double paidDaysOff;
    private Integer healthInsuranceValue;
    private Integer retirementBenefitsValue;
    private Integer otherBenefitsValue;
    private String comments;
    private Double dailyRateAndBonus;
    private Double dailyHours;
    private Double patientsPerDay;
}
