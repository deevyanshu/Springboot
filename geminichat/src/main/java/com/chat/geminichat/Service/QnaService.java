package com.chat.geminichat.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class QnaService {

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    private final WebClient webClient; // using webclient instead of RestTemplate for async api calls

    public QnaService(WebClient.Builder webclient) {
        this.webClient = webclient.build();
    }

    public String getAnswer(String question)
    {
        Map<String, Object> requestBody = Map.of(
            "contents", new Object[] { Map.of("parts", new Object[] {Map.of("text", question)})} 
        );

        String response=webClient.post().uri(geminiApiUrl+geminiApiKey).header("Content-Type", "application/json")
        .bodyValue(requestBody).retrieve().bodyToMono(String.class).block();
        
        return response;
    }
    
}
