package com.example.Monitoring.repository;

import com.example.Monitoring.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IncidentRepo extends JpaRepository<Incident, Long> {
    List<Incident> findByDateOfIncidentContains(LocalDateTime dateTime);
}
