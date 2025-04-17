package com.arsii.pfe.Service;
import com.arsii.pfe.Dto.RequestPatient;
import com.arsii.pfe.Dto.ResponsePatient;
import com.arsii.pfe.Entities.Patient;

import java.util.List;

public interface PatientService {
    List<ResponsePatient> getAllPatient();

    boolean deletePatient(Long id);
    void createPatient(RequestPatient patientRequest);
    Patient updatePatient(Long id, RequestPatient patientRequest);
    ResponsePatient getPatientById(Long id);
}
