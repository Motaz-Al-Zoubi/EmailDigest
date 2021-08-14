package com.revinate.emaildigest.digest.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.revinate.emaildigest.contact.service.ContactService;
import com.revinate.emaildigest.deal.service.DealService;
import com.revinate.emaildigest.email.service.EmailService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PeriodicDigestTest {

    @MockBean
    private EmailService emailService;

    @MockBean
    private DealService dealService;

    @Autowired
    private DailyDigest dailyDigest;

    @Autowired
    private WeeklyDigest weeklyDigest;

    @Test
    void shouldSendAnEmailForEachContactDaily() throws Exception {
        dailyDigest.send();
        verify(emailService, times(ContactService.TOTAL_NB_CONTACTS))
            .sendEmail(Mockito.any(), Mockito.anyString());
    }

    @Test
    void shouldSendAnEmailForEachContactWeekly() throws Exception {
        weeklyDigest.send();
        verify(emailService, times(ContactService.TOTAL_NB_CONTACTS))
            .sendEmail(Mockito.any(), Mockito.anyString());
    }

    @Test
    void shouldUseDealServiceForGettingDailyDeals() throws Exception {
        dailyDigest.send();
        verify(dealService, times(ContactService.TOTAL_NB_CONTACTS))
            .getDailyDealsByEmail(Mockito.any());
    }

    @Test
    void shouldUseDealServiceForGettingWeeklyDeals() throws Exception {
        weeklyDigest.send();
        verify(dealService, times(ContactService.TOTAL_NB_CONTACTS))
            .getWeeklyDealsByEmail(Mockito.any());
    }

}