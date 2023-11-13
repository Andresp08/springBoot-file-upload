package com.andresoft.fileupload.student.controller;

import com.andresoft.fileupload.student.service.StudentService;
import com.opencsv.exceptions.CsvValidationException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    @Operation(
            summary = "Upload CSV file for Students",
            description = "Upload a CSV file to create students."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CSV file successfully processed"),
            @ApiResponse(responseCode = "400", description = "Invalid CSV file or request")
    })
    public ResponseEntity<Integer> uploadStudents(
            @Parameter(description = "CSV file containing student data", required = true)
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        return ResponseEntity.ok(service.uploadStudents(file));
    }
}
