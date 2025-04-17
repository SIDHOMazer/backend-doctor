package com.arsii.pfe.Repository;
import com.arsii.pfe.Entities.PlanDeTraitement;
import com.arsii.pfe.Entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanDeTraitementRepository extends JpaRepository<PlanDeTraitement, Long> {
}
