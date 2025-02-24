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
            1 * studentService.getStudentDetails(stdId) >> student
            when :
            def result = studentController.getStudentDetails(stdId)
            then :
            result.statusCode == HttpStatus.OK
            result.body == student
        }

    def "should add new student details" () {
        given :
            def student = Student.builder()
                    .stdId(1)
                    .stdName("John")
                    .stdEmail("rkshukla016@gmail.com")
                    .stdPhone("831834")
                    .stdAddress("USA")
                    .stdDepartment("CSE")
                    .build()
        and :
            1 * studentService.addStudent(student) >> student
        when :
            def result = studentController.addStudent(student)
        then :
            result.statusCode == HttpStatus.CREATED
            result.body == student
    }

    def "should update student details" () {
        given :
            def student = Student.builder()
                .stdId(1)
                .stdName("John")
                .stdEmail("")
                .stdPhone("577553552")
                .build()
        and :
            studentService.updateStudent(student) >> student

        when :
            def result = studentController.updateStudentDetails(student)

        then :
            result.statusCode == HttpStatus.OK
            result.body == student
    }

    def "should delete student details" () {
        given :
        def stdId = 1
        and :
        1 * studentService.deleteStudent(stdId)
        when :
         studentController.deleteStudent(stdId)
        then :
        noExceptionThrown()
    }

}
