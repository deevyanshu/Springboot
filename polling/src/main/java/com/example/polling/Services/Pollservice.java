package com.example.polling.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polling.Entity.OptionVote;
import com.example.polling.Entity.Poll;
import com.example.polling.Repository.PollRepository;

@Service
public class Pollservice {

    @Autowired
    private PollRepository pollRepository;

    public Poll createPoll(Poll poll)
    {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls()
    {
        return pollRepository.findAll();
    }

    public Poll getPollById(Long id)
    {
        return pollRepository.findById(id).get();
    }

    public void vote(Long pollId, int optionIndex)
    {
        Poll poll=pollRepository.findById(pollId).get();
        List<OptionVote> options= poll.getOptions();

        OptionVote selectedOption=options.get(optionIndex);

        selectedOption.setVoteCount(selectedOption.getVoteCount()+1);

        pollRepository.save(poll);
    }
    
}
