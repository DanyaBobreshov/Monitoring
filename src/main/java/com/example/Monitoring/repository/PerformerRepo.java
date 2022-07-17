package com.example.Monitoring.repository;

import com.example.Monitoring.model.Performer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PerformerRepo extends JpaRepository<Performer, Long> {
    List<Performer> findByNameContains (String name);
    Optional<Performer> findByName(String name);
}