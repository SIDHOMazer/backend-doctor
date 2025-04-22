package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.DetailReport;
import com.arsii.pfe.Entities.Report;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDetailReport {
    Long id;
    Long reportId;
    String Currenty; //Acuellement(maladie,psyclogie)
    String SurgicalHistory; // tare5 jrahy
    String TraumaHistory; //nawa3 el accident
    String HealthHistory;
    String FamilyHealthHistory;
    String Autre; //Cystite, Infection
    Boolean status;

    Instant createdAt;
    Instant updateAt;
    public static ResponseDetailReport makeDetailReport(DetailReport detailreport) {
        return ResponseDetailReport.builder()
                .id(detailreport.getId())
                .reportId(detailreport.getReport().getId())
                .Currenty(detailreport.getCurrenty())
                .SurgicalHistory(detailreport.getSurgicalHistory())
                .TraumaHistory(detailreport.getTraumaHistory())
                .HealthHistory(detailreport.getHealthHistory())
                .status(detailreport.getStatus())
                .createdAt(detailreport.getCreatedAt())
                .updateAt(detailreport.getUpdateAt())
                .FamilyHealthHistory(detailreport.getFamilyHealthHistory())
                .Autre(detailreport.getTraumaHistory())

                .build();
    }
}
