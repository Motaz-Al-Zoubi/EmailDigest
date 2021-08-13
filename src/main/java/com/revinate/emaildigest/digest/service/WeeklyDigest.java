package com.revinate.emaildigest.digest.service;

import java.util.List;

import com.revinate.emaildigest.deal.model.Deal;

import org.springframework.stereotype.Component;

@Component
public class WeeklyDigest extends PeriodicDigest {
    @Override
    protected String getEmailTitle() {
        return "Check what's coming!";
    }

    @Override
    protected String getEmailSubject() {
        return "Your deals of the week - Get Ready!";
    }

    @Override
    protected List<Deal> getDealsByEmail(String email) {
        return dealService.getWeeklyDealsByEmail(email);
    }
}
