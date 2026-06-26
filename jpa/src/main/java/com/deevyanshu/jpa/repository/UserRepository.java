package com.deevyanshu.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deevyanshu.jpa.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
    
    @Query(value = "select * from User where name=:name",nativeQuery = true)
    public User findByName(@Param("name") String name);
}
