package com.arsii.pfe.Servicelmpl;

import com.arsii.pfe.Dto.RequestDetailReport;
import com.arsii.pfe.Dto.RequestReport;
import com.arsii.pfe.Dto.ResponseDetailReport;
import com.arsii.pfe.Dto.ResponseReport;
import com.arsii.pfe.Entities.DetailReport;
import com.arsii.pfe.Entities.Patient;
import com.arsii.pfe.Entities.Report;
import com.arsii.pfe.Repository.DetailReportRepository;
import com.arsii.pfe.Repository.PatientRepository;
import com.arsii.pfe.Repository.ReportRepository;
import com.arsii.pfe.Service.DetailReportService;
import com.arsii.pfe.Service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetailReportServiceImpl implements DetailReportService {
   @Autowired
   private DetailReportRepository detailReportRepository;
   @Autowired
   private ReportRepository reportRepository;

   @Override
   public List<ResponseDetailReport> getAllDetailReport(){
      List<DetailReport> detailReports = detailReportRepository.findAll();
      List<ResponseDetailReport> detailReportFormated = new ArrayList<>();
      for (DetailReport detailReport : detailReports) {
         ResponseDetailReport detailReport1 = ResponseDetailReport.makeDetailReport(detailReport);
         detailReportFormated.add(detailReport1);
      }
      return detailReportFormated;
   }


   @Override
   public void createDetailReport(RequestDetailReport detailReportRequest){
       Report report = reportRepository.findById(detailReportRequest.getReportId()).orElseThrow();
       DetailReport detailReport= DetailReport.builder()
               .report(report)
               .Currenty(detailReportRequest.getCurrenty())
               .SurgicalHistory(detailReportRequest.getSurgicalHistory())
               .TraumaHistory(detailReportRequest.getTraumaHistory())
               .HealthHistory(detailReportRequest.getHealthHistory())
               .FamilyHealthHistory(detailReportRequest.getFamilyHealthHistory())
               .Autre(detailReportRequest.getAutre())
               .status(true)
               .build();

   detailReportRepository.save(detailReport);

   }


   @Override
   public ResponseDetailReport getDetailDetailReportById(Long id){
      Optional<DetailReport> detailReport = detailReportRepository.findById(id);
      return ResponseDetailReport.makeDetailReport(detailReport.get());
   }
   @Override
   public DetailReport updateDetailReport(Long id, RequestDetailReport detailReportRequest ) {
        DetailReport detailReport = detailReportRepository.findById(id).orElseThrow();

        if (detailReportRequest.getCurrenty() != null) {
            detailReport.setCurrenty(detailReportRequest.getCurrenty());
        }
        if (detailReportRequest.getSurgicalHistory() != null) {
            detailReport.setSurgicalHistory(detailReportRequest.getSurgicalHistory());
        }
        if (detailReportRequest.getTraumaHistory() != null) {
            detailReport.setTraumaHistory(detailReportRequest.getTraumaHistory());
        }
       if (detailReportRequest.getHealthHistory() != null) {
           detailReport.setHealthHistory(detailReportRequest.getHealthHistory());
       }
       if (detailReportRequest.getFamilyHealthHistory() != null) {
           detailReport.setFamilyHealthHistory(detailReportRequest.getFamilyHealthHistory());
       }
       if (detailReportRequest.getAutre() != null) {
           detailReport.setAutre(detailReportRequest.getAutre());
       }
       if (detailReportRequest.getStatus() != null) {
           detailReport.setStatus(detailReportRequest.getStatus());
         }
        return detailReportRepository.save(detailReport);
    }
   @Override
   public boolean deleteDetailReport(Long id){
      if (!detailReportRepository.existsById(id)){
         return false;
      }
      detailReportRepository.deleteById(id);
      return true;
   }
}
