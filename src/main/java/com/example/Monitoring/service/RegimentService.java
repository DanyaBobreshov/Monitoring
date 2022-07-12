package com.example.Monitoring.service;

import com.example.Monitoring.model.Division;
import com.example.Monitoring.model.Regiment;
import com.example.Monitoring.repository.DivisionRepo;
import com.example.Monitoring.repository.RegimentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegimentService {
    private final DivisionRepo divisionRepo;
    private final RegimentRepo regimentRepo;

    public List<Regiment> list(String title){
        if(title!=null){
            return regimentRepo.findByTitleContains(title);
        }
        return regimentRepo.findAll();
    }

    public void save(Regiment regiment){
        regimentRepo.save(regiment);
    }

    public void correct(Regiment regiment, String address, String title, String divisionTitle){
        Division division = divisionRepo.findByTitle(divisionTitle);
        regiment.setAddress(address);
        regiment.setTitle(title);
        regiment.setDivision(division);
    }

    public Regiment findById(Long id){
        return regimentRepo.findById(id).orElse(null);
    }

    public Regiment findByTitle(String title){
        return (Regiment) regimentRepo.findByTitle(title);
    }

    public void delete(Long id){
        Regiment regiment = findById(id);
        if(regiment!=null){
            regimentRepo.delete(regiment);
        }
    }
}
