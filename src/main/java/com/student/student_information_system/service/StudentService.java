package com.student.student_information_system.service;

import org.springframework.stereotype.Service;

import com.student.student_information_system.domain.Student;
import com.student.student_information_system.repository.StudentCrudRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentCrudRepository studentCrudRepository;
    public Student getStudentDetails (final Integer id){
        return studentCrudRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
}

    public Student addStudent(Student student) {
        return studentCrudRepository.save(student);
        
    }

    public Student updateStudent(Student student) {
       return studentCrudRepository.save(student);
    }

    public boolean deletStudent(Integer id) {
        if (studentCrudRepository.existsById(id)){
            studentCrudRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Student not found");
        }
        
    }
}