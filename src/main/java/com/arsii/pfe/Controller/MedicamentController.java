package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestMedicament;
import com.arsii.pfe.Dto.RequestMedicamentPlan;
import com.arsii.pfe.Dto.ResponseMedicament;
import com.arsii.pfe.Dto.ResponseMedicamentPlan;
import com.arsii.pfe.Service.MedicamentPlanService;
import com.arsii.pfe.Service.MedicamentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/arsii/medicament")
@RequiredArgsConstructor
public class MedicamentController {
    @Autowired
    private MedicamentService medicamentService;
    private Collections collections;

    @GetMapping("")
    public ResponseEntity<List<ResponseMedicament>> getAllMedicament(){
        List<ResponseMedicament > medicaments= medicamentService.getAllMedicament();
        return ResponseEntity.ok(medicaments);
    }
    @PostMapping("")
    public ResponseEntity<Object> addMedicament(@RequestBody @Valid RequestMedicament request){
        medicamentService.createMedicament(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                collections.singletonMap("message","save success !"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseMedicament> getAllMedicamentById(@PathVariable Long id){
        return ResponseEntity.ok(medicamentService.getMedicamentById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateMedicament(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestMedicament request ){
    medicamentService.updateMedicament(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
        public ResponseEntity<Object> deletedMedicament(@PathVariable Long id){
        boolean deletedMedicament= medicamentService.deleteMedicament(id);
        if (deletedMedicament){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "report not exist"));
    }

}


