package com.example.ODpayscale20.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="contractor_jobs")
@Data
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class ContractorJob extends Job{
    @Column(name = "daily_rate_and_bonus")
    private Integer dailyRateAndBonus;
    @Column(name = "daily_hours")
    private Float dailyHours;
    @Column(name = "patients_per_day")
    private Integer patientsPerDay;
    @Column(name = "comp_per_patient")
    private Float compPerPatient;
    @Column(name = "comp_per_hour")
    private Float compPerHour;
    @Column(name = "normalized_annual_comp")
    private Integer normalizedAnnualComp;

    public ContractorJob(   String dateCreated,
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
                            Integer dailyRateAndBonus,
                            Float dailyHours,
                            Integer patientsPerDay,
                            Float compPerPatient,
                            Float compPerHour,
                            Integer normalizedAnnualComp){
        super(  dateCreated,
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
                yearsOfExperience);
        this.dailyRateAndBonus=dailyRateAndBonus;
        this.dailyHours=dailyHours;
        this.patientsPerDay=patientsPerDay;
        this.compPerPatient=compPerPatient;
        this.compPerHour=compPerHour;
        this.normalizedAnnualComp=normalizedAnnualComp;
    }
}
