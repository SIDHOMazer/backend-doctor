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
@Table(name = "patient")

public class Patient {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String Lastname;
    String firstname;
    String contact;
    String password;
    String email;
    String adresse;
    String ville;
    String codePostal;
    String role;
    String sexe;
    String HistoriqueMedical;
    String Age;
    String DateNaissance;
    Boolean status;



    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updateAt;

@OneToMany(mappedBy = "patient")
    private List<Report> reports;

    @OneToMany(mappedBy = "patient")
    private List<Rendezvous> rendezvous;
}