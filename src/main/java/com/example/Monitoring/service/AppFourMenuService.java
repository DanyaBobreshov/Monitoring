package com.example.Monitoring.service;

import com.example.Monitoring.model.Incident;
import com.example.Monitoring.repository.IncidentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppFourMenuService {
    private final IncidentRepo incidentRepo;
    private LocalDateTime dateBefore=LocalDateTime.now().minusDays(60);

    public List<Incident> listByDivision(String title){
        if(title!=null){
            return incidentRepo.findByProductRegimentDivisionTitleContains(title);
        }else {
            return incidentRepo.findAll();
        }
    }

    public List<Incident> listByProducts(String title){
        if(title!=null){
            return incidentRepo.findByProductModelOfTechnicalTitleContains(title);
        }else {
            return incidentRepo.findAll();
        }
    }

    public List<Incident> listByIndustrials(String title){
        if(title!=null){
            return incidentRepo.findByIndustrialTitleContains(title);
        }else {
            return incidentRepo.findAll();
        }
    }

    public List<Incident> listByGarant(){
        return incidentRepo.findByIsGarantTrue();
    }

    public List<Incident> listByNonGarant() {
        return incidentRepo.findByIsGarantFalse();
    }

    public List<Incident> listByDivisionDate(String title){
        if(title!=null){
            return incidentRepo.findByProductRegimentDivisionTitleContainsAndDateOfIncidentBefore(title, dateBefore);
        }else {
            return incidentRepo.findByDateOfIncidentBefore(dateBefore);
        }
    }

    public List<Incident> listByProductsDate(String title){
        if(title!=null){
            return incidentRepo.findByProductModelOfTechnicalTitleContainsAndDateOfIncidentBefore(title, dateBefore);
        }else {
            return incidentRepo.findByDateOfIncidentBefore(dateBefore);
        }
    }

    public List<Incident> listByIndustrialsDate(String title){
        if(title!=null){
            return incidentRepo.findByIndustrialTitleContainsAndDateOfIncidentBefore(title, dateBefore);
        }else {
            return incidentRepo.findByDateOfIncidentBefore(dateBefore);
        }
    }

    public List<Incident> listByGarantDate(){
        return incidentRepo.findByIsGarantTrueAndDateOfIncidentBefore(dateBefore);
    }

    public List<Incident> listByNonGarantDate() {
        return incidentRepo.findByIsGarantFalseAndDateOfIncidentBefore(dateBefore);
    }
}
