package com.scm.scm2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.scm2.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,String>{
    
}
