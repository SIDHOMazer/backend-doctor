package com.arsii.pfe.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exercicePlan")

public class ExercicePlan {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String Seance;
    String SeriesAndRepetition;
    String Muscles; // DOS
    String duree; //en minute
    String jour;
    String type; //cardio, musculation, etirement


    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updateAt;

    Boolean status;

    @ManyToOne
    @JoinColumn(name = "planDeTraitement_id")
    private PlanDeTraitement planDeTraitement;
    @ManyToOne
    @JoinColumn(name = "exercice_id")
    private Exercice exercice;
}