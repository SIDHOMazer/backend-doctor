package com.arsii.pfe.Servicelmpl;
import com.arsii.pfe.Dto.RequestAdmin;
import com.arsii.pfe.Dto.ResponseAdmin;
import com.arsii.pfe.Entities.Admin;
import com.arsii.pfe.Repository.AdminRepository;
import com.arsii.pfe.Service.AdminService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
   @Autowired
   private AdminRepository adminRepository;

   @Override
   public List<ResponseAdmin> getAllAdmin(){
      List<Admin> admins = adminRepository.findAll();
      List<ResponseAdmin> adminFormated = new ArrayList<>();
      for (Admin admin : admins) {
         ResponseAdmin admin1 = ResponseAdmin.makeAdmin(admin);
         adminFormated.add(admin1);
      }
      return adminFormated;
   }


   @Override
   public void createAdmin(RequestAdmin adminRequest){
      Admin admin = Admin.builder()
              .Lastname(adminRequest.getLastname())
              .firstname(adminRequest.getFirstname())
              .specialite(adminRequest.getSpecialite())
              .contact(adminRequest.getContact())
              .password(adminRequest.getPassword())
              .email(adminRequest.getEmail())
              .role(adminRequest.getRole())
              .adresse(adminRequest.getAdresse())
              .ville(adminRequest.getVille())
              .codePostal(adminRequest.getCodePostal())
                .status(adminRequest.getStatus())
              .build();
      adminRepository.save(admin);
   }


   @Override
   public ResponseAdmin getAdminById(Long id){
      Optional<Admin> admin = adminRepository.findById(id);
      return ResponseAdmin.makeAdmin(admin.get());
   }
   @Override
   public Admin updateAdmin(Long id, RequestAdmin adminRequest ) {
      Admin admin = adminRepository.findById(id).orElseThrow();

        if (adminRequest.getLastname()!=null){
             admin.setLastname(adminRequest.getLastname());
        }
        if (adminRequest.getFirstname()!=null){
            admin.setFirstname(adminRequest.getFirstname());
        }

      if (adminRequest.getSpecialite()!=null){
         admin.setSpecialite(adminRequest.getSpecialite());
      }

      if (adminRequest.getContact()!=null){
         admin.setContact(adminRequest.getContact());
      }
      if (adminRequest.getPassword()!=null){
         admin.setPassword(adminRequest.getPassword());
      }
        if (adminRequest.getEmail()!=null){
             admin.setEmail(adminRequest.getEmail());
        }
        if (adminRequest.getRole()!=null){
            admin.setRole(adminRequest.getRole());
        }
        if (adminRequest.getAdresse()!=null){
            admin.setAdresse(adminRequest.getAdresse());
        }
        if (adminRequest.getVille()!=null){
            admin.setVille(adminRequest.getVille());
        }
        if (adminRequest.getCodePostal()!=null){
            admin.setCodePostal(adminRequest.getCodePostal());
        }
        if (adminRequest.getStatus()!=null){
            admin.setStatus(adminRequest.getStatus());
        }

      return adminRepository.save(admin);
   }
   @Override
   public boolean deleteAdmin(Long id){
      if (!adminRepository.existsById(id)){
         return false;
      }
      adminRepository.deleteById(id);
      return true;
   }
}
