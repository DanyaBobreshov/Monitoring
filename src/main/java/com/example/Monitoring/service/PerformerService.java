package com.example.Monitoring.service;

import com.example.Monitoring.model.Performer;
import com.example.Monitoring.repository.PerformerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformerService {
    private final PerformerRepo performerRepo;

    public List<Performer>list(String title){
        if(title!=null) return performerRepo.findByNameContains(title);
        return performerRepo.findAll();
    }

    public void correct(Performer performer, String name, String phoneNumber, String reservePhoneNumber){
        performer.setName(name);
        performer.setPhoneNumber(phoneNumber);
        performer.setReservePhoneNumber(reservePhoneNumber);
        save(performer);
    }

    public void save(Performer performer){
        performerRepo.save(performer);
    }

    public Performer findById(Long id){
        return performerRepo.findById(id).orElse(null);
    }

    public Performer findByName(String name){
        return performerRepo.findByName(name);
    }

    public void delete(Long id){
        Performer performer =findById(id);
        if(performer!=null){
            performerRepo.delete(performer);
        }
    }
}
