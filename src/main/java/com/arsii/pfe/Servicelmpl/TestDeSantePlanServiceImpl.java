package com.arsii.pfe.Servicelmpl;

import com.arsii.pfe.Dto.RequestTestDeSantePlan;
import com.arsii.pfe.Dto.ResponseTestDeSantePlan;
import com.arsii.pfe.Entities.PlanDeTraitement;
import com.arsii.pfe.Entities.TestDeSante;
import com.arsii.pfe.Entities.TestDeSantePlan;
import com.arsii.pfe.Repository.PlanDeTraitementRepository;
import com.arsii.pfe.Repository.TestDeSantePlanRepository;
import com.arsii.pfe.Repository.TestDeSanteRepository;
import com.arsii.pfe.Service.TestDeSantePlanService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestDeSantePlanServiceImpl implements TestDeSantePlanService{
    @Autowired
    private TestDeSantePlanRepository testDeSantePlanRepository;
    @Autowired
    private PlanDeTraitementRepository planDeTraitementRepository;
    @Autowired
    private TestDeSanteRepository testDeSanteRepository;

    @Override
    public List<ResponseTestDeSantePlan> getAllTestDeSantePlan() {
        List<TestDeSantePlan> testDeSantePlans = testDeSantePlanRepository.findAll();
        List<ResponseTestDeSantePlan> testDeSantePlansFormated = new ArrayList<>();
        for (TestDeSantePlan testDeSantePlan : testDeSantePlans) {
            ResponseTestDeSantePlan testDeSantePlan1 = ResponseTestDeSantePlan.makeTestDeSantePlan(testDeSantePlan);
           testDeSantePlansFormated.add(testDeSantePlan1);
        }
        return testDeSantePlansFormated;
    }

    @Override
    public void createTestDeSantePlan(@NotNull RequestTestDeSantePlan testDeSantePlanRequest) {
        PlanDeTraitement planDeTraitement = planDeTraitementRepository.findById(testDeSantePlanRequest.getPlandeTraitementId()).orElseThrow();
        TestDeSante testDeSante = testDeSanteRepository.findById(testDeSantePlanRequest.getTestDeSanteId()).orElseThrow();
        TestDeSantePlan testDeSantePlan = TestDeSantePlan.builder()
                .planDeTraitement(planDeTraitement)
                .testDeSante(testDeSante)
                .poids(testDeSantePlanRequest.getPoids())
                .taille(testDeSantePlanRequest.getTaille())
                .sexe(testDeSantePlanRequest.getSexe())
                .fumeur(testDeSantePlanRequest.getFumeur())
                .alcoolique(testDeSantePlanRequest.getAlcoolique())
                .sportif(testDeSantePlanRequest.getSportif())
                .symptomes(testDeSantePlanRequest.getSymptomes())
                .checkbok(testDeSantePlanRequest.getCheckbok())
                .status(true)
                .build();

        testDeSantePlanRepository.save(testDeSantePlan);
    }


    @Override
    public ResponseTestDeSantePlan getTestDeSantePlanById(Long id) {
        Optional<TestDeSantePlan> testDeSantePlan = testDeSantePlanRepository.findById(id);
        return ResponseTestDeSantePlan.makeTestDeSantePlan(testDeSantePlan.get());
    }

    @Override
    public TestDeSantePlan updateTestDeSantePlan(Long id, RequestTestDeSantePlan testDeSantePlanRequest) {
        TestDeSantePlan testDeSantePlan = testDeSantePlanRepository.findById(id).orElseThrow();
        if (testDeSantePlanRequest.getPlandeTraitementId() != null) {
            testDeSantePlan.setPlanDeTraitement(testDeSantePlan.getPlanDeTraitement());
        }

        if (testDeSantePlanRequest.getPoids() != null) {
            testDeSantePlan.setPoids(testDeSantePlanRequest.getPoids());
        }
        if (testDeSantePlanRequest.getTaille() != null) {
            testDeSantePlan.setTaille(testDeSantePlanRequest.getTaille());
        }
        if (testDeSantePlanRequest.getSexe() != null) {
            testDeSantePlan.setSexe(testDeSantePlanRequest.getSexe());
        }
        if (testDeSantePlanRequest.getFumeur() != null) {
            testDeSantePlan.setFumeur(testDeSantePlanRequest.getFumeur());
        }
        if (testDeSantePlanRequest.getAlcoolique() != null) {
            testDeSantePlan.setAlcoolique(testDeSantePlanRequest.getAlcoolique());
        }
        if (testDeSantePlanRequest.getSportif() != null) {
            testDeSantePlan.setSportif(testDeSantePlanRequest.getSportif());
        }
        if (testDeSantePlanRequest.getSymptomes() != null) {
            testDeSantePlan.setSymptomes(testDeSantePlanRequest.getSymptomes());
        }
        if (testDeSantePlanRequest.getCheckbok() != null) {
            testDeSantePlan.setCheckbok(testDeSantePlanRequest.getCheckbok());
        }
        if (testDeSantePlanRequest.getStatus() != null) {
            testDeSantePlan.setStatus(testDeSantePlanRequest.getStatus());
        }


        return testDeSantePlanRepository.save(testDeSantePlan);


    }


       @Override
   public boolean deleteTestDeSantePlan(Long id){
        if (!testDeSantePlanRepository.existsById(id)){
         return false;
      }
      testDeSantePlanRepository.deleteById(id);
      return true;
   }
}
