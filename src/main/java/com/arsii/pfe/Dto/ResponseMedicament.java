package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.Medicament;
import com.arsii.pfe.Entities.MedicamentPlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMedicament {
    Long id;
    String medicament;
    String note;
    String file;
    Boolean status;

    Instant createdAt;
    Instant updateAt;


    ResponseMedicamentPlan medicamentPlan;

    public static ResponseMedicament makeMedicament(Medicament medicament ) {
        return ResponseMedicament.builder()
                .id(medicament.getId())
                .medicament(medicament.getMedicament())
                .status(medicament.getStatus())
                .createdAt(medicament.getCreatedAt())
                .updateAt(medicament.getUpdateAt())
                .note(medicament.getNote())
                .file(medicament.getFile())


                .build();
    }
}


