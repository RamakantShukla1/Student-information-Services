package com.student.student_information_system.http

import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import spock.lang.Specification

import java.util.function.Function

class StudentHttpClientSpec extends Specification {

    def "should return student information"() {
        given:
        def webClient = Mock(WebClient)
        def requestHeadersUriSpec = Mock(WebClient.RequestHeadersUriSpec)
        def requestHeadersSpec = Mock(WebClient.RequestHeadersSpec)
        def responseSpec = Mock(WebClient.ResponseSpec)
        def studentHttpClient = new StudentHttpClient(webClient)
        def studentId = "12345"
        def expectedResponse = "Student Information"

        when:
            def result = studentHttpClient.getStudentInformation(studentId)

        then:
        1 * webClient.get() >> requestHeadersUriSpec
        1 * requestHeadersUriSpec.uri(_ as Function) >> requestHeadersSpec
        1 * requestHeadersSpec.retrieve() >> responseSpec
        1 * responseSpec.bodyToMono(String.class) >> Mono.just(expectedResponse)
        result == expectedResponse
    }
}