package com.arsii.pfe.Servicelmpl;

import com.arsii.pfe.Dto.RequestTestDeSante;
import com.arsii.pfe.Dto.RequestTestDeSantePlan;
import com.arsii.pfe.Dto.ResponseTestDeSante;
import com.arsii.pfe.Dto.ResponseTestDeSantePlan;
import com.arsii.pfe.Entities.PlanDeTraitement;
import com.arsii.pfe.Entities.TestDeSante;
import com.arsii.pfe.Entities.TestDeSantePlan;
import com.arsii.pfe.Repository.PlanDeTraitementRepository;
import com.arsii.pfe.Repository.TestDeSantePlanRepository;
import com.arsii.pfe.Repository.TestDeSanteRepository;
import com.arsii.pfe.Service.TestDeSantePlanService;
import com.arsii.pfe.Service.TestDeSanteService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestDeSanteServiceImpl implements TestDeSanteService {
    @Autowired
    private TestDeSanteRepository testDeSanteRepository;
    @Autowired
    private TestDeSantePlanRepository testDeSantePlanRepository;

    @Override
    public List<ResponseTestDeSante> getAllTestDeSante() {
        List<TestDeSante> testDeSantes = testDeSanteRepository.findAll();
        List<ResponseTestDeSante> testDeSanteFormated = new ArrayList<>();
        for (TestDeSante testDeSante : testDeSantes) {
            ResponseTestDeSante testDeSante1 = ResponseTestDeSante.makeTestDeSante(testDeSante);
           testDeSanteFormated.add(testDeSante1);
        }
        return testDeSanteFormated;
    }

    @Override
    public void createTestDeSante(@NotNull RequestTestDeSante testDeSanteRequest) {
        TestDeSante testDeSante = TestDeSante.builder()
                .TestName(testDeSanteRequest.getTestName())
                .TestDate(testDeSanteRequest.getTestDate())
                .Result(testDeSanteRequest.getResult())
                .status(true)

                .build();

        testDeSanteRepository.save(testDeSante);
    }


    @Override
    public ResponseTestDeSante getTestDeSanteById(Long id) {
        Optional<TestDeSante> testDeSante = testDeSanteRepository.findById(id);
        return ResponseTestDeSante.makeTestDeSante(testDeSante.get());
    }

    @Override
    public TestDeSante updateTestDeSante(Long id, RequestTestDeSante testDeSanteRequest) {
        TestDeSante testDeSante = testDeSanteRepository.findById(id).orElseThrow();

        if (testDeSanteRequest.getTestName() != null) {
            testDeSante.setTestName(testDeSanteRequest.getTestName());
        }
        if (testDeSanteRequest.getTestDate() != null) {
            testDeSante.setTestDate(testDeSanteRequest.getTestDate());
        }
        if (testDeSanteRequest.getResult() != null) {
            testDeSante.setResult(testDeSanteRequest.getResult());
        }
        if (testDeSanteRequest.getStatus() != null) {
            testDeSante.setStatus(testDeSanteRequest.getStatus());
        }

        return testDeSanteRepository.save(testDeSante);

    }


       @Override
   public boolean deleteTestDeSante(Long id){
        if (!testDeSanteRepository.existsById(id)){
         return false;
      }
      testDeSanteRepository.deleteById(id);
      return true;
   }
}
