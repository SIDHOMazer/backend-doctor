package com.arsii.pfe.Servicelmpl;

import com.arsii.pfe.Dto.RequestMedicament;
import com.arsii.pfe.Dto.RequestMedicamentPlan;
import com.arsii.pfe.Dto.ResponseMedicament;
import com.arsii.pfe.Dto.ResponseMedicamentPlan;
import com.arsii.pfe.Entities.Medicament;
import com.arsii.pfe.Entities.MedicamentPlan;
import com.arsii.pfe.Entities.PlanDeTraitement;
import com.arsii.pfe.Repository.MedicamentPlanRepository;
import com.arsii.pfe.Repository.MedicamentRepository;
import com.arsii.pfe.Repository.PlanDeTraitementRepository;
import com.arsii.pfe.Service.MedicamentPlanService;
import com.arsii.pfe.Service.MedicamentService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicamentServiceImpl implements MedicamentService {
    @Autowired
    private MedicamentRepository medicamentRepository;
    @Autowired
    private MedicamentPlanRepository medicamentPlanRepository;

    @Override
    public List<ResponseMedicament> getAllMedicament() {
        List<Medicament> medicaments = medicamentRepository.findAll();
        List<ResponseMedicament> medicamentFormated = new ArrayList<>();
        for (Medicament medicament : medicaments) {
            ResponseMedicament medicament1 = ResponseMedicament.makeMedicament(medicament);
           medicamentFormated.add(medicament1);
        }
        return medicamentFormated;
    }

    @Override
    public void createMedicament(@NotNull RequestMedicament medicamentRequest) {
        Medicament medicament = Medicament.builder()
                .medicament(medicamentRequest.getMedicament())
                .note(medicamentRequest.getNote())
                .file(medicamentRequest.getFile())
                .status(true)

                .build();

        medicamentRepository.save(medicament);
    }


    @Override
    public ResponseMedicament getMedicamentById(Long id) {
        Optional<Medicament> medicament = medicamentRepository.findById(id);
        return ResponseMedicament.makeMedicament(medicament.get());
    }

    @Override
    public Medicament updateMedicament(Long id, RequestMedicament medicamentRequest) {
        Medicament medicament = medicamentRepository.findById(id).orElseThrow();
        if (medicamentRequest.getMedicament() != null) {
            medicament.setMedicament(medicamentRequest.getMedicament());
        }

        if (medicamentRequest.getNote() != null) {
            medicament.setNote(medicamentRequest.getNote());
        }
        if (medicamentRequest.getFile() != null) {
            medicament.setFile(medicamentRequest.getFile());
        }
        if (medicamentRequest.getStatus() != null) {
            medicament.setStatus(medicamentRequest.getStatus());
        }
       return medicamentRepository.save(medicament);


    }


       @Override
   public boolean deleteMedicament(Long id){
        if (!medicamentRepository.existsById(id)){
         return false;
      }
      medicamentRepository.deleteById(id);
      return true;
   }
}
