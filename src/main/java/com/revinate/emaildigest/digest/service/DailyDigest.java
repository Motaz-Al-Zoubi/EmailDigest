package com.revinate.emaildigest.digest.service;

import java.util.List;
import com.revinate.emaildigest.deal.model.Deal;
import org.springframework.stereotype.Component;

@Component
public class DailyDigest extends PeriodicDigest {
    public final static String EMAIL_TITLE = "Today again! Your amazing deals:";
    public final static String EMAIL_SUBJECT = "Your deals of the day - Don't miss out!";

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
        return dealService.getDailyDealsByEmail(email);
    }

}
