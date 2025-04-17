package com.arsii.pfe.Service;

import com.arsii.pfe.Dto.RequestExercice;
import com.arsii.pfe.Dto.RequestExercicePlan;
import com.arsii.pfe.Dto.ResponseExercice;
import com.arsii.pfe.Dto.ResponseExercicePlan;
import com.arsii.pfe.Entities.Exercice;
import com.arsii.pfe.Entities.ExercicePlan;

import java.util.List;

public interface ExerciceService {
    List<ResponseExercice> getAllExercice();
    boolean deleteExercice(Long id);
    void createExercice(RequestExercice exerciceRequest);
    Exercice updateExercice(Long id, RequestExercice exerciceRequest);
    ResponseExercice  getExerciceById(Long id);
}

