package com.student.student_information_system.exception

import org.springframework.http.HttpStatus
import spock.lang.Specification

class GlobalExceptionHandlerTest extends  Specification {

    GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler()

    def "should handle RepositoryException exception"(){
        given :
        def e = new RepositoryException("Test Repository Exception")
        when :
        def result = globalExceptionHandler.RepositoryExceptionHandler(e)
        then :
        result.statusCode == HttpStatus.INTERNAL_SERVER_ERROR
    }

    def "should handle IllegalArgumentException exception" () {
        given :
        def e = new IllegalArgumentException("Test Illegal Argument Exception")
        when :
        def result = globalExceptionHandler.IllegalArgumentExceptionHandler(e)
        then :
        result.statusCode == HttpStatus.BAD_REQUEST
    }
    
}
