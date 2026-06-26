package com.deevyanshu.responseentity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.deevyanshu.responseentity.model.Book;

@Service
public class BookServiceImpl implements BookService {

    static List<Book> list=new ArrayList<>();

    
    static{
        list.add(new Book(1, "java", "abc"));
        list.add(new Book(2, "python", "def"));
        list.add(new Book(3, "c++", "pqr"));
    }

    @Override
    public Book add(Book book) throws Exception{
        if(book.getId()==0 || book.getName().isEmpty() || book.getAuthor().isEmpty())
        {
            throw new Exception();
            //return null;
        }else
        {
            list.add(book);
            return book;
        }
       
       
    }

    @Override
    public List<Book> getAll() {
        
        return list;
    }

    @Override
    public Book get(int id) {
        for(Book i:list)
        {
            if(i.getId()==id)
            {
                return i;
            }
        }
        return null;
    }

    @Override
    public Book delete(int id) {
        Book b=new Book();
        for(Book i:list)
        {
            if(i.getId()==id)
            {
                b=i;
                list.remove(i);
                return b;
            }
        }
        return null;
    }
    
}
