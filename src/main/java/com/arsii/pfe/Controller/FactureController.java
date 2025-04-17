package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestFacture;
import com.arsii.pfe.Dto.ResponseFacture;
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
@RequestMapping("api/arsii/facture")
@RequiredArgsConstructor
public class FactureController {
    @Autowired
    private FactureService factureService;
    private Collections collections;

    @GetMapping("")
    public ResponseEntity<List<ResponseFacture>> getAllFacture(){
        List<ResponseFacture> factures = factureService.getAllFacture();
        return ResponseEntity.ok(factures);
    }
    @PostMapping("")
    public ResponseEntity<Object> addFacture(@RequestBody @Valid RequestFacture request){
        factureService.createFacture(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                collections.singletonMap("message","save success !"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseFacture> getAllFactureById(@PathVariable Long id){
        return ResponseEntity.ok(factureService.getFactureById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateFacture(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestFacture request ){
    factureService.updateFacture(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
        public ResponseEntity<Object> deletedFacture(@PathVariable Long id){
        boolean deletedFacture= factureService.deleteFacture(id);
        if (deletedFacture){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "report not exist"));
    }

}


