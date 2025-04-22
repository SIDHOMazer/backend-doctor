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
@Table(name = "planDeTraitement")

public class PlanDeTraitement {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String Objectif;
    String DateDebut;
    String DateFin;
    Boolean status;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updateAt;

@ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "docteur_id")
    private Docteur docteur;
    @OneToMany(mappedBy = "planDeTraitement")
    private List<ExercicePlan> exercicePlans;
    @OneToMany(mappedBy = "planDeTraitement")
    private List<MedicamentPlan> medicamentPlans;
    @OneToMany(mappedBy = "planDeTraitement")
    private List<TestDeSantePlan> testDeSantePlans;

}