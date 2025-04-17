package com.arsii.pfe.Service;

import com.arsii.pfe.Dto.RequestFacture;
import com.arsii.pfe.Dto.ResponseFacture;
import com.arsii.pfe.Entities.Facture;


import java.util.List;

public interface FactureService {
    List<ResponseFacture> getAllFacture();
    boolean deleteFacture(Long id);
    void createFacture(RequestFacture factureRequest);
    Facture updateFacture(Long id, RequestFacture factureRequest);
    ResponseFacture getFactureById(Long id);
}

