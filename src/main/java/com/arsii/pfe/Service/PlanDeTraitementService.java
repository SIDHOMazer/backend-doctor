package com.arsii.pfe.Service;

import com.arsii.pfe.Dto.RequestPlanDeTraitement;
import com.arsii.pfe.Dto.RequestReport;
import com.arsii.pfe.Dto.ResponsePlanDeTraitement;
import com.arsii.pfe.Dto.ResponseReport;
import com.arsii.pfe.Entities.PlanDeTraitement;
import com.arsii.pfe.Entities.Report;

import java.util.List;

public interface PlanDeTraitementService {
    List<ResponsePlanDeTraitement> getAllPlanDeTraitement();
    boolean deletePlanDeTraitement(Long id);
    void createPlanDeTraitement(RequestPlanDeTraitement planDeTraitementRequest);
    PlanDeTraitement updatePlanDeTraitement(Long id, RequestPlanDeTraitement planDeTraitementRequest);
    ResponsePlanDeTraitement getPlanDeTraitementById(Long id);
}

