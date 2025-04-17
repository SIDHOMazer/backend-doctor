package com.arsii.pfe.Servicelmpl;

import com.arsii.pfe.Dto.RequestPlanDeTraitement;
import com.arsii.pfe.Dto.RequestReport;
import com.arsii.pfe.Dto.ResponsePlanDeTraitement;
import com.arsii.pfe.Dto.ResponseReport;
import com.arsii.pfe.Entities.Docteur;
import com.arsii.pfe.Entities.Patient;
import com.arsii.pfe.Entities.PlanDeTraitement;
import com.arsii.pfe.Entities.Report;
import com.arsii.pfe.Repository.DocteurRepository;
import com.arsii.pfe.Repository.PatientRepository;
import com.arsii.pfe.Repository.PlanDeTraitementRepository;
import com.arsii.pfe.Repository.ReportRepository;
import com.arsii.pfe.Service.PlanDeTraitementService;
import com.arsii.pfe.Service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanDeTraitementServiceImpl implements PlanDeTraitementService {
   @Autowired
   private PlanDeTraitementRepository planDeTraitementRepository;
   @Autowired
   private PatientRepository patientRepository;
   @Autowired
   private DocteurRepository docteurRepository;

   @Override
   public List<ResponsePlanDeTraitement> getAllPlanDeTraitement(){
      List<PlanDeTraitement> planDeTraitements = planDeTraitementRepository.findAll();
      List<ResponsePlanDeTraitement> planDeTraitementsFormated = new ArrayList<>();
      for (PlanDeTraitement planDeTraitement: planDeTraitements) {
         ResponsePlanDeTraitement planDeTraitement1= ResponsePlanDeTraitement.makePlanDeTraitement(planDeTraitement);
         planDeTraitementsFormated.add(planDeTraitement1);
      }
      return planDeTraitementsFormated;
   }


   @Override
   public void createPlanDeTraitement(RequestPlanDeTraitement planDeTraitementRequest){
       Patient patient = patientRepository.findById(planDeTraitementRequest.getPatientId()).orElseThrow();
       Docteur docteur = docteurRepository.findById(planDeTraitementRequest.getDocteurId()).orElseThrow();

       PlanDeTraitement planDeTraitement = PlanDeTraitement.builder()
               .docteur(docteur)
                .patient(patient)
                .Objectif(planDeTraitementRequest.getObjectif())
                .DateDebut(planDeTraitementRequest.getDateDebut())
                .DateFin(planDeTraitementRequest.getDateFin())
                .Status(planDeTraitementRequest.getStatus())

               .build();

      planDeTraitementRepository.save(planDeTraitement);

   }


   @Override
   public ResponsePlanDeTraitement getPlanDeTraitementById(Long id){
      Optional<PlanDeTraitement> planDeTraitement = planDeTraitementRepository.findById(id);
      return ResponsePlanDeTraitement.makePlanDeTraitement(planDeTraitement.get());
   }
   @Override
   public PlanDeTraitement updatePlanDeTraitement(Long id, RequestPlanDeTraitement planDeTraitementRequest ) {
      PlanDeTraitement planDeTraitement = planDeTraitementRepository.findById(id).orElseThrow();

       if (planDeTraitementRequest.getObjectif() != null) {
           planDeTraitement.setObjectif(planDeTraitementRequest.getObjectif());
       }
         if (planDeTraitementRequest.getDateDebut() != null) {
              planDeTraitement.setDateDebut(planDeTraitementRequest.getDateDebut());
         }
            if (planDeTraitementRequest.getDateFin() != null) {
                planDeTraitement.setDateFin(planDeTraitementRequest.getDateFin());
            }
            if (planDeTraitementRequest.getStatus() != null) {
                planDeTraitement.setStatus(planDeTraitementRequest.getStatus());
            }
        return planDeTraitementRepository.save(planDeTraitement);

   }
   @Override
   public boolean deletePlanDeTraitement(Long id){
      if (!planDeTraitementRepository.existsById(id)){
         return false;
      }
      planDeTraitementRepository.deleteById(id);
      return true;
   }
}
