package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestMedicamentPlan;
import com.arsii.pfe.Dto.RequestTestDeSantePlan;
import com.arsii.pfe.Dto.ResponseMedicamentPlan;
import com.arsii.pfe.Dto.ResponseTestDeSantePlan;
import com.arsii.pfe.Service.MedicamentPlanService;
import com.arsii.pfe.Service.TestDeSantePlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/arsii/testDeSantePlan")
@RequiredArgsConstructor
public class TestDeSantePlanController {
    @Autowired
    private TestDeSantePlanService testDeSantePlanService;
    private Collections collections;

    @GetMapping("")
    public ResponseEntity<List<ResponseTestDeSantePlan>> getAllTestDeSantePlan(){
        List<ResponseTestDeSantePlan> testDeSantePlans= testDeSantePlanService.getAllTestDeSantePlan();
        return ResponseEntity.ok(testDeSantePlans);
    }
    @PostMapping("")
    public ResponseEntity<Object> addTestDeSantePlan(@RequestBody @Valid RequestTestDeSantePlan request){
        testDeSantePlanService.createTestDeSantePlan(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                collections.singletonMap("message","save success !"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseTestDeSantePlan> getAllTestDeSantePlanById(@PathVariable Long id){
        return ResponseEntity.ok(testDeSantePlanService.getTestDeSantePlanById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateTestDeSantePlan(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestTestDeSantePlan request ){
    testDeSantePlanService.updateTestDeSantePlan(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
        public ResponseEntity<Object> deletedTestDeSantePlan(@PathVariable Long id){
        boolean deletedTestDeSantePlan= testDeSantePlanService.deleteTestDeSantePlan(id);
        if (deletedTestDeSantePlan){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "report not exist"));
    }

}


