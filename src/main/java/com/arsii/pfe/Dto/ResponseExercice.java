package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.Exercice;
import com.arsii.pfe.Entities.ExercicePlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

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
    Boolean status;

    Instant createdAt;
    Instant updateAt;

    public static ResponseExercice makeExercice(Exercice exercice) {
        return ResponseExercice.builder()
                .id(exercice.getId())
                .NameExercice(exercice.getNameExercice())
                .NameDisease(exercice.getNameDisease())
                .status(exercice.getStatus())
                .createdAt(exercice.getCreatedAt())
                .updateAt(exercice.getUpdateAt())
                .description(exercice.getDescription())
                .file(exercice.getFile())

                .build();
    }
}


