package com.student.student_information_system.exception

import org.springframework.dao.DataAccessException
import spock.lang.Specification

class RepositoryExceptionTest extends Specification {

    def "should test RepositoryException creation with only message" () {
        given :
        def message = "Test Repository Exception"
        when :
        def exception = new RepositoryException(message)
        then :
        exception.message == message
    }

    def "should test RepositoryException creation with message and cause" () {
        given :
        def message = "Test Repository Exception"
        def cause = new DataAccessException("Test Cause") {}
        when :
        def exception = new RepositoryException(message, cause)
        then :
        exception.message == message
        exception.cause == cause
    }
}
