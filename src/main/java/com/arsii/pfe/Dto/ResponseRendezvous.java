package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.Facture;
import com.arsii.pfe.Entities.Rendezvous;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRendezvous {
    Long id;
    Long patientId;
    String date;
    String statut;
    String acceptDate;
    String rejectDate;
    String NameCompany;

    ResponseDocteur docteur;

    ResponsePatient patient;

    public static ResponseRendezvous makeRendezvous(Rendezvous rendezvous) {
        return ResponseRendezvous.builder()
                .id(rendezvous.getId())
                .patient(ResponsePatient.makePatient(rendezvous.getPatient()))
                .docteur(ResponseDocteur.makeDocteur(rendezvous.getDocteur()))
                .date(rendezvous.getDate())
                .statut(rendezvous.getStatut())
                .acceptDate(rendezvous.getAcceptDate())
                .rejectDate(rendezvous.getRejectDate())
                .NameCompany(rendezvous.getNameCompany())

                .build();
    }
}


