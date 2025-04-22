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
@Table(name = "test_de_sante")

public class TestDeSante {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String TestName;
    String TestDate;
    String Result;
    Boolean status;


    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updateAt;

@ManyToOne
    @JoinColumn(name = "test_de_sante_plan_id")
    private TestDeSantePlan testDeSantePlan;
}