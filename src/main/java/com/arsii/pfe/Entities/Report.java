package com.arsii.pfe.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "report")

public class Report {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
   String file;
    String Type;
    String Date;
    String Heure;
    String Description;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updateAt;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    @OneToMany(mappedBy = "report")
    private List<DetailReport> detailReports;

}