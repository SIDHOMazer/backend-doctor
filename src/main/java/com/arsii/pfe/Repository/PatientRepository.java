package com.arsii.pfe.Repository;
import com.arsii.pfe.Entities.Admin;
import com.arsii.pfe.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
