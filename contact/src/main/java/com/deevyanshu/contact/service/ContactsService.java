package com.deevyanshu.contact.service;

import java.util.List;

import com.deevyanshu.contact.model.User;

public interface ContactsService {
    public List<User> getAll();
    public User get(int id);
    public User add(User user);
}
