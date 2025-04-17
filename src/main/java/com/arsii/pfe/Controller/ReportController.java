package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestReport;
import com.arsii.pfe.Dto.ResponseReport;
import com.arsii.pfe.Dto.ResponseReport;
import com.arsii.pfe.Service.ReportService;
import com.arsii.pfe.Service.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/arsii/report")
@RequiredArgsConstructor
public class ReportController {
    @Autowired
    private ReportService reportService;
    private Collections collections;

    @GetMapping("")
    public ResponseEntity<List<ResponseReport>> getAllReport(){
        List<ResponseReport> reports = reportService.getAllReport();
        return ResponseEntity.ok(reports);
    }
    @PostMapping("")
    public ResponseEntity<Object> addReport(@RequestBody @Valid RequestReport request){
        reportService.createReport(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                collections.singletonMap("message","save success !"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseReport> getAllReportById(@PathVariable Long id){
        return ResponseEntity.ok(reportService.getReportById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateReport(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestReport request ){
        reportService.updateReport(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deletedReport(@PathVariable Long id){
        boolean deletedReport = reportService.deleteReport(id);
        if (deletedReport){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "report not exist"));
    }

}


