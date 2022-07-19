package com.example.Monitoring.service;

import com.example.Monitoring.model.Division;
import com.example.Monitoring.model.FourTable;
import com.example.Monitoring.model.Incident;
import com.example.Monitoring.repository.IncidentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

@Service
@RequiredArgsConstructor
public class AppFourTableService {
    private final IncidentRepo incidentRepo;
    private final DivisionService divisionService;
    private ArrayList<Division> divisionList;
    private LocalDateTime dateBefore=LocalDateTime.now().minusDays(60);


    public ArrayList<FourTable> tableList(){
        divisionList= (ArrayList<Division>) divisionService.list(null);
        ArrayList<FourTable>fourList=new ArrayList<>();
        for(Division division:divisionList){
            FourTable fourTable=new FourTable();
            makeFourTable(fourTable, division);
            fourList.add(fourTable);
        }
        FourTable last=makeLastFourTable(fourList);
        fourList.add(last);
        return fourList;
    }

    public void makeFourTable(FourTable fourTable,Division division){
        fourTable.setGarantAll((long) listByDivisionGarant(division.getTitle()).size());
        fourTable.setDivision(division.getTitle());
        fourTable.setGarantDate((long) listByDivisionDateGarant(division.getTitle()).size());
        fourTable.setNonGarantAll((long) listByDivisionNonGarant(division.getTitle()).size());
        fourTable.setNonGarantDate((long) listByDivisionDateNonGarant(division.getTitle()).size());
        fourTable.setAll((long) incidentRepo.findByProductRegimentDivisionTitleContains(division.getTitle()).size());
    }

    public FourTable makeLastFourTable(ArrayList<FourTable> tableList){
        FourTable last=new FourTable();
        last.setAll(Long.valueOf(0));
        last.setGarantDate(Long.valueOf(0));
        last.setGarantAll(Long.valueOf(0));
        last.setNonGarantDate(Long.valueOf(0));
        last.setNonGarantAll(Long.valueOf(0));
        last.setDivision("ВСЕГО");
        for(FourTable fourTable:tableList){
            last.setAll(last.getAll()+fourTable.getAll());
            last.setGarantAll(last.getGarantAll()+ fourTable.getGarantAll());
            last.setGarantDate(last.getGarantDate()+fourTable.getGarantDate());
            last.setNonGarantAll(last.getNonGarantAll()+ fourTable.getNonGarantAll());
            last.setNonGarantDate(last.getNonGarantDate()+ fourTable.getNonGarantDate());
        }
        return last;
    }

    public List<Incident> listByDivisionGarant(String title){
        if(title!=null){
            return incidentRepo.findByProductRegimentDivisionTitleContainsAndIsGarantTrue(title);
        }else {
            return incidentRepo.findAll();
        }
    }

    public List<Incident> listByDivisionNonGarant(String title){
        if(title!=null){
            return incidentRepo.findByProductRegimentDivisionTitleContainsAndIsGarantFalse(title);
        }else {
            return incidentRepo.findAll();
        }
    }

    public List<Incident> listByDivisionDateGarant(String title){
        if(title!=null){
            return incidentRepo.findByProductRegimentDivisionTitleContainsAndDateOfIncidentBeforeAndIsGarantTrue(title, dateBefore);
        }else {
            return incidentRepo.findByDateOfIncidentBefore(dateBefore);
        }
    }

    public List<Incident> listByDivisionDateNonGarant(String title){
        if(title!=null){
            return incidentRepo.findByProductRegimentDivisionTitleContainsAndDateOfIncidentBeforeAndIsGarantFalse(title, dateBefore);
        }else {
            return incidentRepo.findByDateOfIncidentBefore(dateBefore);
        }
    }

}
