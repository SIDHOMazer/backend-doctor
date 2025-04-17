package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePatient {
    Long id;
    String Lastname;
    String firstname;
    String HistoriqueMedical;
    String contact;
    String password;
    String email;
    String adresse;
    String ville;
    String codePostal;
    String role;
    String sexe;
    String DateNaissance;
    Boolean status;

    Instant createdAt;
    Instant updateAt;

    List<ResponseReport> reports;


    public static ResponsePatient makePatient(Patient patient){
        return ResponsePatient.builder()
                .id(patient.getId())
                .DateNaissance(patient.getDateNaissance())
                .HistoriqueMedical(patient.getHistoriqueMedical())
                .Lastname(patient.getLastname())
                .firstname(patient.getFirstname())
                .contact(patient.getContact())
                .password(patient.getPassword())
                .email(patient.getEmail())
                .adresse(patient.getAdresse())
                .ville(patient.getVille())
                .codePostal(patient.getCodePostal())
                .sexe(patient.getSexe())
                .createdAt(patient.getCreatedAt())
                .updateAt(patient.getUpdateAt())
                .reports(
                        patient.getReports().stream().map(ResponseReport::makeReport)
                                .collect(Collectors.toList())
                )
                .build();
    }

    public static ResponsePatient makePatientOnly(Patient patient){
        return ResponsePatient.builder()
                .id(patient.getId())
                .DateNaissance(patient.getDateNaissance())
                .HistoriqueMedical(patient.getHistoriqueMedical())
                .Lastname(patient.getLastname())
                .firstname(patient.getFirstname())
                .contact(patient.getContact())
                .password(patient.getPassword())
                .email(patient.getEmail())
                .adresse(patient.getAdresse())
                .ville(patient.getVille())
                .codePostal(patient.getCodePostal())
                .sexe(patient.getSexe())
                .status(patient.getStatus())
                .createdAt(patient.getCreatedAt())
                .updateAt(patient.getUpdateAt())

                .build();
    }
}
