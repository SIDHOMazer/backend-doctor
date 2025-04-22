package com.arsii.pfe.Servicelmpl;

import com.arsii.pfe.Dto.RequestDocteur;
import com.arsii.pfe.Dto.ResponseDocteur;
import com.arsii.pfe.Entities.Docteur;
import com.arsii.pfe.Repository.DocteurRepository;
import com.arsii.pfe.Service.DocteurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocteurServiceImpl implements DocteurService {



    @Autowired
    private DocteurRepository docteurRepository;

    @Override
    public List<ResponseDocteur> getAllDocteur() {
        List<Docteur> docteurs = docteurRepository.findAll();
        List<ResponseDocteur> docteurs1 = new ArrayList<>();
        for (Docteur docteur : docteurs) {
            ResponseDocteur docteur1 = ResponseDocteur.makeDocteur(docteur);
            docteurs1.add(docteur1);
        }
        return docteurs1;
    }



    @Override
    public void createDocteur(RequestDocteur docteurRequest){
        Docteur docteur = Docteur.builder()
                .Lastname(docteurRequest.getLastname())
                .firstname(docteurRequest.getFirstname())
                .specialite(docteurRequest.getSpecialite())
                .contact(docteurRequest.getContact())
                .sexe(docteurRequest.getSexe())
                .password(docteurRequest.getPassword())
                .email(docteurRequest.getEmail())
                .adresse(docteurRequest.getAdresse())
                .ville(docteurRequest.getVille())
                .codePostal(docteurRequest.getCodePostal())
                .Localisation(docteurRequest.getLocalisation())
                .status(true)
                .build();
        docteurRepository.save(docteur);
    }
    @Override
    public ResponseDocteur getDocteurById(Long id){
        Optional<Docteur> docteur = docteurRepository.findById(id);
        return ResponseDocteur.makeDocteur(docteur.get());
    }
    @Override
    public Docteur updateDocteur(Long id, RequestDocteur docteurRequest ) {
        Docteur docteur = docteurRepository.findById(id).orElseThrow();

        if (docteurRequest.getFirstname() != null) {
            docteur.setFirstname(docteurRequest.getFirstname());
        }
        if (docteurRequest.getLastname() != null) {
            docteur.setLastname(docteurRequest.getLastname());
        }
        if (docteurRequest.getSpecialite() != null) {
            docteur.setSpecialite(docteurRequest.getSpecialite());
        }
        if (docteurRequest.getContact() != null) {
            docteur.setContact(docteurRequest.getContact());
        }
        if (docteurRequest.getPassword() != null) {
            docteur.setPassword(docteurRequest.getPassword());
        }
        if (docteurRequest.getEmail() != null) {
            docteur.setEmail(docteurRequest.getEmail());
        }
        if (docteurRequest.getAdresse() != null) {
            docteur.setAdresse(docteurRequest.getAdresse());
        }
        if (docteurRequest.getVille() != null) {
            docteur.setVille(docteurRequest.getVille());
        }
        if (docteurRequest.getCodePostal() != null) {
            docteur.setCodePostal(docteurRequest.getCodePostal());
        }

        if (docteurRequest.getSexe() != null) {
            docteur.setSexe(docteurRequest.getSexe());
        }
        if (docteurRequest.getLocalisation() != null) {
            docteur.setLocalisation(docteurRequest.getLocalisation());
        }
        if (docteurRequest.getStatus() != null) {
            docteur.setStatus(docteurRequest.getStatus());
        }
        docteurRepository.save(docteur);
        return docteur;
    }
    @Override
    public boolean deleteDocteur(Long id){
        if (!docteurRepository.existsById(id)){
            return false;
        }
        docteurRepository.deleteById(id);
        return true;
    }
}
