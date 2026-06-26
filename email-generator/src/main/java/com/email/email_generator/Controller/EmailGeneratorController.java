package com.email.email_generator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.email_generator.Entity.EmailRequest;
import com.email.email_generator.Service.EmailGeneratorService;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/email")
public class EmailGeneratorController {

    @Autowired
    private EmailGeneratorService service;


    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailrequest)
    {
        String response=service.generateEmailReply(emailrequest);
        return ResponseEntity.ok(response);
    }
    
}
