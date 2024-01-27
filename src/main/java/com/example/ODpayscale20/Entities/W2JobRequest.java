package com.example.ODpayscale20.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class W2JobRequest {
    private Long optometristId;
    private Integer year;
    private String state;
    private String city;
    private String practiceMode;
    private String setting;
    private Double paidDaysOff;
    private Integer healthInsuranceValue;
    private Integer otherBenefitsValue;
    private String comments;
    private Double annualSalaryAndBonus;
    private Double weeklyHours;
    private Double patientsPerWeek;
}
