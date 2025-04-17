package com.arsii.pfe.Repository;
import com.arsii.pfe.Entities.Facture;
import com.arsii.pfe.Entities.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezvousRepository extends JpaRepository<Rendezvous, Long> {
}
