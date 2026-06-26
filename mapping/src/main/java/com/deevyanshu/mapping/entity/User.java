package com.deevyanshu.mapping.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="user")
    private List<Contact> contacts;

    public User()
    {

    }

    public User(int id,String name,List<Contact> contacts)
    {
        this.contacts=contacts;
        this.id=id;
        this.name=name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setId(int id) {
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
