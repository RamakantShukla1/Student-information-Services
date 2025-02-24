package com.student.student_information_system.http;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class StudentHttpClient {
    private final WebClient webClient;

    public StudentHttpClient(@Qualifier("studentWebclient") final WebClient webClient) {
        this.webClient = webClient;
    }
    
    public String getStudentInformation(final String studentId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/student" +studentId).build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
}
}