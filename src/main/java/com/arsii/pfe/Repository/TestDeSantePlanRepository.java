package com.arsii.pfe.Repository;
import com.arsii.pfe.Entities.MedicamentPlan;
import com.arsii.pfe.Entities.TestDeSantePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDeSantePlanRepository extends JpaRepository<TestDeSantePlan, Long> {
}
