package com.example.polling.Entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Embeddable // this will allow the class to be embadded in another entity
public class OptionVote {

    private String voteOption;
    private Long voteCount=0l;
    
}
