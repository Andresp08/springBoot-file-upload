package com.andresoft.fileupload.student.repository;

import com.andresoft.fileupload.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
