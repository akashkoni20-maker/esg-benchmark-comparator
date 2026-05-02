package com.internship.backend.service.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AiServiceClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String AI_SERVICE_URL =
            "http://localhost:5000/ai/generate";

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