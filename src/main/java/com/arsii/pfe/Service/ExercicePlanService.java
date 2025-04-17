package com.arsii.pfe.Service;

import com.arsii.pfe.Dto.RequestExercicePlan;
import com.arsii.pfe.Dto.RequestFacture;
import com.arsii.pfe.Dto.ResponseExercicePlan;
import com.arsii.pfe.Dto.ResponseFacture;
import com.arsii.pfe.Entities.ExercicePlan;
import com.arsii.pfe.Entities.Facture;

import java.util.List;

public interface ExercicePlanService {
    List<ResponseExercicePlan> getAllExercicePlan();
    boolean deleteExercicePlan(Long id);
    void createExercicePlan(RequestExercicePlan exercicePlanRequest);
    ExercicePlan updateExercicePlan(Long id, RequestExercicePlan exercicePlanRequest);
    ResponseExercicePlan getExercicePlanById(Long id);
}

