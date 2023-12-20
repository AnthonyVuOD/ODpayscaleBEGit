package com.example.ODpayscale20.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Primary;

import java.util.Date;
import java.util.Optional;

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

    @CreationTimestamp
    @Column(name = "date_created")
    private Date dateCreated;

    @ManyToOne(fetch = FetchType.EAGER,
                cascade = CascadeType.ALL)
    @JoinColumn(name = "optometrist_id")
//    @Column(name = "optometrist_id")
    private Optometrist optometrist;

    @Column(name = "year")
    private Integer year;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "practice_mode")
    private String practiceMode;

    @Column(name = "setting")
    private String setting;

    @Column(name = "paid_days_off")
    private Integer paidDaysOff;

    @Column(name = "health_insurance_value")
    private Integer healthInsuranceValue;

    @Column(name = "other_benefits_value")
    private Integer otherBenefitsValue;

    @Column(name = "comments")
    private String comments;

    @Column(name = "total_benefits_value")
    private Integer totalBenefitsValue;

    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;

    public Job( Optometrist optometrist,
                Integer year,
                String state,
                String city,
                String practiceMode,
                String setting,
                Integer paidDaysOff,
                Integer healthInsuranceValue,
                Integer otherBenefitsValue,
                String comments
        ){
        this.optometrist=optometrist;
        this.year=year;
        this.state=state;
        this.city=city;
        this.practiceMode=practiceMode;
        this.setting=setting;
        this.paidDaysOff=paidDaysOff;
        this.healthInsuranceValue=healthInsuranceValue;
        this.otherBenefitsValue=otherBenefitsValue;
        this.comments=comments;
        this.totalBenefitsValue = healthInsuranceValue+otherBenefitsValue;
        // fixed
        this.yearsOfExperience = year - optometrist.getYearGraduated();

    }
}
