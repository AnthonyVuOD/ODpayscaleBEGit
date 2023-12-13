package com.example.ODpayscale20.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name="w2_jobs")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class W2Job extends Job{
    @Column(name = "annual_salary_and_bonus")
    private int annualSalaryAndBonus;
    @Column(name = "weekly_hours")
    private float weeklyHours;
    @Column(name = "patients_per_week")
    private int patientsPerWeek;
    @Column(name = "comp_per_patient")
    private float compPerPatient;
    @Column(name = "comp_per_hour")
    private float compPerHour;
    @Column(name = "normalized_annual_comp")
    private int normalizedAnnualComp;

    public W2Job(   String dateCreated,
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
                    Integer annualSalaryAndBonus,
                    Float weeklyHours,
                    Integer patientsPerWeek,
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
        this.annualSalaryAndBonus=annualSalaryAndBonus;
        this.weeklyHours=weeklyHours;
        this.patientsPerWeek=patientsPerWeek;
        this.compPerPatient=compPerPatient;
        this.compPerHour=compPerHour;
        this.normalizedAnnualComp=normalizedAnnualComp;
    }
}
