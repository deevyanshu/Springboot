package com.deevyanshu.exceptionhandling.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.deevyanshu.exceptionhandling.Exception.StudentListEmptyException;
import com.deevyanshu.exceptionhandling.Exception.StudentNotFoundException;
import com.deevyanshu.exceptionhandling.entity.Student;

@Service
public class StudentServiceImpl implements StudentService{

    List<Student> list=new ArrayList<>();

    @Override
    public Student add(Student student) {
        list.add(student);
        return student;        
    }

    @Override
    public List<Student> getAll() {
        if(list.isEmpty()) 
            throw new StudentListEmptyException("no data available");
        return list;
    }

    @Override
    public Student get(int roll) {
        for(Student s:list)
        {
            if(s.getRoll()==roll)
            {
                return s;
            }
        }
        throw new StudentNotFoundException("does not exist");
       
    }

    @Override
    public Student update(int roll, Student student) {
        for(Student s: list)
        {
            if(s.getRoll()==roll)
            {
                s.setName(student.getName());
                s.setSection(student.getSection());
                return s;
            }
        }
        return null;
    }
    
}
