package com.example.Monitoring.repository;

import com.example.Monitoring.model.Division;
import com.example.Monitoring.model.Regiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegimentRepo extends JpaRepository<Regiment,Long> {
    List<Regiment> findByTitleContains(String title);
    Optional <Regiment> findByTitle(String title);
    List<Regiment> findByDivisionContains(String title);
}
