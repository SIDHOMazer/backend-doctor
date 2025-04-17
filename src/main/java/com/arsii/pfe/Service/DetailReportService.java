package com.arsii.pfe.Service;

import com.arsii.pfe.Dto.RequestDetailReport;
import com.arsii.pfe.Dto.RequestReport;
import com.arsii.pfe.Dto.ResponseDetailReport;
import com.arsii.pfe.Dto.ResponseReport;
import com.arsii.pfe.Entities.DetailReport;
import com.arsii.pfe.Entities.Report;

import java.util.List;

public interface DetailReportService {
    List<ResponseDetailReport> getAllDetailReport();
    boolean deleteDetailReport(Long id);
    void createDetailReport(RequestDetailReport  detailreportRequest);
    DetailReport updateDetailReport(Long id, RequestDetailReport detailreportRequest);
    ResponseDetailReport getDetailDetailReportById(Long id);
}

