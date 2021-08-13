package com.revinate.emaildigest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmailDigestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailDigestApplication.class, args);
    }

}
