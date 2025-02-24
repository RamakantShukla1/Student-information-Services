package com.student.student_information_system.controller

import com.student.student_information_system.domain.Student
import com.student.student_information_system.service.StudentService
import org.springframework.http.HttpStatus
import spock.lang.Specification

class StudentControllerTest extends  Specification {

        StudentService studentService = Mock(StudentService)
        StudentController studentController = new StudentController(studentService)

        def "should return student detail" (){
            given :
            def student = new Student()
            def stdId=1
            and :
            studentService.getStudentDetails(stdId) >> student
            when :
            def result = studentController.getStudentDetails(stdId)
            then :
            result.statusCode == HttpStatus.OK
            result.body == student
        }
    }
