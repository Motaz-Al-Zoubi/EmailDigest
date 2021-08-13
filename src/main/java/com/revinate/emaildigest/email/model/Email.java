package com.revinate.emaildigest.email.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Email {
    private String subject;
    private String body;
}
