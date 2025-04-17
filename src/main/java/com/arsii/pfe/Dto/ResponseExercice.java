package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.Exercice;
import com.arsii.pfe.Entities.ExercicePlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseExercice {
    Long id;
    String NameExercice;
    String NameDisease;
    String description;
    String file;


    public static ResponseExercice makeExercice(Exercice exercice) {
        return ResponseExercice.builder()
                .id(exercice.getId())
                .NameExercice(exercice.getNameExercice())
                .NameDisease(exercice.getNameDisease())
                .description(exercice.getDescription())
                .file(exercice.getFile())

                .build();
    }
}


