package com.springrest.springrest.services;

import java.util.ArrayList;


import com.springrest.springrest.model.Courses;

public interface CourseInterface {
    public ArrayList<Courses> getAll();
    public Courses add(Courses c);
    public Courses delete(int id);
    public Courses update(int id, Courses c);
}
