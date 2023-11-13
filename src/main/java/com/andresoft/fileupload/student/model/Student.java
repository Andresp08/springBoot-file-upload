package com.andresoft.fileupload.student.model;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @CsvBindByName(column = "first_name")
    private String firstname;

    @CsvBindByName(column = "last_name")
    private String lastname;

    @CsvBindByName(column = "age")
    private int age;
}
