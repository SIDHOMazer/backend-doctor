package com.arsii.pfe.Repository;
import com.arsii.pfe.Entities.Exercice;
import com.arsii.pfe.Entities.ExercicePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Long> {
}
