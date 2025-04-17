package com.arsii.pfe.Controller;

import com.arsii.pfe.Dto.RequestDetailReport;
import com.arsii.pfe.Dto.RequestReport;
import com.arsii.pfe.Dto.ResponseDetailReport;
import com.arsii.pfe.Dto.ResponseReport;
import com.arsii.pfe.Service.DetailReportService;
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
@RequestMapping("api/arsii/detailReport")
@RequiredArgsConstructor
public class DetailReportController {
    @Autowired
    private DetailReportService detailReportService;
    private Collections collections;

    @GetMapping("")
    public ResponseEntity<List<ResponseDetailReport>> getAllDetailReport(){
        List<ResponseDetailReport> detailReports = detailReportService.getAllDetailReport();
        return ResponseEntity.ok(detailReports);
    }
    @PostMapping("")
    public ResponseEntity<Object> addDetailReport(@RequestBody @Valid RequestDetailReport request){
        detailReportService.createDetailReport(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                collections.singletonMap("message","save success !"));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseDetailReport> getAllDetailReportById(@PathVariable Long id){
        return ResponseEntity.ok(detailReportService.getDetailDetailReportById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateDetailReport(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestDetailReport request ){
        detailReportService.updateDetailReport(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deletedDetailReport(@PathVariable Long id){
        boolean deletedDetailReport = detailReportService.deleteDetailReport(id);
        if (deletedDetailReport){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "report not exist"));
    }

}


