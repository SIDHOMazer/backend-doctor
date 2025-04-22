package com.arsii.pfe.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestRendezvous {
    Long id;
    Long patientId;
    Long docteurId;
    String date;
    String statut;
    String acceptDate;
    String rejectDate;
    String NameCompany;
    Boolean status;




}
