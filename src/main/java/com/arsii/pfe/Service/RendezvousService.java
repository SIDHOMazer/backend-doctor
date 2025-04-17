package com.arsii.pfe.Service;

import com.arsii.pfe.Dto.RequestFacture;
import com.arsii.pfe.Dto.RequestRendezvous;
import com.arsii.pfe.Dto.ResponseFacture;
import com.arsii.pfe.Dto.ResponseRendezvous;
import com.arsii.pfe.Entities.Facture;
import com.arsii.pfe.Entities.Rendezvous;

import java.util.List;

public interface RendezvousService {
    List<ResponseRendezvous> getAllRendezvous();
    boolean deleteRendezvous(Long id);
    void createRendezvous(RequestRendezvous rendezvousRequest);
    Rendezvous updateRendezvous(Long id, RequestRendezvous rendezvousRequest);
    ResponseRendezvous getRendezvousById(Long id);
}

