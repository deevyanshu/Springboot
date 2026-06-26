package com.deevyanshu.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deevyanshu.mapping.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {
    
}
