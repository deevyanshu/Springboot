package com.deevyanshu.exceptionhandling.service;

import java.util.List;

import com.deevyanshu.exceptionhandling.entity.Student;

public interface StudentService {

    public Student add(Student student);

    public List<Student> getAll();

    public Student get(int roll);

    public Student update(int roll,Student student);
}
