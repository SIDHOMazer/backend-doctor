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
@Table(name = "medicament_plan")

public class MedicamentPlan {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long plandeTraitementId;
    String dosage;
    String frequence; // 2fois par jour
    String MomentOfTaking; // day,evening,night

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updateAt;

@ManyToOne
    @JoinColumn(name = "planDeTraitement_id")
    private PlanDeTraitement planDeTraitement;
    @ManyToOne
    @JoinColumn(name = "medicament_id")
    private Medicament medicament;
}