package com.internship.backend.service.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Service
public class AiServiceClient {

    private final RestTemplate restTemplate;

    private static final String AI_SERVICE_URL =
            "http://localhost:5000/ai/generate";

    public AiServiceClient(RestTemplateBuilder builder) {

        this.restTemplate = builder
                .setConnectTimeout(Duration.ofSeconds(10))
                .setReadTimeout(Duration.ofSeconds(10))
                .build();
    }

    public String generateResponse(String prompt) {

        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("prompt", prompt);

            HttpEntity<Map<String, String>> request =
                    new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response =
                    restTemplate.postForEntity(
                            AI_SERVICE_URL,
                            request,
                            String.class
                    );

            return response.getBody();

        } catch (Exception error) {

            System.out.println(
                    "Error calling AI service: " + error.getMessage()
            );

            return null;
        }
    }
}