package com.arsii.pfe.Dto;

import com.arsii.pfe.Entities.DetailReport;
import com.arsii.pfe.Entities.Docteur;
import com.arsii.pfe.Entities.Report;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseReport {
    Long id;
    String file;
    Long patientId;
    String Type;
    String Date;
    String Heure;
    String Description;
    String auteur;
    Boolean status;

    Instant createdAt;
    Instant updateAt;
    List<ResponseDetailReport> detailReports;
    ResponsePatient patient;
    public static ResponseReport makeReport(Report report) {
        return ResponseReport.builder()
                .id(report.getId())
                .file(report.getFile())
                .patient(ResponsePatient.makePatientOnly(report.getPatient()))
                .patientId(report.getPatient().getId())
                .Type(report.getType())
                .Date(report.getDate())
                .Heure(report.getHeure())
                .Description(report.getDescription())
                .detailReports(
                        report.getDetailReports().stream().map(ResponseDetailReport::makeDetailReport)
                                .collect(Collectors.toList())
                )
                .status(report.getStatus())
                .createdAt(report.getCreatedAt())
                .updateAt(report.getUpdateAt())
                .build();
    }
}
