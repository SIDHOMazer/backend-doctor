package com.arsii.pfe.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facture")

public class Facture {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String Invoice;
    String Date;
    String Description;
    String Price;
    String QTY;
    String Total;
    String SubTotal;
    String Tax;
    String PaymentMethod;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updateAt;

@ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}