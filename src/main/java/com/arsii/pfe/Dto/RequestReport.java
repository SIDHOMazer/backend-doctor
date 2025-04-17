package com.arsii.pfe.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestReport {
    Long id;
    String file;
    Long patientId;
    String Type;
    String Date;
    String Heure;
    String Description;
    String auteur;

}
