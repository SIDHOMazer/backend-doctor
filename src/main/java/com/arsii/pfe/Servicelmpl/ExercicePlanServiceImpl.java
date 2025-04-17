package com.arsii.pfe.Servicelmpl;

import com.arsii.pfe.Dto.RequestExercicePlan;
import com.arsii.pfe.Dto.RequestFacture;
import com.arsii.pfe.Dto.ResponseExercicePlan;
import com.arsii.pfe.Dto.ResponseFacture;
import com.arsii.pfe.Entities.*;
import com.arsii.pfe.Repository.*;
import com.arsii.pfe.Service.ExercicePlanService;
import com.arsii.pfe.Service.FactureService;
import com.arsii.pfe.Service.PlanDeTraitementService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExercicePlanServiceImpl implements ExercicePlanService {
    @Autowired
    private ExercicePlanRepository exercicePlanRepository;
    @Autowired
    private PlanDeTraitementRepository planDeTraitementRepository;
     @Autowired
     private ExerciceRepository exerciceRepository;


    @Override
    public List<ResponseExercicePlan> getAllExercicePlan() {
        List<ExercicePlan> exercicePlans = exercicePlanRepository.findAll();
        List<ResponseExercicePlan> exercicePlanFormated = new ArrayList<>();
        for (ExercicePlan exercicePlan : exercicePlans) {
            ResponseExercicePlan exercicePlan1 = ResponseExercicePlan.makeExercicePlan(exercicePlan);
           exercicePlanFormated.add(exercicePlan1);
        }
        return exercicePlanFormated;
    }

    @Override
    public void createExercicePlan(@NotNull RequestExercicePlan exercicePlanRequest) {
        PlanDeTraitement planDeTraitement = planDeTraitementRepository.findById(exercicePlanRequest.getPlandeTraitementId()).orElseThrow();
        Exercice exercice = exerciceRepository.findById(exercicePlanRequest.getExerciceId()).orElseThrow();

        ExercicePlan exercicePlan = ExercicePlan.builder()
                .planDeTraitement(planDeTraitement)
                .exercice(exercice)
                .Seance(exercicePlanRequest.getSeance())
                .SeriesAndRepetition(exercicePlanRequest.getSeriesAndRepetition())
                .duree(exercicePlanRequest.getDuree())
                .jour(exercicePlanRequest.getJour())
                .type(exercicePlanRequest.getType())
                .Muscles(exercicePlanRequest.getMuscles())
                .build();

        exercicePlanRepository.save(exercicePlan);
    }


    @Override
    public ResponseExercicePlan getExercicePlanById(Long id) {
        Optional<ExercicePlan> exercicePlan = exercicePlanRepository.findById(id);
        return ResponseExercicePlan.makeExercicePlan(exercicePlan.get());
    }

    @Override
    public ExercicePlan updateExercicePlan(Long id, RequestExercicePlan exercicePlanRequest) {
        ExercicePlan exercicePlan = exercicePlanRepository.findById(id).orElseThrow();


        if (exercicePlanRequest.getSeance() != null) {
            exercicePlan.setSeance(exercicePlanRequest.getSeance());
        }
        if (exercicePlanRequest.getSeriesAndRepetition() != null) {
            exercicePlan.setSeriesAndRepetition(exercicePlanRequest.getSeriesAndRepetition());
        }
        if (exercicePlanRequest.getDuree() != null) {
            exercicePlan.setDuree(exercicePlanRequest.getDuree());
        }
        if (exercicePlanRequest.getMuscles() != null) {
            exercicePlan.setMuscles(exercicePlanRequest.getMuscles());
        }


        if (exercicePlanRequest.getJour() != null) {
            exercicePlan.setJour(exercicePlanRequest.getJour());
        }

        if (exercicePlanRequest.getType() != null) {
            exercicePlan.setType(exercicePlanRequest.getType());
        }

         return  exercicePlanRepository.save(exercicePlan);

    }


       @Override
   public boolean deleteExercicePlan(Long id){
        if (!exercicePlanRepository.existsById(id)){
         return false;
      }
      exercicePlanRepository.deleteById(id);
      return true;
   }
}
