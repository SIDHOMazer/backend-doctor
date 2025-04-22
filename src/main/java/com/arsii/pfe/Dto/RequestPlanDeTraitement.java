package com.arsii.pfe.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestPlanDeTraitement {
    Long id;
    Long docteurId;
    Long patientId;
    String Objectif;
    String DateDebut;
    String DateFin;
    Boolean status;


}
