package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestAdmin;
import com.arsii.pfe.Dto.ResponseAdmin;
import com.arsii.pfe.Service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/arsii/admin")
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    private AdminService adminService;
    private Collections collections;

    @GetMapping("")
    public ResponseEntity<List<ResponseAdmin>> getAllAdmin(){
        List<ResponseAdmin> admins = adminService.getAllAdmin();
        return ResponseEntity.ok(admins);
    }
@PostMapping("")
public ResponseEntity<Object> addAdmin(@RequestBody @Valid RequestAdmin request){
        adminService.createAdmin(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
         collections.singletonMap("message","save success !"));
}
@GetMapping("{id}")
    public ResponseEntity<ResponseAdmin> getAdminById(@PathVariable Long id){
        return ResponseEntity.ok(adminService.getAdminById(id));
}
@PutMapping(value = "{id}")
    public ResponseEntity<Object> updateAdmin(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestAdmin request ){
        adminService.updateAdmin(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
}
@DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deletedAdmin (@PathVariable Long id){
        boolean deletedAdmin = adminService.deleteAdmin(id);
          if (deletedAdmin){
              return ResponseEntity.status(HttpStatus.CREATED).body(
                      Collections.singletonMap("message","delete success !!"));
          }
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            Collections.singletonMap("message", "admin not exist"));
}
}
