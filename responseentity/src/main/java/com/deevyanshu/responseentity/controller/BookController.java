package com.deevyanshu.responseentity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.responseentity.model.Book;
import com.deevyanshu.responseentity.service.BookServiceImpl;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAll()
    {
        List<Book> list=bookServiceImpl.getAll();
        if(list.size()==0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> get(@PathVariable int id)
    {
        if(bookServiceImpl.get(id)==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(bookServiceImpl.get(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Book> add(@RequestBody Book book)
    {
        try
        {
            bookServiceImpl.add(book);
            //return ResponseEntity.status(HttpStatus.CREATED).build();
            return ResponseEntity.of(Optional.of(bookServiceImpl.add(book)));
        }catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> delete(@PathVariable int id)
    {
        Book b=bookServiceImpl.delete(id);
        if(b==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(b);
    }
    
}
