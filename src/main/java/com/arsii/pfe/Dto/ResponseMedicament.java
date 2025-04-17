package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.Medicament;
import com.arsii.pfe.Entities.MedicamentPlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMedicament {
    Long id;
    String medicament;
    String note;
    String file;


    ResponseMedicamentPlan medicamentPlan;

    public static ResponseMedicament makeMedicament(Medicament medicament ) {
        return ResponseMedicament.builder()
                .id(medicament.getId())
                .medicament(medicament.getMedicament())

                .note(medicament.getNote())
                .file(medicament.getFile())


                .build();
    }
}


