package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.PlanDeTraitement;
import com.arsii.pfe.Entities.Report;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePlanDeTraitement {
    Long id;
    String Objectif;
    String DateDebut;
    String DateFin;
    ResponsePatient patient;
    String Status;
    ResponseDocteur docteur;
    List<ResponseExercicePlan> exercicePlans;
    List<ResponseTestDeSantePlan> testDeSantePlans;
    List<ResponseMedicamentPlan> medicamentPlans;
    public static ResponsePlanDeTraitement makePlanDeTraitement( PlanDeTraitement planDeTraitement ) {
        return ResponsePlanDeTraitement.builder()
                .id(planDeTraitement.getId())
                .Objectif(planDeTraitement.getObjectif())
                .DateDebut(planDeTraitement.getDateDebut())
                .DateFin(planDeTraitement.getDateFin())
                .Status(planDeTraitement.getStatus())
                .patient(ResponsePatient.makePatientOnly(planDeTraitement.getPatient()))
                .docteur(ResponseDocteur.makeDocteur(planDeTraitement.getDocteur()))
                .exercicePlans(
                        planDeTraitement.getExercicePlans().stream().map(ResponseExercicePlan::makeExercicePlan)
                                .collect(Collectors.toList())
                )
                .medicamentPlans(
                        planDeTraitement.getMedicamentPlans().stream().map(ResponseMedicamentPlan::makeMedicamentPlan)
                                .collect(Collectors.toList())
                )
                .testDeSantePlans(
                        planDeTraitement.getTestDeSantePlans().stream().map(ResponseTestDeSantePlan::makeTestDeSantePlan)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
