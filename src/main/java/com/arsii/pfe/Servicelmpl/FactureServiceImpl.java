package com.arsii.pfe.Servicelmpl;

import com.arsii.pfe.Dto.RequestFacture;
import com.arsii.pfe.Dto.ResponseFacture;
import com.arsii.pfe.Entities.Facture;
import com.arsii.pfe.Entities.Patient;
import com.arsii.pfe.Repository.FactureRepository;
import com.arsii.pfe.Repository.PatientRepository;
import com.arsii.pfe.Service.FactureService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService {
    @Autowired
    private FactureRepository factureRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<ResponseFacture> getAllFacture() {
        List<Facture> factures = factureRepository.findAll();
        List<ResponseFacture> factureFormated = new ArrayList<>();
        for (Facture facture : factures) {
            ResponseFacture facteur1 = ResponseFacture.makeFacture(facture);
            factureFormated.add(facteur1);
        }
        return factureFormated;
    }

    @Override
    public void createFacture(@NotNull RequestFacture facteurRequest) {
        Patient patient = patientRepository.findById(facteurRequest.getPatientId()).orElseThrow();
        Facture facture = Facture.builder()
                .patient(patient)
                .Invoice(facteurRequest.getInvoice())
                .Date(facteurRequest.getDate())
                .Description(facteurRequest.getDescription())
                .Price(facteurRequest.getPrice())
                .QTY(facteurRequest.getQTY())
                .Total(facteurRequest.getTotal())
                .SubTotal(facteurRequest.getSubTotal())
                .Tax(facteurRequest.getTax())
                .PaymentMethod(facteurRequest.getPaymentMethod())
                .status(true)
                .build();

        factureRepository.save(facture);

    }


    @Override
    public ResponseFacture getFactureById(Long id) {
        Optional<Facture> facture = factureRepository.findById(id);
        return ResponseFacture.makeFacture(facture.get());
    }

    @Override
    public Facture updateFacture(Long id, RequestFacture factureRequest) {
        Facture facture = factureRepository.findById(id).orElseThrow();
        if (factureRequest.getPatientId() != null) {
            Patient patient = patientRepository.findById(factureRequest.getPatientId()).orElseThrow();
            facture.setPatient(patient);
        }
        if (factureRequest.getInvoice() != null) {
            facture.setInvoice(factureRequest.getInvoice());
        }
        if (factureRequest.getDate() != null) {
            facture.setDate(factureRequest.getDate());
        }
        if (factureRequest.getDescription() != null) {
            facture.setDescription(factureRequest.getDescription());
        }
        if (factureRequest.getPrice() != null) {
            facture.setPrice(factureRequest.getPrice());
        }
        if (factureRequest.getQTY() != null) {
            facture.setQTY(factureRequest.getQTY());
        }
        if (factureRequest.getTotal() != null) {
            facture.setTotal(factureRequest.getTotal());
        }
        if (factureRequest.getSubTotal() != null) {
            facture.setSubTotal(factureRequest.getSubTotal());
        }
        if (factureRequest.getTax() != null) {
            facture.setTax(factureRequest.getTax());
        }
        if (factureRequest.getPaymentMethod() != null) {
            facture.setPaymentMethod(factureRequest.getPaymentMethod());
        }
        if (factureRequest.getStatus() != null) {
            facture.setStatus(factureRequest.getStatus());
        }



         return  factureRepository.save(facture);

    }


       @Override
   public boolean deleteFacture(Long id){
        if (!factureRepository.existsById(id)){
         return false;
      }
      factureRepository.deleteById(id);
      return true;
   }
}
