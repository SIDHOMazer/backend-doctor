package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.ExercicePlan;
import com.arsii.pfe.Entities.Facture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseExercicePlan {
    Long id;
    String Seance;
    String SeriesAndRepetition;
    String Muscles; // DOS
    String duree; //en minute
    String jour;
    String type; //cardio, musculation, etirement
    ResponseExercice exercice;

    ResponsePlanDeTraitement planDeTraitement;
    Instant createdAt;
    Instant updateAt;
    Boolean status;

    public static ResponseExercicePlan makeExercicePlan (ExercicePlan exercicePlan ) {
        return ResponseExercicePlan.builder()
                .id(exercicePlan.getId())
                .Seance(exercicePlan.getSeance())
                .SeriesAndRepetition(exercicePlan.getSeriesAndRepetition())
                .duree(exercicePlan.getDuree())
                .Muscles(exercicePlan.getMuscles())
                .jour(exercicePlan.getJour())
                .type(exercicePlan.getType())
                .createdAt(exercicePlan.getCreatedAt())
                .updateAt(exercicePlan.getUpdateAt())
                .status(exercicePlan.getStatus())
                .exercice(ResponseExercice.makeExercice(exercicePlan.getExercice()))

                .build();
    }
}


