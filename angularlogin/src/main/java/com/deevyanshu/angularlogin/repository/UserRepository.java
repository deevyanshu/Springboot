package com.deevyanshu.angularlogin.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deevyanshu.angularlogin.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    @Query(value = "select * from User where username=:username",nativeQuery = true)
	public User getUserByUserName(@Param("username") String username);
    
}
