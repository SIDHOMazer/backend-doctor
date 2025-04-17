package com.arsii.pfe.Service;

import com.arsii.pfe.Dto.RequestDocteur;
import com.arsii.pfe.Dto.ResponseDocteur;
import com.arsii.pfe.Entities.Docteur;

import java.util.List;

public interface DocteurService {
    List<ResponseDocteur> getAllDocteur();
    boolean deleteDocteur(Long id);
    void createDocteur(RequestDocteur docteurRequest);
    Docteur updateDocteur(Long id, RequestDocteur docteurRequest);
    ResponseDocteur getDocteurById(Long id);
}

