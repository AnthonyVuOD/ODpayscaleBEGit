package com.example.ODpayscale20.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.awt.geom.Arc2D;


@Entity
@Table(name="w2_jobs")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class W2Job extends Job{
    @Column(name = "annual_salary_and_bonus")
    private Double annualSalaryAndBonus;
    @Column(name = "weekly_hours")
    private Double weeklyHours;
    @Column(name = "patients_per_week")
    private Double patientsPerWeek;
    @Column(name = "comp_per_patient")
    private Double compPerPatient;
    @Column(name = "comp_per_hour")
    private Double compPerHour;
    @Column(name = "normalized_annual_comp")
    private Double normalizedAnnualComp;

    //
    @Column(name = "paid_days_off_value")
    private Double paidDaysOffValue;

    public W2Job(
                    Optometrist optometrist,
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
                    Double annualSalaryAndBonus,
                    Double weeklyHours,
                    Double patientsPerWeek){
        super(
                optometrist,
                year,
                state,
                city,
                practiceMode,
                setting,
                paidDaysOff,
                healthInsuranceValue,
                otherBenefitsValue,
                comments);
        this.annualSalaryAndBonus=annualSalaryAndBonus;
        this.weeklyHours=weeklyHours;
        this.patientsPerWeek=patientsPerWeek;

        this.paidDaysOffValue= ((annualSalaryAndBonus/255)*paidDaysOff);
        this.normalizedAnnualComp= (annualSalaryAndBonus +healthInsuranceValue+otherBenefitsValue+paidDaysOffValue);
        this.compPerPatient = normalizedAnnualComp/(patientsPerWeek*52);
        this.compPerHour = normalizedAnnualComp/(weeklyHours*52);
    }
}
