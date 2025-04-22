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
@Table(name = "rendezvous")

public class Rendezvous {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String date; //jour,moin,annee
    String statut;
    String acceptDate;
    String rejectDate;
    String NameCompany;
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
}
