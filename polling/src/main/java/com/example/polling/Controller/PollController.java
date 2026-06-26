package com.example.polling.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polling.Entity.Poll;
import com.example.polling.Entity.Vote;
import com.example.polling.Services.Pollservice;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/polls")
public class PollController {

    @Autowired
    private Pollservice service;

    @PostMapping("/create")
    public Poll createPoll(@RequestBody Poll poll)
    {
        return service.createPoll(poll);
    }

    @GetMapping("/all")
    public List<Poll> getAllPolls()
    {
        return service.getAllPolls();
    }

    @GetMapping("/{id}")
    public Poll getPollById(@PathVariable Long id)
    {
        return service.getPollById(id);
    }

    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote)
    {
        service.vote(vote.getPollId(), vote.getOptionIndex());
    }
    
}
