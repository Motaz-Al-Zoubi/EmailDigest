package com.revinate.emaildigest.contact.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Contact {
    private String firstName;
    private String lastName;
    private String email;
}
