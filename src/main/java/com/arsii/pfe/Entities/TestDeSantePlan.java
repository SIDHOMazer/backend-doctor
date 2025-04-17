package com.arsii.pfe.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "test_de_sante_plan")

public class TestDeSantePlan {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Double poids;
    Double taille;
    String sexe;
    Boolean fumeur;
    Boolean alcoolique;
    Boolean sportif;
    String symptomes;
    String checkbok ;



    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updateAt;

@ManyToOne
    @JoinColumn(name = "planDeTraitement_id")
    private PlanDeTraitement planDeTraitement;
    @ManyToOne
    @JoinColumn(name = "testDeSante_id")
    private TestDeSante testDeSante;
}