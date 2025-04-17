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
@Table(name = "docteur")

public class Docteur {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String Lastname;
    String firstname;
    String specialite;
    String contact;
    String password;
    String email;
    String adresse;
    String ville;
    String codePostal;
    String sexe;
    String Localisation;
    Boolean status;
    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updateAt;


    @OneToMany(mappedBy = "docteur")
    private List<Rendezvous> rendezvous;
    @OneToMany(mappedBy = "docteur")
    private List<PlanDeTraitement> planDeTraitements;

}