package com.example.Monitoring.service;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWorker {
    /*
    public static void excelPrinter(Invoice invoice){
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("invoice");
        List<Product> products=invoice.getProducts();
        int rowNum=0;
        Row row=sheet.createRow(rowNum);
        row.createCell(10).setCellValue("Экз.№__");
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(10).setCellValue("Форма №2");
        rowNum++;
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(4).setCellValue("Наряд №");
        row.createCell(5).setCellValue(invoice.getTitle());
        rowNum++;
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(8).setCellValue("Дата");
        row.createCell(9).setCellValue(invoice.getDateOfCreate());
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(4).setCellValue("Войсковая часть 52686");
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(4).setCellValue("Действителен по");
        row.createCell(5).setCellValue(invoice.getDateOfOut());
        rowNum++;
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(1).setCellValue("Выдача имущества по вт. и чт. с 10:00 до 17:00");
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(1).setCellValue("Основание");
        row.createCell(3).setCellValue("Грузоотправитель");
        row.createCell(5).setCellValue("Грузополучатель");
        row.createCell(7).setCellValue("Транспорт");
        row.createCell(9).setCellValue("Транспортный документ");
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(3).setCellValue("Войсковая часть 41101, г.Мытищи, Московская обл., Рупассовский переулок д.1");
        row.createCell(5).setCellValue(invoice.getRegimentIn().getName());
        row.createCell(7).setCellValue(invoice.getTransfer().getTitle());
        rowNum++;
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(1).setCellValue("№ п/п");
        row.createCell(3).setCellValue("Наименование изделия");
        row.createCell(6).setCellValue("код");
        row.createCell(7).setCellValue("номер");
        row.createCell(8).setCellValue("выдать");
        row.createCell(9).setCellValue("выдано");
        row.createCell(10).setCellValue("примечание");
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(1).setCellValue("1");
        row.createCell(3).setCellValue("2");
        row.createCell(6).setCellValue("3");
        row.createCell(7).setCellValue("4");
        row.createCell(8).setCellValue("5");
        row.createCell(9).setCellValue("6");
        row.createCell(10).setCellValue("7");
        rowNum++;
        int kount=1;
        for(Product oneProduct:products){
            row=sheet.createRow(rowNum);
            row.createCell(1).setCellValue(kount);
            row.createCell(3).setCellValue(oneProduct.getTitle());
            row.createCell(8).setCellValue(invoice.getAmount().get(kount-1));
            rowNum++;
            kount++;
        }
        row=sheet.createRow(rowNum);
        row.createCell(1).setCellValue("Итого "+kount+" наименованрий");
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(1).setCellValue("Примечания");
        rowNum++;
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(1).setCellValue(invoice.getPerformerOne().getRang());
        row.createCell(7).setCellValue(invoice.getPerformerOne().getName());
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(1).setCellValue(invoice.getPerformerTho().getRang());
        row.createCell(7).setCellValue(invoice.getPerformerTho().getName());
        rowNum++;
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(1).setCellValue("М.П.");
        rowNum++;
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(1).setCellValue("Выдал");
        rowNum++;
        row=sheet.createRow(rowNum);
        row.createCell(1).setCellValue("Получил");
        rowNum++;

        try (FileOutputStream out=new FileOutputStream(new File("C:\\ExcelInvoice.xls"))){
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Эксель класс исполнен");
    }

     */
}
