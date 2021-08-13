package com.revinate.emaildigest.email.service;

import com.revinate.emaildigest.email.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailService {

    public void sendEmail(Email email, String destination) {
        log.info("Sending email {} to {}", email.getSubject(), destination);
    }
}
