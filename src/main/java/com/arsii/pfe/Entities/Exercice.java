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
@Table(name = "exercice")

public class Exercice {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String NameExercice;
    String NameDisease;
    String description;
    String file;





    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updateAt;

@ManyToOne
@JoinColumn(name = "exercice_plan_id")
private ExercicePlan exercicePlan;
}