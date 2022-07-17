package com.example.Monitoring.service;

import com.example.Monitoring.model.ModelOfTechnical;
import com.example.Monitoring.repository.ModelOfTechnicalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelOfTechnicalService {
    private final ModelOfTechnicalRepo modelOfTechnicalRepo;
    public List<ModelOfTechnical> list(String title){
        if(title!=null){
            return modelOfTechnicalRepo.findByTitleContains(title);
        }else {
            return modelOfTechnicalRepo.findAll();
        }
    }

    public void save(ModelOfTechnical modelOfTechnical){
        modelOfTechnicalRepo.save(modelOfTechnical);
    }

    public void correct(ModelOfTechnical modelOfTechnical,
                        String title, String description){
        modelOfTechnical.setTitle(title);
        modelOfTechnical.setDescription(description);
        save(modelOfTechnical);
    }

    public void delete(Long id){
        ModelOfTechnical modelOfTechnical=modelOfTechnicalRepo.findById(id).orElse(null);
        if(modelOfTechnical!=null){
            modelOfTechnicalRepo.delete(modelOfTechnical);
        }
    }

    public ModelOfTechnical findById(Long id){
        return modelOfTechnicalRepo.findById(id).orElse(null);
    }

    public ModelOfTechnical findByTitle(String title){
        return modelOfTechnicalRepo.findByTitle(title).orElse(null);
    }
}
