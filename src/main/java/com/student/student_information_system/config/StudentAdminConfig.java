package com.student.student_information_system.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Configuration
public class StudentAdminConfig {

    String hostUrl ="http://localhost:8080/student/{studentId}";

   @Bean("studentWebclient")
    public WebClient webClient() {
       ConnectionProvider provider = ConnectionProvider.builder ("evict-after-120s")
                 .evictInBackground(Duration.ofSeconds(120))
                 .maxLifeTime(Duration.ofSeconds(120))
                 .build();

        ReactorClientHttpConnector ReactorClientHttpConnector = new ReactorClientHttpConnector(HttpClient.create(provider));

        return WebClient.builder()
                .baseUrl(hostUrl)
                .clientConnector(ReactorClientHttpConnector)
                .build();
    }
        
    }


