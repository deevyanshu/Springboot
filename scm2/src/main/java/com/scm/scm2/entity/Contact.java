package com.scm.scm2.entity;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Contact {

    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Column(length = 1000)
    private String description;
    private boolean favorite=false;
    private String webLink;
    private String linkedInLink;

    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "contact",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<SocialLink> socialLinks=new ArrayList<>();

    
}
