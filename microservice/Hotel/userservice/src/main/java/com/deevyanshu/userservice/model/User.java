package com.deevyanshu.userservice.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "micro_users")
public class User {

    @Id
    @Column(name = "ID")
    private String id;

    private String name;

    private String email;

    private String about;

    //transient will not store the field into database
    @Transient
    private List<Rating> ratings;

    public User()
    {

    }

    public User(String id, String name, String email, String about,List<Rating> ratings)
    {
        this.about=about;
        this.email=email;
        this.id=id;
        this.name=name;
        this.ratings=ratings;
    }

    public String getAbout() {
        return about;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
