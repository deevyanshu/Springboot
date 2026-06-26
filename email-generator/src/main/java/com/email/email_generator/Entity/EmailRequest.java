package com.email.email_generator.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data // with this no need to add allargsconstructor and other
@Getter
@Setter
public class EmailRequest {

    private String emailContent;
    private String tone;
    
}
