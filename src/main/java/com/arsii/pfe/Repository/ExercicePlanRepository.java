package com.arsii.pfe.Repository;
import com.arsii.pfe.Entities.ExercicePlan;
import com.arsii.pfe.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicePlanRepository extends JpaRepository<ExercicePlan, Long> {
}
