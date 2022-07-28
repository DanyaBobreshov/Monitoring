package com.example.Monitoring.repository;

import com.example.Monitoring.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IncidentRepo extends JpaRepository<Incident, Long> {
    List<Incident> findByDateOfIncidentContains(LocalDateTime dateTime);
    List<Incident> findByProductRegimentDivisionTitleContains(String title);
    List<Incident> findByProductModelOfTechnicalTitleContains(String title);
    List<Incident> findByIndustrialTitleContains(String title);
    List<Incident> findByIsGarantTrue();
    List<Incident> findByIsGarantFalse();

    List<Incident> findByProductRegimentDivisionTitleContainsAndDateOfIncidentBefore(String title, LocalDateTime dateTime);
    List<Incident> findByDateOfIncidentBefore(LocalDateTime dateTime);
    List<Incident> findByProductModelOfTechnicalTitleContainsAndDateOfIncidentBefore(String title, LocalDateTime dateBefore);
    List<Incident> findByIndustrialTitleContainsAndDateOfIncidentBefore(String title, LocalDateTime dateBefore);
    List<Incident> findByIsGarantTrueAndDateOfIncidentBefore(LocalDateTime dateBefore);
    List<Incident> findByIsGarantFalseAndDateOfIncidentBefore(LocalDateTime dateBefore);

    List<Incident> findByProductRegimentDivisionTitleContainsAndIsGarantTrue(String title);
    List<Incident> findByProductRegimentDivisionTitleContainsAndIsGarantFalse(String title);
    List<Incident> findByProductRegimentDivisionTitleContainsAndDateOfIncidentBeforeAndIsGarantTrue(String title, LocalDateTime dateBefore);
    List<Incident> findByProductRegimentDivisionTitleContainsAndDateOfIncidentBeforeAndIsGarantFalse(String title, LocalDateTime dateBefore);

    List<Incident> findByDateOfIncidentContainsAndProductRegimentDivisionTitle(LocalDateTime dateTime, String divisionTitle);

    List<Incident> findByProductModelOfTechnicalTitleContainsAndProductRegimentDivisionTitleContains(String title, String divisionTitle);
    List<Incident> findByIndustrialTitleContainsAndProductRegimentDivisionTitleContains(String title, String divisionTitle);
    List<Incident> findByIsGarantTrueAndProductRegimentDivisionTitleContains(String divisionTitle);
    List<Incident> findByIsGarantFalseAndProductRegimentDivisionTitleContains(String divisionTitle);
    List<Incident> findByProductModelOfTechnicalTitleContainsAndDateOfIncidentBeforeAndProductRegimentDivisionTitleContains(String title, LocalDateTime dateBefore, String divisionTitle);
    List<Incident> findByDateOfIncidentBeforeAndProductRegimentDivisionTitleContains(LocalDateTime dateBefore, String divisionTitle);
    List<Incident> findByIndustrialTitleContainsAndDateOfIncidentBeforeAndProductRegimentDivisionTitleContains(String title, LocalDateTime dateBefore, String divisionTitle);
    List<Incident> findByIsGarantTrueAndDateOfIncidentBeforeAndProductRegimentDivisionTitleContains(LocalDateTime dateBefore, String divisionTitle);
    List<Incident> findByIsGarantFalseAndDateOfIncidentBeforeAndProductRegimentDivisionTitleContains(LocalDateTime dateBefore, String divisionTitle);
}
