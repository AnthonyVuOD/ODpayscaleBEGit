package com.example.ODpayscale20.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name = "jobs")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long id;

    @Column(name = "date_created")
    private String dateCreated;

    @ManyToOne
//            (fetch = FetchType.LAZY)
    @JoinColumn(name = "optometrist_id",nullable=false)
//    @Column(name = "optometrist_id")
    private Optometrist optometrist;

    @Column(name = "year")
    private Integer year;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "practice_mode")
    private String practiceMode;

    @Column(name = "setting")
    private String setting;

    @Column(name = "weekends")
    private Boolean weekends;

    @Column(name = "paid_days_off")
    private Integer paidDaysOff;

    @Column(name = "health_insurance_value")
    private Integer healthInsuranceValue;

    @Column(name = "other_benefits_value")
    private Integer otherBenefitsValue;

    @Column(name = "comments")
    private String comments;

    @Column(name = "total_benefits_value")
    private Float totalBenefitsValue;

    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;

    public Job( String dateCreated,
                Optometrist optometrist,
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
                Integer yearsOfExperience){
        this.dateCreated=dateCreated;
        this.optometrist=optometrist;
        this.year=year;
        this.state=state;
        this.city=city;
        this.companyName=companyName;
        this.practiceMode=practiceMode;
        this.setting=setting;
        this.weekends=weekends;
        this.paidDaysOff=paidDaysOff;
        this.healthInsuranceValue=healthInsuranceValue;
        this.otherBenefitsValue=otherBenefitsValue;
        this.comments=comments;
        this.totalBenefitsValue=totalBenefitsValue;
        this.yearsOfExperience=yearsOfExperience;
    }
}
