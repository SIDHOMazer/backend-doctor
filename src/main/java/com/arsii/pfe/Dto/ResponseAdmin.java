package com.arsii.pfe.Dto;
import com.arsii.pfe.Entities.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ResponseAdmin {
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

    Instant createdAt;
    Instant updateAt;
    List<ResponseDocteur> docteur;

    public static ResponseAdmin makeAdmin(Admin admin){
        return ResponseAdmin.builder()
                .id(admin.getId())
                .Lastname(admin.getLastname())
                .firstname(admin.getFirstname())
                .specialite(admin.getSpecialite())
                .contact(admin.getContact())
                .password(admin.getPassword())
                .email(admin.getEmail())
                .role(admin.getRole())
                .adresse(admin.getAdresse())
                .ville(admin.getVille())
                .codePostal(admin.getCodePostal())
                .status(admin.getStatus())

                .createdAt(admin.getCreatedAt())
                .updateAt(admin.getUpdateAt())
                .build();
    }
}
