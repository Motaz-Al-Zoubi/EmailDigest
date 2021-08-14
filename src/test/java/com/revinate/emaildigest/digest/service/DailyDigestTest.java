package com.revinate.emaildigest.digest.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DailyDigestTest {

    @Autowired
    private DailyDigest dailyDigest;

    @Test
    void shouldReturnTheRightSubject() throws Exception {
        assertTrue(DailyDigest.EMAIL_SUBJECT.equals(dailyDigest.getEmailSubject()));
    }

    @Test
    void shouldReturnTheRightTitle() throws Exception {
        assertTrue(DailyDigest.EMAIL_TITLE.equals(dailyDigest.getEmailTitle()));
    }
}
