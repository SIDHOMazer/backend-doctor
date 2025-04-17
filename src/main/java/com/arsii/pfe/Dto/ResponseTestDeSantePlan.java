package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.MedicamentPlan;
import com.arsii.pfe.Entities.TestDeSantePlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTestDeSantePlan {
    Long id;
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

    ResponseTestDeSante testDeSante;
    ResponsePlanDeTraitement planDeTraitement;

    public static ResponseTestDeSantePlan makeTestDeSantePlan(TestDeSantePlan testDeSantePlan ) {
        return ResponseTestDeSantePlan.builder()
                .id(testDeSantePlan.getId())
                .poids(testDeSantePlan.getPoids())
                .taille(testDeSantePlan.getTaille())
                .sexe(testDeSantePlan.getSexe())
                .fumeur(testDeSantePlan.getFumeur())
                .alcoolique(testDeSantePlan.getAlcoolique())
                .sportif(testDeSantePlan.getSportif())
                .symptomes(testDeSantePlan.getSymptomes())
                .checkbok(testDeSantePlan.getCheckbok())
                .testDeSante(ResponseTestDeSante.makeTestDeSante(testDeSantePlan.getTestDeSante()))


                .build();
    }


}


