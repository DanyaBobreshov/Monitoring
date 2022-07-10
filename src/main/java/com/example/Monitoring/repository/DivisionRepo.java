package com.example.Monitoring.repository;

import com.example.Monitoring.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DivisionRepo extends JpaRepository<Division, Long> {
    List<Division> findByTittleContains(String title);
    Optional<Division> findByTitle(String title);
}
