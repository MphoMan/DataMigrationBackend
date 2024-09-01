package com.example.DataMigration.controller;

import com.example.DataMigration.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/excel")
@CrossOrigin(origins = "http://localhost:4200")
public class ExcelController {

    private final ExcelService excelService;

    @Autowired
    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @PostMapping("/read")
    public ResponseEntity<?> readExcel(@RequestParam("file") MultipartFile file) throws IOException {
        // Check if the file has already been uploaded
        boolean isFileAlreadyUploaded = excelService.isFileAlreadyUploaded(file);

        if (isFileAlreadyUploaded) {
            // Return a conflict response if the file already exists
            return ResponseEntity.status(HttpStatus.CONFLICT).body("File already exists in the database.");
        }

        // Process the file if it's not already uploaded
        List<Map<String, String>> data = excelService.readExcel(file);
        return ResponseEntity.ok(data);
    }
}
