package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestExercice;
import com.arsii.pfe.Dto.RequestExercicePlan;
import com.arsii.pfe.Dto.ResponseExercice;
import com.arsii.pfe.Dto.ResponseExercicePlan;
import com.arsii.pfe.Service.ExercicePlanService;
import com.arsii.pfe.Service.ExerciceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/arsii/exercice")
@RequiredArgsConstructor
public class ExerciceController {
    @Autowired
    private ExerciceService exerciceService;
    private Collections collections;

    @GetMapping("")
    public ResponseEntity<List<ResponseExercice>> getAllExercice(){
        List<ResponseExercice> exercices= exerciceService.getAllExercice();
        return ResponseEntity.ok(exercices);
    }
    @PostMapping("")
    public ResponseEntity<Object> addExercice(@RequestBody @Valid RequestExercice request){
        exerciceService.createExercice(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                collections.singletonMap("message","save success !"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseExercice> getAllExerciceById(@PathVariable Long id){
        return ResponseEntity.ok(exerciceService.getExerciceById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateExercice(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestExercice request ){
    exerciceService.updateExercice(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
        public ResponseEntity<Object> deletedExercice(@PathVariable Long id){
        boolean deletedExercice= exerciceService.deleteExercice(id);
        if (deletedExercice){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "report not exist"));
    }

}


