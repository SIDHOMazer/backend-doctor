package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.ExercicePlan;
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
public class ResponseMedicamentPlan {
    Long id;
    String dosage;
    String frequence; // 2fois par jour
    String MomentOfTaking; // day,evening,night
    ResponseMedicament medicament;
    ResponsePlanDeTraitement planDeTraitement;
    Boolean status;

    Instant createdAt;
    Instant updateAt;

    public static ResponseMedicamentPlan makeMedicamentPlan(MedicamentPlan medicamentPlan ) {
        return ResponseMedicamentPlan.builder()
                .id(medicamentPlan.getId())
                .dosage(medicamentPlan.getDosage())
                .frequence(medicamentPlan.getFrequence())
                .MomentOfTaking(medicamentPlan.getMomentOfTaking())
                .medicament(ResponseMedicament.makeMedicament(medicamentPlan.getMedicament()))
                .status(medicamentPlan.getStatus())
                .createdAt(medicamentPlan.getCreatedAt())
                .updateAt(medicamentPlan.getUpdateAt())

                .build();
    }
}


