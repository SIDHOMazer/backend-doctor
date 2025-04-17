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
@Table(name = "detailreport")

public class DetailReport {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String Currenty; //Acuellement(maladie,psyclogie)
    String SurgicalHistory; // tare5 jrahy
    String TraumaHistory; //nawa3 el accident
    String HealthHistory;
    String FamilyHealthHistory;
    String Autre; //Cystite, Infection
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updateAt;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;
}