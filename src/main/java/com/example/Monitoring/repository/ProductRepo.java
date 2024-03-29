package com.example.Monitoring.repository;

import com.example.Monitoring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findBySerialNumberContains(String SerialNumber);
    List<Product> findByRegiment(String title);

    List<Product> findBySerialNumberContainsAndRegimentDivisionTitle(String title, String divisionTitle);
    List<Product> findByRegimentDivisionTitle(String divisionTitle);
}
