package com.arsii.pfe.Repository;
import com.arsii.pfe.Entities.TestDeSante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDeSanteRepository extends JpaRepository<TestDeSante, Long> {
}
