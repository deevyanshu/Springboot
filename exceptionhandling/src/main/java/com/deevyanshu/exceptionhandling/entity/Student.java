package com.deevyanshu.exceptionhandling.entity;

public class Student {

    private int roll;

    private String name;

    private String section;

    public Student()
    {

    }

    public Student(int roll, String name, String section)
    {
        this.name=name;
        this.roll=roll;
        this.section=section;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public String getSection() {
        return section;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
