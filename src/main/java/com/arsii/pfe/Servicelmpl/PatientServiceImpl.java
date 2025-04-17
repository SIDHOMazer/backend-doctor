package com.arsii.pfe.Servicelmpl;


import com.arsii.pfe.Dto.RequestPatient;
import com.arsii.pfe.Dto.ResponsePatient;
import com.arsii.pfe.Entities.Patient;
import com.arsii.pfe.Repository.PatientRepository;
import com.arsii.pfe.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {


    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<ResponsePatient> getAllPatient(){
        List<Patient> patients = patientRepository.findAll();
        List<ResponsePatient> patients1= new ArrayList<>();
        for (Patient patient: patients) {
            ResponsePatient patient1 = ResponsePatient.makePatient(patient);
            patients1.add(patient1);
        }
        return patients1;
    }


    @Override
    public void createPatient(RequestPatient patientRequest){
        Patient patient = Patient.builder()
                .id(patientRequest.getId())
                .Lastname(patientRequest.getLastname())
                .firstname(patientRequest.getFirstname())
                .HistoriqueMedical(patientRequest.getHistoriqueMedical())
                .DateNaissance(patientRequest.getDateNaissance())
                .contact(patientRequest.getContact())
                .password(patientRequest.getPassword())
                .email(patientRequest.getEmail())
                .adresse(patientRequest.getAdresse())
                .ville(patientRequest.getVille())
                .codePostal(patientRequest.getCodePostal())
                .sexe(patientRequest.getSexe())
                .status(patientRequest.getStatus())
                .build();
        patientRepository.save(patient);
    }
    @Override
    public ResponsePatient getPatientById(Long id){
        Optional<Patient> patient = patientRepository.findById(id);
        return ResponsePatient.makePatient(patient.get());
    }
     @Override
         public Patient updatePatient(Long id, RequestPatient patientRequest ) {
         Patient patient = patientRepository.findById(id).orElseThrow();
         if (patientRequest.getFirstname() != null) {
             patient.setFirstname(patientRequest.getFirstname());
         }
         if (patientRequest.getLastname() != null) {
             patient.setLastname(patientRequest.getLastname());
         }
         if (patientRequest.getContact() != null) {
             patient.setContact(patientRequest.getContact());
         }
         if (patientRequest.getPassword() != null) {
             patient.setPassword(patientRequest.getPassword());
         }
         if (patientRequest.getEmail() != null) {
             patient.setEmail(patientRequest.getEmail());
         }
         if (patientRequest.getAdresse() != null) {
             patient.setAdresse(patientRequest.getAdresse());
         }
         if (patientRequest.getVille() != null) {
             patient.setVille(patientRequest.getVille());
         }
         if (patientRequest.getCodePostal() != null) {
             patient.setCodePostal(patientRequest.getCodePostal());
         }

         if (patientRequest.getSexe() != null) {
             patient.setSexe(patientRequest.getSexe());
         }
         if (patientRequest.getDateNaissance() != null) {
             patient.setDateNaissance(patientRequest.getDateNaissance());
         }

         if (patientRequest.getHistoriqueMedical() != null) {
             patient.setHistoriqueMedical(patientRequest.getHistoriqueMedical());
         }
         if (patientRequest.getStatus() != null) {
             patient.setStatus(patientRequest.getStatus());
         }
         return patientRepository.save(patient);
     }


     @Override
        public boolean deletePatient(Long id) {
         if (!patientRepository.existsById(id)) {
             return false;
         }
         patientRepository.deleteById(id);
         return true;
     }
}





