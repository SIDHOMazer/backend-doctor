package com.arsii.pfe.Service;

import com.arsii.pfe.Dto.RequestTestDeSantePlan;
import com.arsii.pfe.Dto.ResponseTestDeSantePlan;
import com.arsii.pfe.Entities.TestDeSantePlan;

import java.util.List;

public interface TestDeSantePlanService {

    List<ResponseTestDeSantePlan> getAllTestDeSantePlan();
    boolean deleteTestDeSantePlan(Long id);
    void createTestDeSantePlan(RequestTestDeSantePlan testDeSantePlanRequest);
    TestDeSantePlan updateTestDeSantePlan(Long id, RequestTestDeSantePlan testDeSantePlanRequest);
    ResponseTestDeSantePlan getTestDeSantePlanById(Long id);
}

