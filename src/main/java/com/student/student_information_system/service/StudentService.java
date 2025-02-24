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

    public Student addStudent(final Student student) {
        return studentCrudRepository.save(student);
        
    }

    public Student updateStudent(final Student student, final Integer id) {
     Student student2 = studentCrudRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        student2.setStdName(student.getStdName());  
        student2.setStdEmail(student.getStdEmail());
        student2.setStdAddress(student.getStdAddress());
        student2.setStdPhone(student.getStdPhone());
        student2.setStdDepartment(student.getStdDepartment());
        student2.setStdGender(student.getStdGender());
        return studentCrudRepository.save(student2);
    }
    public boolean deletStudent(final Integer id) {
        if (studentCrudRepository.existsById(id)){
            studentCrudRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Student not found");
        }       
    }
}