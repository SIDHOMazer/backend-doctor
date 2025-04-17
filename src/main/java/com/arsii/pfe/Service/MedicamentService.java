package com.arsii.pfe.Service;

import com.arsii.pfe.Dto.RequestMedicament;
import com.arsii.pfe.Dto.RequestMedicamentPlan;
import com.arsii.pfe.Dto.ResponseMedicament;
import com.arsii.pfe.Dto.ResponseMedicamentPlan;
import com.arsii.pfe.Entities.Medicament;
import com.arsii.pfe.Entities.MedicamentPlan;

import java.util.List;

public interface MedicamentService {

    List<ResponseMedicament> getAllMedicament();
    boolean deleteMedicament(Long id);
    void createMedicament(RequestMedicament medicamentRequest);
    Medicament updateMedicament(Long id, RequestMedicament medicamentRequest);
    ResponseMedicament getMedicamentById(Long id);
}

