package com.example.ODpayscale20.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Entity
@Table(name="contractor_jobs")
@DiscriminatorValue("1099")
@Data
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class ContractorJob extends Job{
    @Column(name = "daily_rate_and_bonus")
    private Double dailyRateAndBonus;
    @Column(name = "daily_hours")
    private Double dailyHours;
    @Column(name = "patients_per_day")
    private Double patientsPerDay;
    @Column(name = "comp_per_patient")
    private Double compPerPatient;
    @Column(name = "comp_per_hour")
    private Double compPerHour;
    @Column(name = "normalized_annual_comp")
    private Double normalizedAnnualComp;

    @Column(name = "paid_days_off_value")
    private Double paidDaysOffValue;

    @Column(name = "annualized_daily_rate_and_bonus")
    private Double annualizedDailyRateAndBonus;

    public ContractorJob(   Optometrist optometrist,
                            Integer year,
                            String state,
                            String city,
                            String practiceMode,
                            String setting,
                            Double paidDaysOff,
                            Integer healthInsuranceValue,
                            Integer otherBenefitsValue,
                            String comments,
                            //
                            Double dailyRateAndBonus,
                            Double dailyHours,
                            Double patientsPerDay
                            ){
        super(  optometrist,
                year,
                state,
                city,
                practiceMode,
                setting,
                paidDaysOff,
                healthInsuranceValue,
                otherBenefitsValue,
                comments
                );
        this.dailyRateAndBonus=dailyRateAndBonus;
        this.dailyHours=dailyHours;
        this.patientsPerDay=patientsPerDay;

        this.annualizedDailyRateAndBonus=dailyRateAndBonus*255;
        this.paidDaysOffValue=paidDaysOff*dailyRateAndBonus;
        this.normalizedAnnualComp= (dailyRateAndBonus*255 +healthInsuranceValue+otherBenefitsValue+paidDaysOffValue);
        this.compPerPatient = normalizedAnnualComp/(patientsPerDay*255);
        this.compPerHour = normalizedAnnualComp/(dailyHours*255);
    }
}
