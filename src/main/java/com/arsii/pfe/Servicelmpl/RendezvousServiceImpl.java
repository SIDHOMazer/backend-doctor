package com.arsii.pfe.Servicelmpl;

import com.arsii.pfe.Dto.RequestFacture;
import com.arsii.pfe.Dto.RequestRendezvous;
import com.arsii.pfe.Dto.ResponseFacture;
import com.arsii.pfe.Dto.ResponseRendezvous;
import com.arsii.pfe.Entities.Docteur;
import com.arsii.pfe.Entities.Facture;
import com.arsii.pfe.Entities.Patient;
import com.arsii.pfe.Entities.Rendezvous;
import com.arsii.pfe.Repository.DocteurRepository;
import com.arsii.pfe.Repository.FactureRepository;
import com.arsii.pfe.Repository.PatientRepository;
import com.arsii.pfe.Repository.RendezvousRepository;
import com.arsii.pfe.Service.FactureService;
import com.arsii.pfe.Service.RendezvousService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RendezvousServiceImpl implements RendezvousService{
    @Autowired
    private RendezvousRepository rendezvousRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DocteurRepository docteurRepository;

    @Override
    public List<ResponseRendezvous> getAllRendezvous() {
        List<Rendezvous> rendezvous2= rendezvousRepository.findAll();
        List<ResponseRendezvous> rendezvousFormated = new ArrayList<>();
        for (Rendezvous rendezvous : rendezvous2) {
            ResponseRendezvous rendezvous1 = ResponseRendezvous.makeRendezvous(rendezvous);
            rendezvousFormated.add(rendezvous1);
        }
        return rendezvousFormated;
    }

    @Override
    public void createRendezvous(@NotNull RequestRendezvous rendezvousRequest) {
        Patient patient = patientRepository.findById(rendezvousRequest.getPatientId()).orElseThrow();
        Docteur docteur = docteurRepository.findById(rendezvousRequest.getDocteurId()).orElseThrow();
        Rendezvous rendezvous = Rendezvous.builder()
                .patient(patient)
                .docteur(docteur)
                .date(rendezvousRequest.getDate())
                .statut(rendezvousRequest.getStatut())
                .acceptDate(rendezvousRequest.getAcceptDate())
                .rejectDate(rendezvousRequest.getRejectDate())
                .NameCompany(rendezvousRequest.getNameCompany())
                .status(true)

                .build();

        rendezvousRepository.save(rendezvous);

    }


    @Override
    public ResponseRendezvous getRendezvousById(Long id) {
        Optional<Rendezvous> rendezvous = rendezvousRepository.findById(id);
        return ResponseRendezvous.makeRendezvous(rendezvous.get());
    }

    @Override
    public Rendezvous updateRendezvous(Long id, RequestRendezvous rendezvousRequest) {
        Rendezvous rendezvous = rendezvousRepository.findById(id).orElseThrow();
        if (rendezvousRequest.getPatientId() != null) {
            Patient patient = patientRepository.findById(rendezvousRequest.getPatientId()).orElseThrow();
            rendezvous.setPatient(patient);
        }
        if (rendezvousRequest.getDate() != null) {
            rendezvous.setDate(rendezvousRequest.getDate());
        }
        if (rendezvousRequest.getStatut() != null) {
            rendezvous.setStatut(rendezvousRequest.getStatut());
        }
        if (rendezvousRequest.getAcceptDate() != null) {
            rendezvous.setAcceptDate(rendezvousRequest.getAcceptDate());
        }
        if (rendezvousRequest.getRejectDate() != null) {
            rendezvous.setRejectDate(rendezvousRequest.getRejectDate());
        }
        if (rendezvousRequest.getNameCompany() != null) {
            rendezvous.setNameCompany(rendezvousRequest.getNameCompany());
        }
        if (rendezvousRequest.getStatus() != null) {
            rendezvous.setStatus(rendezvousRequest.getStatus());
        }
        return rendezvousRepository.save(rendezvous);


    }


       @Override
   public boolean deleteRendezvous(Long id){
        if (!rendezvousRepository.existsById(id)){
         return false;
      }
      rendezvousRepository.deleteById(id);
      return true;
   }
}
