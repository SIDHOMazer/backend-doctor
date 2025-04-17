package com.arsii.pfe.Servicelmpl;

import com.arsii.pfe.Dto.RequestExercicePlan;
import com.arsii.pfe.Dto.RequestMedicamentPlan;
import com.arsii.pfe.Dto.ResponseExercicePlan;
import com.arsii.pfe.Dto.ResponseMedicamentPlan;
import com.arsii.pfe.Entities.ExercicePlan;
import com.arsii.pfe.Entities.Medicament;
import com.arsii.pfe.Entities.MedicamentPlan;
import com.arsii.pfe.Entities.PlanDeTraitement;
import com.arsii.pfe.Repository.ExercicePlanRepository;
import com.arsii.pfe.Repository.MedicamentPlanRepository;
import com.arsii.pfe.Repository.MedicamentRepository;
import com.arsii.pfe.Repository.PlanDeTraitementRepository;
import com.arsii.pfe.Service.ExercicePlanService;
import com.arsii.pfe.Service.MedicamentPlanService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicamentPlanServiceImpl implements MedicamentPlanService {
    @Autowired
    private MedicamentPlanRepository medicamentPlanRepository;
    @Autowired
    private PlanDeTraitementRepository planDeTraitementRepository;
    @Autowired
    private MedicamentRepository medicamentRepository;

    @Override
    public List<ResponseMedicamentPlan> getAllMedicamentPlan() {
        List<MedicamentPlan> medicamentPlans = medicamentPlanRepository.findAll();
        List<ResponseMedicamentPlan> medicamentPlansFormated = new ArrayList<>();
        for (MedicamentPlan medicamentPlan : medicamentPlans) {
            ResponseMedicamentPlan medicamentPlan1 = ResponseMedicamentPlan.makeMedicamentPlan(medicamentPlan);
           medicamentPlansFormated.add(medicamentPlan1);
        }
        return medicamentPlansFormated;
    }

    @Override
    public void createMedicamentPlan(@NotNull RequestMedicamentPlan medicamentPlanRequest) {
        PlanDeTraitement planDeTraitement = planDeTraitementRepository.findById(medicamentPlanRequest.getPlandeTraitementId()).orElseThrow();
        Medicament medicament = medicamentRepository.findById(medicamentPlanRequest.getMedicamentId()).orElseThrow();
        MedicamentPlan medicamentPlan = MedicamentPlan.builder()
                .planDeTraitement(planDeTraitement)
                .medicament(medicament)
                .dosage(medicamentPlanRequest.getDosage())
                .frequence(medicamentPlanRequest.getFrequence())
                .MomentOfTaking(medicamentPlanRequest.getMomentOfTaking())
                .build();

        medicamentPlanRepository.save(medicamentPlan);
    }


    @Override
    public ResponseMedicamentPlan getMedicamentPlanById(Long id) {
        Optional<MedicamentPlan> medicamentPlan = medicamentPlanRepository.findById(id);
        return ResponseMedicamentPlan.makeMedicamentPlan(medicamentPlan.get());
    }

    @Override
    public MedicamentPlan updateMedicamentPlan(Long id, RequestMedicamentPlan medicamentPlanRequest) {
        MedicamentPlan medicamentPlan = medicamentPlanRepository.findById(id).orElseThrow();
        if (medicamentPlanRequest.getPlandeTraitementId() != null) {
            medicamentPlan.setPlandeTraitementId(medicamentPlan.getPlandeTraitementId());
        }

        if (medicamentPlanRequest.getDosage() != null) {
            medicamentPlan.setDosage(medicamentPlanRequest.getDosage());
        }
        if (medicamentPlanRequest.getFrequence() != null) {
            medicamentPlan.setFrequence(medicamentPlanRequest.getFrequence());
        }
        if (medicamentPlanRequest.getMomentOfTaking() != null) {
            medicamentPlan.setMomentOfTaking(medicamentPlanRequest.getMomentOfTaking());
        }


         return  medicamentPlanRepository.save(medicamentPlan);

    }


       @Override
   public boolean deleteMedicamentPlan(Long id){
        if (!medicamentPlanRepository.existsById(id)){
         return false;
      }
      medicamentPlanRepository.deleteById(id);
      return true;
   }
}
