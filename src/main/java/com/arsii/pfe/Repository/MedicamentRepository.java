package com.arsii.pfe.Repository;
import com.arsii.pfe.Entities.Medicament;
import com.arsii.pfe.Entities.MedicamentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
}
