package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestAdmin;
import com.arsii.pfe.Dto.RequestDocteur;
import com.arsii.pfe.Dto.ResponseAdmin;
import com.arsii.pfe.Dto.ResponseDocteur;
import com.arsii.pfe.Service.AdminService;
import com.arsii.pfe.Service.DocteurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping("api/arsii/docteur")
@RequiredArgsConstructor
public class DocteurController {
  @Autowired
   private DocteurService docteurService;
    private Collections collections;

   @GetMapping("")
    public ResponseEntity<List<ResponseDocteur>> getAllDocteur(){
       List<ResponseDocteur> docteurs = docteurService.getAllDocteur();
       return ResponseEntity.ok(docteurs);
   }
    @PostMapping("")
    public ResponseEntity<Object> addDocteur(@RequestBody @Valid RequestDocteur request){
        docteurService.createDocteur(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
               collections.singletonMap("message","save success !"));
   }
   @GetMapping("{id}")
    public ResponseEntity<ResponseDocteur> getAllDocteurById(@PathVariable Long id){
       return ResponseEntity.ok(docteurService.getDocteurById(id));
    }
   @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateDocteur(
           @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestDocteur request ){
        docteurService.updateDocteur(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deletedDocteur(@PathVariable Long id){
        boolean deletedDocteur = docteurService.deleteDocteur(id);
       if (deletedDocteur){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "docteur not exist"));
    }
}
