package com.example.Monitoring.service;

import com.example.Monitoring.model.Division;
import com.example.Monitoring.model.Performer;
import com.example.Monitoring.repository.DivisionRepo;
import com.example.Monitoring.repository.PerformerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DivisionService {
    private final DivisionRepo divisionRepo;
    private final PerformerRepo performerRepo;

    public List<Division> list(String  title){
        if(title!=null){
            return divisionRepo.findByTitleContains(title);
        }
        return divisionRepo.findAll();
    }

    public void save(Division division){
        divisionRepo.save(division);
    }

    public void correct(Division division, String title, String TOSOfficerString){
        division.setTitle(title);
        Performer TOSOfficer=performerRepo.findByName(TOSOfficerString).orElse(null);
        division.setTOSOfficer(TOSOfficer);
        save(division);
    }

    public Division findById(Long id){
        return divisionRepo.findById(id).orElse(null);
    }
    public Division findByTitle(String title){
        return divisionRepo.findByTitle(title).orElse(null);
    }
    public void delete(Long id){
        Division division=divisionRepo.findById(id).orElse(null);
        if(division!=null){
            divisionRepo.delete(division);
        }
    }
}
