package com.example.DataMigration.service;

import com.example.DataMigration.model.PlanningData;
import com.example.DataMigration.repository.PlanningDataRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExcelService {

    private final PlanningDataRepository planningDataRepository;

    @Autowired
    public ExcelService(PlanningDataRepository planningDataRepository) {
        this.planningDataRepository = planningDataRepository;
    }

    public boolean isFileAlreadyUploaded(MultipartFile file) throws IOException {
        String fileChecksum = DigestUtils.md5Hex(file.getInputStream());
        return planningDataRepository.existsByFileChecksum(fileChecksum);
    }

    public List<Map<String, String>> readExcel(MultipartFile file) throws IOException {
        List<Map<String, String>> dataList = new ArrayList<>();

        // Calculate the checksum for the file
        String fileChecksum = DigestUtils.md5Hex(file.getInputStream());

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0); // Assuming the first row is the header

            // Get all the column names
            List<String> columnNames = new ArrayList<>();
            for (Cell cell : headerRow) {
                columnNames.add(cell.getStringCellValue());
            }

            // Iterate through each row in the sheet after the header row
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                PlanningData planningData = new PlanningData();

                // Populate PlanningData entity
                planningData.setNewLinkNumber(getCellValue(row.getCell(columnNames.indexOf("NEW Link Number"))));
                planningData.setSiteAHeight(getCellValue(row.getCell(columnNames.indexOf("Site  A height"))));
                planningData.setSiteBHeight(getCellValue(row.getCell(columnNames.indexOf("Site  B height"))));
                planningData.setChannels(getCellValue(row.getCell(columnNames.indexOf("Channels"))));
                planningData.setDestinationSite(getCellValue(row.getCell(columnNames.indexOf("Destination Site"))));
                planningData.setSubBand(getCellValue(row.getCell(columnNames.indexOf("Sub band"))));
                planningData.setHopLengthKm(getCellValue(row.getCell(columnNames.indexOf("Hop Length(km)"))));
                planningData.setNewConfig(getCellValue(row.getCell(columnNames.indexOf("New Config"))));
                planningData.setThermalFadeMarginB(getCellValue(row.getCell(columnNames.indexOf("Thermal Fade Margin(dB) B"))));
                planningData.setRegion(getCellValue(row.getCell(columnNames.indexOf("Region"))));
                planningData.setBudget(getCellValue(row.getCell(columnNames.indexOf("Budget"))));
                planningData.setAvailabilityA(getCellValue(row.getCell(columnNames.indexOf("Availability A"))));
                planningData.setSourceSite(getCellValue(row.getCell(columnNames.indexOf("Source Site"))));
                planningData.setThermalFadeMarginA(getCellValue(row.getCell(columnNames.indexOf("Thermal Fade Margin(dB) A"))));
                planningData.setAvailabilityB(getCellValue(row.getCell(columnNames.indexOf("Availability B"))));
                planningData.setAtollIdSiteB(getCellValue(row.getCell(columnNames.indexOf("Atoll ID site B"))));
                planningData.setApproval(getCellValue(row.getCell(columnNames.indexOf("Approval"))));
                planningData.setListName(getCellValue(row.getCell(columnNames.indexOf("List Name"))));
                planningData.setAtollIdSiteA(getCellValue(row.getCell(columnNames.indexOf("Atoll ID site A"))));
                planningData.setFileChecksum(fileChecksum); // Set the fileChecksum

                // Save to database
                planningDataRepository.save(planningData);
            }
        }

        return dataList;
    }

    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
