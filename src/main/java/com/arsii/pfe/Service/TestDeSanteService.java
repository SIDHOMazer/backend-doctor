package com.arsii.pfe.Service;

import com.arsii.pfe.Dto.RequestTestDeSante;
import com.arsii.pfe.Dto.RequestTestDeSantePlan;
import com.arsii.pfe.Dto.ResponseTestDeSante;
import com.arsii.pfe.Dto.ResponseTestDeSantePlan;
import com.arsii.pfe.Entities.TestDeSante;
import com.arsii.pfe.Entities.TestDeSantePlan;

import java.util.List;

public interface TestDeSanteService {

    List<ResponseTestDeSante> getAllTestDeSante();
    boolean deleteTestDeSante(Long id);
    void createTestDeSante(RequestTestDeSante testDeSanteRequest);
    TestDeSante updateTestDeSante(Long id, RequestTestDeSante testDeSanteRequest);
    ResponseTestDeSante getTestDeSanteById(Long id);
}

