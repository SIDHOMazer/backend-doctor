package com.arsii.pfe.Repository;
import com.arsii.pfe.Entities.Docteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocteurRepository extends JpaRepository<Docteur , Long> {
}
