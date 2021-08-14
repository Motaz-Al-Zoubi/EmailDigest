package com.revinate.emaildigest.digest.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeeklyDigestTest {

    @Autowired
    private WeeklyDigest weeklyDigest;

    @Test
    void shouldReturnTheRightSubject() throws Exception {
        assertTrue(WeeklyDigest.EMAIL_SUBJECT.equals(weeklyDigest.getEmailSubject()));
    }

    @Test
    void shouldReturnTheRightTitle() throws Exception {
        assertTrue(WeeklyDigest.EMAIL_TITLE.equals(weeklyDigest.getEmailTitle()));
    }
}
