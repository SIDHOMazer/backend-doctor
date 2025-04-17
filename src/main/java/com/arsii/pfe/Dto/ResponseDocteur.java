package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.Docteur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDocteur {
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
    Boolean status;

    String Localisation;
    Instant createdAt;
    Instant updateAt;

    public static ResponseDocteur makeDocteur(Docteur docteur){
        return ResponseDocteur.builder()
                .id(docteur.getId())
                .specialite(docteur.getSpecialite())
                .contact(docteur.getContact())
                .password(docteur.getPassword())
                .email(docteur.getEmail())
                .adresse(docteur.getAdresse())
                .ville(docteur.getVille())
                .codePostal(docteur.getCodePostal())
                .Lastname(docteur.getLastname())
                .firstname(docteur.getFirstname())
                .sexe(docteur.getSexe())
                .Localisation(docteur.getLocalisation())
                .status(docteur.getStatus())
                .createdAt(docteur.getCreatedAt())
                .updateAt(docteur.getUpdateAt())
                .build();
    }


}
