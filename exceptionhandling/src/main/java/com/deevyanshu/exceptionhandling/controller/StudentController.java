package com.deevyanshu.exceptionhandling.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.exceptionhandling.entity.Student;
import com.deevyanshu.exceptionhandling.service.StudentServiceImpl;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @PostMapping("/add")
    public Student add(@RequestBody Student s)
    {
        return studentServiceImpl.add(s);
    }

    @GetMapping("/get/{roll}")
    public ResponseEntity<Student> get(@PathVariable int roll)
    {
        //return ResponseEntity.of(Optional.of(studentServiceImpl.get(roll)));
        return ResponseEntity.ok(studentServiceImpl.get(roll));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getALl()
    {
        return ResponseEntity.ok(studentServiceImpl.getAll());
    }

    @PutMapping("/update/{roll}")
    public Student update(int roll,@RequestBody Student s)
    {
        return studentServiceImpl.update(roll, s);
    }
    
}
