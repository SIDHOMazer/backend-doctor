package com.arsii.pfe.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDetailReport {
    Long id;
    Long reportId;
    String Currenty; //Acuellement(maladie,psyclogie)
    String SurgicalHistory; // tare5 jrahy
    String TraumaHistory; //nawa3 el accident
    String HealthHistory;
    String FamilyHealthHistory;
    String Autre; //Cystite, Infection

}
