package com.arsii.pfe.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestPatient {
    Long id;
    String Lastname;
    String firstname;
    String DateNaissance;
    String HistoriqueMedical;
    String contact;
    String password;
    String email;
    String adresse;
    String ville;
    String codePostal;
    String sexe;
    Boolean status;
}
