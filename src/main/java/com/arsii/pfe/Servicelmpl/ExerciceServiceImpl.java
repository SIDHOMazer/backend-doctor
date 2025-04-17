package com.arsii.pfe.Servicelmpl;

import com.arsii.pfe.Dto.RequestExercice;
import com.arsii.pfe.Dto.RequestExercicePlan;
import com.arsii.pfe.Dto.ResponseExercice;
import com.arsii.pfe.Dto.ResponseExercicePlan;
import com.arsii.pfe.Entities.Exercice;
import com.arsii.pfe.Entities.ExercicePlan;
import com.arsii.pfe.Entities.PlanDeTraitement;
import com.arsii.pfe.Repository.ExercicePlanRepository;
import com.arsii.pfe.Repository.ExerciceRepository;
import com.arsii.pfe.Repository.PlanDeTraitementRepository;
import com.arsii.pfe.Service.ExercicePlanService;
import com.arsii.pfe.Service.ExerciceService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExerciceServiceImpl implements ExerciceService {
    @Autowired
    private ExerciceRepository exerciceRepository;
    @Autowired
    private ExercicePlanRepository exercicePlanRepository;

    @Override
    public List<ResponseExercice> getAllExercice() {
        List<Exercice> exercices = exerciceRepository.findAll();
        List<ResponseExercice> exerciceFormated = new ArrayList<>();
        for (Exercice exercice : exercices) {
            ResponseExercice exercice1 = ResponseExercice.makeExercice(exercice);
           exerciceFormated.add(exercice1);
        }
        return exerciceFormated;
    }

    @Override
    public void createExercice(@NotNull RequestExercice exerciceRequest) {
        Exercice exercice = Exercice.builder()
                .NameExercice(exerciceRequest.getNameExercice())
                .NameDisease(exerciceRequest.getNameDisease())
                .description(exerciceRequest.getDescription())
                .file(exerciceRequest.getFile())

                .build();

        exerciceRepository.save(exercice);
    }


    @Override
    public ResponseExercice getExerciceById(Long id) {
        Optional<Exercice> exercice = exerciceRepository.findById(id);
        return ResponseExercice.makeExercice(exercice.get());
    }

    @Override
    public Exercice updateExercice(Long id, RequestExercice exerciceRequest) {
        Exercice exercice = exerciceRepository.findById(id).orElseThrow();
        if (exerciceRequest.getFile()!= null){
            exercice.setFile(exerciceRequest.getFile());
        }

        if (exerciceRequest.getNameExercice()!= null) {
            exercice.setNameExercice(exerciceRequest.getNameExercice());
        }
        if (exerciceRequest.getNameDisease() != null) {
            exercice.setNameDisease(exerciceRequest.getNameDisease());
        }
        if (exerciceRequest.getDescription() != null) {
            exercice.setDescription(exerciceRequest.getDescription());
        }

        return exerciceRepository.save(exercice);


    }


       @Override
   public boolean deleteExercice(Long id){
        if (!exerciceRepository.existsById(id)){
         return false;
      }
      exerciceRepository.deleteById(id);
      return true;
   }
}
