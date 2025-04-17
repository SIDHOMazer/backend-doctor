package com.arsii.pfe.Repository;
import com.arsii.pfe.Entities.DetailReport;
import com.arsii.pfe.Entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailReportRepository extends JpaRepository<DetailReport, Long> {
}
