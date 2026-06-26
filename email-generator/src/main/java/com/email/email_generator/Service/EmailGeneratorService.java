package com.email.email_generator.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.email.email_generator.Entity.EmailRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmailGeneratorService {

    @Value("${gemini.api.url}")
    private String apiUrl;

    @Value("${gemini.api.key}")
    private String apiKey;

     private final WebClient webClient; // using webclient instead of RestTemplate for async api calls

    public EmailGeneratorService(WebClient.Builder webclient) {
        this.webClient = webclient.build();
    }

    public String generateEmailReply(EmailRequest emailRequest)
    {
        String prompt=buildPrompt(emailRequest);

        Map<String, Object> requestBody = Map.of(
            "contents", new Object[] { Map.of("parts", new Object[] {Map.of("text", prompt)})} 
        );

        String response=webClient.post().uri(apiUrl+apiKey).header("Content-Type", "application/json")
        .bodyValue(requestBody).retrieve().bodyToMono(String.class).block();

        return extractResponseContent(response);

    }

    private String buildPrompt(EmailRequest emailRequest)
    {
        StringBuilder prompt=new StringBuilder();
        prompt.append("Generate professional email reply for the following email content. Dont generate multiple reply. Please dont generate the subject line. ");
        if(emailRequest.getTone()!=null && !emailRequest.getTone().isEmpty())
        {
            prompt.append("Use a ").append(emailRequest.getTone()).append("tone");
        }
        prompt.append("\nOriginal email: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }

    private String extractResponseContent(String response)
    {
        try {

            ObjectMapper mapper=new ObjectMapper(); //helps in working with json. it can read write and convert json data to java object and vice versa 
            JsonNode node=mapper.readTree(response); 
            return node.path("candidates").get(0).path("content").path("parts").get(0).get("text").asText();
        } catch (Exception e) {
            return "Error processing request: "+ e.getMessage();
        }
    }

}
