package com.arsii.pfe.Service;

import com.arsii.pfe.Dto.RequestDocteur;
import com.arsii.pfe.Dto.RequestReport;
import com.arsii.pfe.Dto.ResponseDocteur;
import com.arsii.pfe.Dto.ResponseReport;
import com.arsii.pfe.Entities.Docteur;
import com.arsii.pfe.Entities.Report;

import java.util.List;

public interface ReportService {
    List<ResponseReport> getAllReport();
    boolean deleteReport(Long id);
    void createReport(RequestReport reportRequest);
    Report updateReport(Long id, RequestReport reportRequest);
    ResponseReport getReportById(Long id);
}

