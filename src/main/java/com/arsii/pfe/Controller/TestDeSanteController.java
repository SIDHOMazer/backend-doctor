package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestTestDeSante;
import com.arsii.pfe.Dto.RequestTestDeSantePlan;
import com.arsii.pfe.Dto.ResponseTestDeSante;
import com.arsii.pfe.Dto.ResponseTestDeSantePlan;
import com.arsii.pfe.Service.TestDeSantePlanService;
import com.arsii.pfe.Service.TestDeSanteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/arsii/testDeSante")
@RequiredArgsConstructor
public class TestDeSanteController {
    @Autowired
    private TestDeSanteService testDeSanteService;
    private Collections collections;

    @GetMapping("")
    public ResponseEntity<List<ResponseTestDeSante>> getAllTestDeSante(){
        List<ResponseTestDeSante> testDeSantes= testDeSanteService.getAllTestDeSante();
        return ResponseEntity.ok(testDeSantes);
    }
    @PostMapping("")
    public ResponseEntity<Object> addTestDeSante(@RequestBody @Valid RequestTestDeSante request){
        testDeSanteService.createTestDeSante(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                collections.singletonMap("message","save success !"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseTestDeSante> getAllTestDeSanteById(@PathVariable Long id){
        return ResponseEntity.ok(testDeSanteService.getTestDeSanteById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateTestDeSante(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestTestDeSante request ){
    testDeSanteService.updateTestDeSante(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
        public ResponseEntity<Object> deletedTestDeSante(@PathVariable Long id){
        boolean deletedTestDeSante= testDeSanteService.deleteTestDeSante(id);
        if (deletedTestDeSante){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "report not exist"));
    }

}


