package com.scm.scm2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @GetMapping("/dashboard")
    public String userDashboard()
    {
        return "dashboard";
    }
    
}
