package com.student.student_information_system.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.student.student_information_system.domain.Student;
import com.student.student_information_system.service.StudentService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@AllArgsConstructor
public class StudentController {

  private final StudentService studentService;
  @GetMapping("v1/getStudentDetails/{id}")
  ResponseEntity<Student> getStudentDetails(final @PathVariable Integer id) {
    return ResponseEntity.ok().body(studentService.getStudentDetails(id));
}

@PostMapping("v1/addStudent")
ResponseEntity<Student> addStudent(final @RequestBody Student student) {
   return ResponseEntity.created(null).body(studentService.addStudent(student));
}

@PutMapping("v1/updateStudent")
ResponseEntity<Student> updateStudentDetails(final @RequestBody Student student) {
   if (studentService.updateStudent(student) !=null) {
    return ResponseEntity.ok().body (studentService.updateStudent(student));
   } else {
    return ResponseEntity.notFound().build();
   }
}

   @DeleteMapping("v1/deleteStudent/{id}")
   ResponseEntity<Void> deleteStudent(final @PathVariable Integer id) {
    if (studentService.deleteStudent(id)){
        return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
   }
}
