package com.arsii.pfe.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestMedicamentPlan {
    Long id;
    Long medicamentId;
    Long plandeTraitementId;
    String dosage;
    String frequence; // 2fois par jour
    String MomentOfTaking; // day,evening,night

    Boolean status;

}
