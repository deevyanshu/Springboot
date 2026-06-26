package com.deevyanshu.responseentity.service;

import java.util.List;

import com.deevyanshu.responseentity.model.Book;

public interface BookService {
    public Book add(Book book) throws Exception;

    public List<Book> getAll();

    public Book get(int id);

    public Book delete(int id);
}
