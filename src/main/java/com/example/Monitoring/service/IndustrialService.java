package com.example.Monitoring.service;

import com.example.Monitoring.model.Industrial;
import com.example.Monitoring.repository.IndustrialRepo;
import com.example.Monitoring.repository.PerformerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndustrialService {
    private final IndustrialRepo industrialRepo;
    private final PerformerRepo performerRepo;

    public List<Industrial> list(String title){
        if(title!=null){
            return industrialRepo.findByTitleContains(title);
        }else
        return industrialRepo.findAll();
    }

    public void save(Industrial industrial){
        industrialRepo.save(industrial);
    }

    public void correct(Industrial industrial, String title, String address,
                        String director, String directorName, String contactManager){
        industrial.setTitle(title);
        industrial.setAddress(address);
        industrial.setDirector(director);
        industrial.setDirectorName(directorName);
        industrial.setContactManager(performerRepo.findByName(contactManager).orElse(null));
        save(industrial);
    }

    public void delete(Long id){
        Industrial industrial = industrialRepo.findById(id).orElse(null);
        if(industrial!=null){
            industrialRepo.delete(industrial);
        }
    }

    public Industrial findById(Long id){
        return industrialRepo.findById(id).orElse(null);
    }

    public Industrial findByTitle(String title){
        return industrialRepo.findByTitle(title).orElse(null);
    }
}
