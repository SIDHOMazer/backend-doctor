package com.arsii.pfe.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDocteur {
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


}
