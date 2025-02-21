package com.student.student_information_system.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.student_information_system.domain.Student;

@Repository
public interface StudentCrudRepository  extends CrudRepository<Student, Integer> {

}