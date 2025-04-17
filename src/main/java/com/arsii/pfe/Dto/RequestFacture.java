package com.arsii.pfe.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestFacture {
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



}
