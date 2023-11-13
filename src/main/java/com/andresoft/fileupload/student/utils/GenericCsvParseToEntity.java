package com.andresoft.fileupload.student.utils;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

@Component
public class GenericCsvParseToEntity<Entity> {

    public Set<Entity> parseCsvToEntity(MultipartFile file, Class<Entity> entityClass) throws IOException {
        Set<Entity> entities = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<Entity> csvToBean = new CsvToBeanBuilder<Entity>(reader)
                    .withType(entityClass)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            entities.addAll(csvToBean.parse());
        }
        return entities;
    }
}
