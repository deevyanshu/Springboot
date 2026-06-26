package com.example.polling.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polling.Entity.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll,Long>{
    
}
