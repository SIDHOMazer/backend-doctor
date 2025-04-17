package com.arsii.pfe.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestAdmin {
    Long id;
    String Lastname;
    String firstname;
    String specialite;
    String contact;
    String password;
    String email;
    String role;
    String adresse;
    String ville;
    String codePostal;
    Boolean status;


}
