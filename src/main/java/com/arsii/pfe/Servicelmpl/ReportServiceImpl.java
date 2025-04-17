package com.arsii.pfe.Servicelmpl;

import com.arsii.pfe.Dto.RequestReport;
import com.arsii.pfe.Dto.ResponseReport;
import com.arsii.pfe.Entities.Patient;
import com.arsii.pfe.Entities.Report;
import com.arsii.pfe.Repository.PatientRepository;
import com.arsii.pfe.Repository.ReportRepository;
import com.arsii.pfe.Service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{
   @Autowired
   private ReportRepository reportRepository;
   @Autowired
   private PatientRepository patientRepository;

   @Override
   public List<ResponseReport> getAllReport(){
      List<Report> reports = reportRepository.findAll();
      List<ResponseReport> reportFormated = new ArrayList<>();
      for (Report report : reports) {
         ResponseReport report1 = ResponseReport.makeReport(report);
         reportFormated.add(report1);
      }
      return reportFormated;
   }


   @Override
   public void createReport(RequestReport reportRequest){
       Patient patient = patientRepository.findById(reportRequest.getPatientId()).orElseThrow();
      Report report = Report.builder()
              .file(reportRequest.getFile())
              .patient(patient)
                .Type(reportRequest.getType())
                .Date(reportRequest.getDate())
                .Heure(reportRequest.getHeure())
                .Description(reportRequest.getDescription())
              .build();

      reportRepository.save(report);

   }


   @Override
   public ResponseReport getReportById(Long id){
      Optional<Report> report = reportRepository.findById(id);
      return ResponseReport.makeReport(report.get());
   }
   @Override
   public Report updateReport(Long id, RequestReport reportRequest ) {
      Report report = reportRepository.findById(id).orElseThrow();

        if (reportRequest.getFile() !=  null){
             report.setFile(reportRequest.getFile());
        }

        if (reportRequest.getType() != null){
            report.setType(reportRequest.getType());
        }
        if (reportRequest.getDate() != null){
            report.setDate(reportRequest.getDate());
        }
        if (reportRequest.getHeure() != null){
            report.setHeure(reportRequest.getHeure());
        }
        if (reportRequest.getDescription() != null){
            report.setDescription(reportRequest.getDescription());
        }




      return reportRepository.save(report);
   }
   @Override
   public boolean deleteReport(Long id){
      if (!reportRepository.existsById(id)){
         return false;
      }
      reportRepository.deleteById(id);
      return true;
   }
}
