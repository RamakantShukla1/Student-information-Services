package com.student.student_information_system.repository

import com.student.student_information_system.service.StudentService
import com.student.student_information_system.domain.Student
import spock.lang.Specification

class StudentRepositoryTest extends Specification {

    StudentCrudRepository studentCrudRepository = Mock(StudentCrudRepository)
    StudentService studentService = new StudentService(studentCrudRepository)
    
    def "should add student details"(){
        given :
        def student = Student.builder().stdId(1).stdName("John").stdEmail("abc").stdPhone("123").stdAddress("USA").stdDepartment("CSE").build()
        and :
        studentCrudRepository.save(student) >> student
        when :
        def result = studentService.addStudent(student)
        then :
        result == student
    }

    def "should update student details"(){
        given :
        def student = Student.builder().stdId(1).stdName("John").stdEmail("abc").stdPhone("123").stdAddress("USA").stdDepartment("CSE").build()
        and :
        studentCrudRepository.save(student) >> student
        when :
        def result = studentService.updateStudent(student)
        then :
        result == student
    }

    def "should delete student details"(){
        given :
        def stdId = 1
        and :
        studentCrudRepository.existsById(stdId) >> true
        studentCrudRepository.deleteById(stdId)
        when :
        def result = studentService.deleteStudent(stdId)
        then :
        result == true
    }

    def "should return student details"(){
        given :
        def student = Student.builder().stdId(1).stdName("John").stdEmail("abc").stdPhone("123").stdAddress("USA").stdDepartment("CSE").stdGender("M").build()
        def stdId = 1
        and :
        studentCrudRepository.findById(stdId) >> Optional.of(student)
        when :
        def result = studentService.getStudentDetails(stdId)
        then :
        result == student
    }
}

