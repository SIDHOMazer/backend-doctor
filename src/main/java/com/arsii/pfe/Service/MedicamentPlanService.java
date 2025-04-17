package com.arsii.pfe.Service;

import com.arsii.pfe.Dto.RequestExercicePlan;
import com.arsii.pfe.Dto.RequestMedicamentPlan;
import com.arsii.pfe.Dto.ResponseExercicePlan;
import com.arsii.pfe.Dto.ResponseMedicamentPlan;
import com.arsii.pfe.Entities.ExercicePlan;
import com.arsii.pfe.Entities.MedicamentPlan;

import java.util.List;

public interface MedicamentPlanService {

    List<ResponseMedicamentPlan> getAllMedicamentPlan();
    boolean deleteMedicamentPlan(Long id);
    void createMedicamentPlan(RequestMedicamentPlan medicamentPlanRequest);
    MedicamentPlan updateMedicamentPlan(Long id, RequestMedicamentPlan medicamentPlanRequest);
    ResponseMedicamentPlan getMedicamentPlanById(Long id);
}

