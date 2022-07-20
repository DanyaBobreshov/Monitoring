package com.example.Monitoring.service;

import com.example.Monitoring.model.Division;
import com.example.Monitoring.model.FourTable;
import com.example.Monitoring.model.Incident;
import lombok.RequiredArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExelWorkerService {
    private final AppFourTableService appFourTableService;
    private final DivisionService divisionService;
    private final AppFourMenuService appFourMenuService;

    public void createBook(){
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheetALL=workbook.createSheet("all");
        makeAllList(sheetALL);
        makeDivisionList(workbook);
        try (FileOutputStream out=new FileOutputStream(new File("C:\\Начало\\Отчеты\\Приложение4.xls"))){
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Эксель класс исполнен");
    }

    private void makeDivisionList(HSSFWorkbook workbook) {
        List<Division> divisionList=divisionService.list(null);
        for(Division division:divisionList){
            HSSFSheet sheetDivision=workbook.createSheet(division.getTitle());
            makeIncidentList(sheetDivision, division);
        }
    }

    private void makeIncidentList(HSSFSheet sheetDivision, Division division) {
        List<Incident> incidents=appFourMenuService.listByDivisionDate(division.getTitle());
        int rowNum=0;

        Row row=sheetDivision.createRow(rowNum);
        row.createCell(2).setCellValue("Изделия находящиеся в ремонте более 60 суток");
        row.createCell(5).setCellValue(division.getTitle());
        rowNum++;

        row=sheetDivision.createRow(rowNum);
        row.createCell(1).setCellValue("Наименование");
        row.createCell(2).setCellValue("Серийный номер");
        row.createCell(3).setCellValue("Описание");
        row.createCell(4).setCellValue("Дата выявления");
        row.createCell(5).setCellValue("Предприятие");
        row.createCell(6).setCellValue("Оформленные документы");
        rowNum++;
        for (Incident incident:incidents){
            row=sheetDivision.createRow(rowNum);
            row.createCell(1).setCellValue(incident.getProduct().getModelOfTechnical().getTitle());
            row.createCell(2).setCellValue(incident.getProduct().getSerialNumber());
            row.createCell(3).setCellValue(incident.getDescription());
            row.createCell(4).setCellValue(incident.getDateOfIncident());
            row.createCell(5).setCellValue(incident.getIndustrial().getTitle());
            row.createCell(6).setCellValue(incident.getDocument());
            rowNum++;
        }
    }

    private void makeAllList(HSSFSheet sheetALL) {
        List<FourTable> fourTableList=appFourTableService.tableList();
        int rowNum=0;
        Row row = sheetALL.createRow(rowNum);
        row.createCell(3).setCellValue("Приложение 4");
        rowNum++;
        row=sheetALL.createRow(rowNum);
        row.createCell(1).setCellValue("ОВУ");
        row.createCell(2).setCellValue("Всего");
        row.createCell(3).setCellValue("Всего гарантийных");
        row.createCell(4).setCellValue("Гарантийных более 60 суток");
        row.createCell(5).setCellValue("Всего не гарантийных");
        row.createCell(6).setCellValue("не гарантийных более 60 суток");
        rowNum++;

        for(FourTable fourTable:fourTableList){
            row=sheetALL.createRow(rowNum);
            row.createCell(1).setCellValue(fourTable.getDivision());
            row.createCell(2).setCellValue(fourTable.getAll());
            row.createCell(3).setCellValue(fourTable.getGarantAll());
            row.createCell(4).setCellValue(fourTable.getGarantDate());
            row.createCell(5).setCellValue(fourTable.getNonGarantAll());
            row.createCell(6).setCellValue(fourTable.getNonGarantDate());
            rowNum++;
        }
    }


}
