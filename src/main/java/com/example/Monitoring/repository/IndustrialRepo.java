package com.example.Monitoring.repository;

import com.example.Monitoring.model.Industrial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IndustrialRepo extends JpaRepository<Industrial, Long> {
    List<Industrial> findByTitleContains(String title);
    Optional <Industrial> findByTitle(String title);
}
