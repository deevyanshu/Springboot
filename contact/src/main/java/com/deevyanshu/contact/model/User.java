package com.deevyanshu.contact.model;

import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Contacts> contacts;

    public User()
    {

    }

    public User(int id, String name, List<Contacts> contacts)
    {
        this.id=id;
        this.name=name;
        this.contacts=contacts;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setContacts(List<Contacts> contacts) {
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
