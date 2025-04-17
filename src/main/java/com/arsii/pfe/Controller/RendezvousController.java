package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestFacture;
import com.arsii.pfe.Dto.RequestRendezvous;
import com.arsii.pfe.Dto.ResponseFacture;
import com.arsii.pfe.Dto.ResponseRendezvous;
import com.arsii.pfe.Service.FactureService;
import com.arsii.pfe.Service.RendezvousService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/arsii/rendezvous")
@RequiredArgsConstructor
public class RendezvousController {
    @Autowired
    private RendezvousService rendezvousService;
    private Collections collections;

    @GetMapping("")
    public ResponseEntity<List<ResponseRendezvous>> getAllRendezvous(){
        List<ResponseRendezvous> rendezvous1 = rendezvousService.getAllRendezvous();
        return ResponseEntity.ok(rendezvous1);
    }
    @PostMapping("")
    public ResponseEntity<Object> addRendezvous(@RequestBody @Valid RequestRendezvous request){
        rendezvousService.createRendezvous(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                collections.singletonMap("message","save success !"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseRendezvous> getAllRendezvousById(@PathVariable Long id){
        return ResponseEntity.ok(rendezvousService.getRendezvousById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateRendezvous(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestRendezvous request ){
    rendezvousService.updateRendezvous(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
        public ResponseEntity<Object> deletedRendezvouse(@PathVariable Long id){
        boolean deletedRendezvous= rendezvousService.deleteRendezvous(id);
        if (deletedRendezvous){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "report not exist"));
    }

}


