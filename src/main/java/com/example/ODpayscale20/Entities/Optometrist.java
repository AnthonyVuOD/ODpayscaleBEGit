package com.example.ODpayscale20.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
//@AllArgsConstructor
@NoArgsConstructor
public class Optometrist {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "optometrist_id")
    private String id;

    @Column(name = "year_graduated")
    private Integer yearGraduated;

    @Column(name = "residency")
    private String residency;

    @Column(name = "initial_debt")
    private Integer initialDebt;

    @Column(name = "gender")
    private String gender;

    @Column(name = "race")
    private String race;

//  No "jobs column"
    @OneToMany(     mappedBy = "optometrist",
                    cascade = CascadeType.ALL,
                    fetch =FetchType.LAZY
                                    //Maybe EAGER
    )
    // Prevents recursion
    @JsonIgnore
    private Set<Job> jobs;


    public Optometrist(
                       String id,
                       Integer yearGraduated,
                       String residency,
                       Integer initialDebt,
                       String gender,
                       String race,
                       Set<Job> jobs
                                    ) {
        this.id=id;
        this.yearGraduated=yearGraduated;
        this.residency=residency;
        this.initialDebt=initialDebt;
        this.gender=gender;
        this.race=race;
        this.jobs =jobs;
    }
    public Optometrist(
                       String id,
                       Integer yearGraduated,
                       String residency,
                       Integer initialDebt,
                       String gender,
                       String race) {
        this.id=id;
        this.yearGraduated=yearGraduated;
        this.residency=residency;
        this.initialDebt=initialDebt;
        this.gender=gender;
        this.race=race;
        this.jobs=new HashSet<>();
    }
}
