package com.deevyanshu.contact.model;

public class Contacts {
    private int id;
    private String name;
    private String number;

    public Contacts()
    {

    }

    public Contacts(int id,String name,String number)
    {
        this.id=id;
        this.name=name;
        this.number=number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
