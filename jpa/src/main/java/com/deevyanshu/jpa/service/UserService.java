package com.deevyanshu.jpa.service;

import com.deevyanshu.jpa.entity.User;

public interface UserService {

    public User add(User user);

    public User get(int id);

    public User update(int id,User user);

    public User delete(int id);

    public User getByName(String name);
    
}
