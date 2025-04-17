package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestPatient;
import com.arsii.pfe.Dto.ResponsePatient;
import com.arsii.pfe.Entities.Patient;
import com.arsii.pfe.Service.DocteurService;
import com.arsii.pfe.Service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/arsii/patient")
@RequiredArgsConstructor
public class PatientController {
    @Autowired
    private PatientService patientService;
    private Collections collections;

    @GetMapping("")
    public ResponseEntity<List<ResponsePatient>> getAllPatient(){
        List<ResponsePatient> patients = patientService.getAllPatient();
        return ResponseEntity.ok(patients);
    }
    @PostMapping("")
    public ResponseEntity<Object> addPatient(@RequestBody @Valid RequestPatient request){
        patientService.createPatient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                collections.singletonMap("message","save success !"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponsePatient> getAllPatientById(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getPatientById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updatePatient(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestPatient request ){
        patientService.updatePatient(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deletedPatient(@PathVariable Long id){
        boolean deletedPatient = patientService.deletePatient(id);
        if (deletedPatient){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "patient not exist"));
    }

}
