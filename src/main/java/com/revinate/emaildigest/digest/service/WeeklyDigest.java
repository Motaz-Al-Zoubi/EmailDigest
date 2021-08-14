package com.revinate.emaildigest.digest.service;

import java.util.List;

import com.revinate.emaildigest.deal.model.Deal;

import org.springframework.stereotype.Component;

@Component
public class WeeklyDigest extends PeriodicDigest {
    public static final String EMAIL_TITLE = "Check what's coming!";
    public static final String EMAIL_SUBJECT = "Your deals of the week - Get Ready!";

    @Override
    protected String getEmailTitle() {
        return EMAIL_TITLE;
    }

    @Override
    protected String getEmailSubject() {
        return EMAIL_SUBJECT;
    }

    @Override
    protected List<Deal> getDealsByEmail(String email) {
        return dealService.getWeeklyDealsByEmail(email);
    }
}
