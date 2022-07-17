package com.example.Monitoring.service;

import com.example.Monitoring.model.Incident;
import com.example.Monitoring.repository.IncidentRepo;
import com.example.Monitoring.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentService {
    private final IncidentRepo incidentRepo;
    private final ProductRepo productRepo;

    public List<Incident>list(LocalDateTime dateTime){
        if(dateTime!=null){
            return incidentRepo.findByDateOfIncidentContains(dateTime);
        }else {
            return incidentRepo.findAll();
        }
    }

    public void save(Incident incident){
        incidentRepo.save(incident);
    }

    public void correct(Incident incident, Long product, Boolean isGarant, String description, LocalDateTime dateTime){
        incident.setProduct(productRepo.findById(product).orElse(null));
        incident.setDescription(description);
        incident.setIsGarant(isGarant);
        incident.setDateOfIncident(dateTime);
        save(incident);
    }

    public void delete(Long id){
        Incident incident = incidentRepo.findById(id).orElse(null);
        if(incident!=null){
            incidentRepo.delete(incident);
        }
    }

    public Incident findById(Long id){
        return incidentRepo.findById(id).orElse(null);
    }

}