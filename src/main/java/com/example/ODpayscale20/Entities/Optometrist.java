package com.example.ODpayscale20.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="optometrists")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Optometrist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "optometrist_id")
    private Long id;

//    @Column(name = "username")
//    private String userName;

    @Column(name = "year_graduated")
    private Integer yearGraduated;

    @Column(name = "residency")
    private String residency;

    @Column(name = "initial_debt")
    private Integer initialDebt;

    //    private Genders gender;
    @Column(name = "gender")
    private String gender;
    //    private Races race;
    @Column(name = "race")
    private String race;

//    @Column(name = "job_ids")
    @OneToMany(     mappedBy = "optometrist",
                    cascade = CascadeType.ALL,
                    fetch = FetchType.EAGER
    )
    private Set<Job> jobs;


    public Optometrist(
//                       String userName,
                       Integer yearGraduated,
                       String residency,
                       Integer initialDebt,
                       String gender,
                       String race,
                       Set<Job> jobs
                                    ) {
//        this.userName=userName;
        this.yearGraduated=yearGraduated;
        this.residency=residency;
        this.initialDebt=initialDebt;
        this.gender=gender;
        this.race=race;
        this.jobs =jobs;
    }
    public Optometrist(
//                       String userName,
                       Integer yearGraduated,
                       String residency,
                       Integer initialDebt,
                       String gender,
                       String race) {
//        this.userName=userName;
        this.yearGraduated=yearGraduated;
        this.residency=residency;
        this.initialDebt=initialDebt;
        this.gender=gender;
        this.race=race;
        this.jobs=new HashSet<>();
    }
}
