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
public class RequestExercicePlan {
    Long id;
    Long exerciceId;
    Long plandeTraitementId;
    String Seance;
    String SeriesAndRepetition;
    String Muscles; // DOS
    String duree; //en minute
    String jour;
    String type; //cardio, musculation, etirement

}
