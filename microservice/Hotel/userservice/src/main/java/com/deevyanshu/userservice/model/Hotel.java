package com.deevyanshu.userservice.model;

public class Hotel {

    private String id;

    private String name;

    private String location;

    private String about;

    public Hotel()
    {

    }

    public Hotel(String id, String name, String location, String about)
    {
        this.about=about;
        this.id=id;
        this.location=location;
        this.name=name;
    }

    public String getAbout() {
        return about;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
