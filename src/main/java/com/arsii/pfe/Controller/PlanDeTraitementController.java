package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestPlanDeTraitement;
import com.arsii.pfe.Dto.ResponsePlanDeTraitement;
import com.arsii.pfe.Service.PlanDeTraitementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/arsii/plandetraitement")
@RequiredArgsConstructor
public class PlanDeTraitementController {
    @Autowired
    private PlanDeTraitementService planDeTraitementService;
    private Collections collections;

    @GetMapping("")
    public ResponseEntity<List<ResponsePlanDeTraitement>> getAllPlanDeTraitement(){
        List<ResponsePlanDeTraitement> reports = planDeTraitementService.getAllPlanDeTraitement();
        return ResponseEntity.ok(reports);
    }
    @PostMapping("")
    public ResponseEntity<Object> addPlanDeTraitement(@RequestBody @Valid RequestPlanDeTraitement request){
        planDeTraitementService.createPlanDeTraitement(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                collections.singletonMap("message","save success !"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponsePlanDeTraitement> getAllPlanDeTraitementById(@PathVariable Long id){
        return ResponseEntity.ok(planDeTraitementService.getPlanDeTraitementById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updatePlanDeTraitement(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestPlanDeTraitement request ){
        planDeTraitementService.updatePlanDeTraitement(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deletedPlanDeTraitement(@PathVariable Long id){
        boolean deletedPlanDeTraitement = planDeTraitementService.deletePlanDeTraitement(id);
        if (deletedPlanDeTraitement){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "report not exist"));
    }

}


