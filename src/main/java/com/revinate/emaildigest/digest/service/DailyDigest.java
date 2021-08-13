package com.revinate.emaildigest.digest.service;

import java.util.List;
import com.revinate.emaildigest.deal.model.Deal;
import org.springframework.stereotype.Component;

@Component
public class DailyDigest extends PeriodicDigest {

    @Override
    protected String getEmailTitle() {
        return "Today again! Your amazing deals:";
    }

    @Override
    protected String getEmailSubject() {
        return "Your deals of the day - Don't miss out!";
    }

    @Override
    protected List<Deal> getDealsByEmail(String email) {
        return dealService.getDailyDealsByEmail(email);
    }

}
