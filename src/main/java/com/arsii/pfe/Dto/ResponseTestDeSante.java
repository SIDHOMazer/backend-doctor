package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.TestDeSante;
import com.arsii.pfe.Entities.TestDeSantePlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTestDeSante {
    Long id;
    String TestName;
    String TestDate;
    String Result;
    Boolean status;

    Instant createdAt;
    Instant updateAt;

    ResponseTestDeSantePlan testDeSantePlan;

    public static ResponseTestDeSante makeTestDeSante(TestDeSante testDeSante ) {
        return ResponseTestDeSante.builder()
                .id(testDeSante.getId())
                .TestName(testDeSante.getTestName())
                .TestDate(testDeSante.getTestDate())
                .Result(testDeSante.getResult())
                .status(testDeSante.getStatus())
                .createdAt(testDeSante.getCreatedAt())
                .updateAt(testDeSante.getUpdateAt())



                .build();
    }


}


