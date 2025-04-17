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
@Table(name = "admin")

public class Admin  {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String Lastname;
    String firstname;
    String contact;
    String password;
    String email;
    String role;
    String adresse;
    String ville;
    String codePostal;
    String specialite;
    Boolean status;


    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updateAt;

}