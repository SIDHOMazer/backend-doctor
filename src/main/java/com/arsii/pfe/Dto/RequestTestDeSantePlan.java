package com.arsii.pfe.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestTestDeSantePlan {
    Long id;
    Long plandeTraitementId;
    Long testDeSanteId;
    String lastname;
    String firstname;
    LocalDate dateNaissance;
    Double poids;
    Double taille;
    String sexe;
    Boolean fumeur;
    Boolean alcoolique;
    Boolean sportif;
    String symptomes;
    String checkbok ;
    String titre;
    String description;
    String file;
    String date;
    Boolean status;


}
