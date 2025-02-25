package com.student.student_information_system.config

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.web.reactive.function.client.WebClient
import spock.lang.Specification

class StudentAdminConfigSpec extends Specification {

    def "should create WebClient bean with correct configuration"() {
        given:
        def context = new AnnotationConfigApplicationContext(StudentAdminConfig)

        when:
        def webClient = context.getBean("studentWebclient", WebClient)

        then:
        webClient != null
    }
}