package com.arsii.pfe.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestExercice {
    Long id;
    String NameExercice;
    String NameDisease;
    String description;
    String file;
    Boolean status;


}
