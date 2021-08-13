package com.revinate.emaildigest.email.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Email {
    private String subject;
    private String body;
}
