package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.Facture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFacture {
    Long id;
    Long patientId;
    String Invoice;
    String Date;
    String Description;
    String Price;
    String QTY;
    String Total;
    String SubTotal;
    String Tax;
    String PaymentMethod;


    ResponsePatient patient;

    public static ResponseFacture makeFacture( Facture facture) {
        return ResponseFacture.builder()
                .id(facture.getId())
                .patientId(facture.getPatient().getId())
                .patient(ResponsePatient.makePatient(facture.getPatient()))
                .Invoice(facture.getInvoice())
                .Date(facture.getDate())
                .Description(facture.getDescription())
                .Price(facture.getPrice())
                .QTY(facture.getQTY())
                .Total(facture.getTotal())
                .SubTotal(facture.getSubTotal())
                .Tax(facture.getTax())
                .PaymentMethod(facture.getPaymentMethod())
                .build();
    }
}


