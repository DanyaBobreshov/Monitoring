package com.example.Monitoring.service;

import com.example.Monitoring.model.Product;
import com.example.Monitoring.repository.ModelOfTechnicalRepo;
import com.example.Monitoring.repository.ProductRepo;
import com.example.Monitoring.repository.RegimentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final ModelOfTechnicalRepo modelOfTechnicalRepo;
    private final RegimentRepo regimentRepo;

    public List<Product> list(String title){
        if(title!=null){
            return productRepo.findBySerialNumberContains(title);
        }else {
            return productRepo.findAll();
        }
    }

    public void save(Product product){
        productRepo.save(product);
    }

    public void correct(Product product, String serialNumber, String modelOfTechnical, String regiment,
                        LocalDateTime date){
        product.setSerialNumber(serialNumber);
        product.setModelOfTechnical(modelOfTechnicalRepo.findByTitle(modelOfTechnical).orElse(null));
        product.setRegiment(regimentRepo.findByTitle(regiment).orElse(null));
        product.setDateOfProduction(date);
        productRepo.save(product);
    }
    public void delete(Long id){
        Product product = productRepo.findById(id).orElse(null);
        if(product!=null){
            productRepo.delete(product);
        }
    }

    public Product findById(Long id){
        return productRepo.findById(id).orElse(null);
    }
}
