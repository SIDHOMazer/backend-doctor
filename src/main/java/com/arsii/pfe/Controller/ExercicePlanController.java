package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestExercicePlan;
import com.arsii.pfe.Dto.RequestFacture;
import com.arsii.pfe.Dto.ResponseExercicePlan;
import com.arsii.pfe.Dto.ResponseFacture;
import com.arsii.pfe.Service.ExercicePlanService;
import com.arsii.pfe.Service.FactureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/arsii/exercicePlan")
@RequiredArgsConstructor
public class ExercicePlanController {
    @Autowired
    private ExercicePlanService exercicePlanService;
    private Collections collections;

    @GetMapping("")
    public ResponseEntity<List<ResponseExercicePlan>> getAllExercicePlan(){
        List<ResponseExercicePlan> exercicePlans= exercicePlanService.getAllExercicePlan();
        return ResponseEntity.ok(exercicePlans);
    }
    @PostMapping("")
    public ResponseEntity<Object> addExercicePlan(@RequestBody @Valid RequestExercicePlan request){
        exercicePlanService.createExercicePlan(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                collections.singletonMap("message","save success !"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseExercicePlan> getAllExercicePlanById(@PathVariable Long id){
        return ResponseEntity.ok(exercicePlanService.getExercicePlanById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateExercicePlan(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestExercicePlan request ){
    exercicePlanService.updateExercicePlan(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
        public ResponseEntity<Object> deletedExercicePlan(@PathVariable Long id){
        boolean deletedExercicePlan= exercicePlanService.deleteExercicePlan(id);
        if (deletedExercicePlan){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "report not exist"));
    }

}


