package com.revinate.emaildigest.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DigestsScheduler {
    @Scheduled(cron = "0 0 7 * * *")
    public void sendDailyDigests() {
        // ADD CODE HERE
    }

    @Scheduled(cron = "0 0 7 * * 1")
    public void sendWeeklyDigests() {
        // ADD CODE HERE
    }
}
