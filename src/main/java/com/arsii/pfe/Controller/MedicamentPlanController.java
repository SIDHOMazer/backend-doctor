package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestExercicePlan;
import com.arsii.pfe.Dto.RequestMedicamentPlan;
import com.arsii.pfe.Dto.ResponseExercicePlan;
import com.arsii.pfe.Dto.ResponseMedicamentPlan;
import com.arsii.pfe.Service.ExercicePlanService;
import com.arsii.pfe.Service.MedicamentPlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/arsii/medicamentPlan")
@RequiredArgsConstructor
public class MedicamentPlanController {
    @Autowired
    private MedicamentPlanService  medicamentPlanService;
    private Collections collections;

    @GetMapping("")
    public ResponseEntity<List<ResponseMedicamentPlan>> getAllMedicamentPlan(){
        List<ResponseMedicamentPlan > medicamentPlans= medicamentPlanService.getAllMedicamentPlan();
        return ResponseEntity.ok(medicamentPlans);
    }
    @PostMapping("")
    public ResponseEntity<Object> addMedicamentPlan(@RequestBody @Valid RequestMedicamentPlan request){
        medicamentPlanService.createMedicamentPlan(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                collections.singletonMap("message","save success !"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseMedicamentPlan> getAllMedicamentPlanById(@PathVariable Long id){
        return ResponseEntity.ok(medicamentPlanService.getMedicamentPlanById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateMedicamentPlan(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestMedicamentPlan request ){
    medicamentPlanService.updateMedicamentPlan(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
        public ResponseEntity<Object> deletedMedicamentPlan(@PathVariable Long id){
        boolean deletedMedicamentPlan= medicamentPlanService.deleteMedicamentPlan(id);
        if (deletedMedicamentPlan){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "report not exist"));
    }

}


