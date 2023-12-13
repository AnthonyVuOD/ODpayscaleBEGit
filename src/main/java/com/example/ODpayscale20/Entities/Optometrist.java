package com.example.ODpayscale20.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

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

    @Column(name = "username")
    private String userName;

    @Column(name = "year_graduated")
    private Integer yearGraduated;

    @Column(name = "residency")
    private boolean residency;

    @Column(name = "initial_debt")
    private Integer initialDebt;

    //    private Genders gender;
    @Column(name = "gender")
    private String gender;
    //    private Races race;
    @Column(name = "race")
    private String race;

    @Column(name = "job_ids")
    @OneToMany(     mappedBy = "optometrist",
                    cascade = CascadeType.ALL,
                    fetch = FetchType.LAZY
    )
    private List<Job> jobs;


    public Optometrist(
                       String userName,
                       Integer yearGraduated,
                       boolean residency,
                       Integer initialDebt,
                       String gender,
                       String race,
                       List<Job> jobs) {
        this.userName=userName;
        this.yearGraduated=yearGraduated;
        this.residency=residency;
        this.initialDebt=initialDebt;
        this.gender=gender;
        this.race=race;
        this.jobs=jobs;
    }
    public Optometrist(
                       String userName,
                       Integer yearGraduated,
                       boolean residency,
                       Integer initialDebt,
                       String gender,
                       String race) {
        this.userName=userName;
        this.yearGraduated=yearGraduated;
        this.residency=residency;
        this.initialDebt=initialDebt;
        this.gender=gender;
        this.race=race;
    }
}
