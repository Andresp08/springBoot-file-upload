package com.andresoft.fileupload.student.service;

import com.andresoft.fileupload.student.utils.GenericCsvParseToEntity;
import com.andresoft.fileupload.student.repository.StudentRepository;
import com.andresoft.fileupload.student.model.Student;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final GenericCsvParseToEntity<Student> csvParser;

    public Integer uploadStudents(MultipartFile file) throws IOException {
        Set<Student> students = csvParser.parseCsvToEntity(file, Student.class);
        repository.saveAll(students);
        return students.size();
    }
}
