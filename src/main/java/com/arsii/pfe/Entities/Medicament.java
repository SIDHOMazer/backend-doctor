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
@Table(name = "medicament")

public class Medicament {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String medicament;
    String note;
    String file;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updateAt;

@ManyToOne
    @JoinColumn(name = "medicament_plan_id")
    private MedicamentPlan medicamentPlan;

}