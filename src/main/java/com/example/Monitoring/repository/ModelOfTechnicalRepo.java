package com.example.Monitoring.repository;

import com.example.Monitoring.model.ModelOfTechnical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ModelOfTechnicalRepo extends JpaRepository<ModelOfTechnical, Long> {
    List<ModelOfTechnical> findByTitleContains(String title);
    Optional <ModelOfTechnical> findByTitle(String title);
}
