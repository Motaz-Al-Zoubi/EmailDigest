package com.revinate.emaildigest.scheduler;

import com.revinate.emaildigest.digest.service.DailyDigest;
import com.revinate.emaildigest.digest.service.WeeklyDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DigestsScheduler {

    @Autowired
    DailyDigest dailyDigest;

    @Autowired
    WeeklyDigest weeklyDigest;

    @Scheduled(cron = "0 0 7 * * *")
    public void sendDailyDigests() {
        log.info("Start daily digest job");
        dailyDigest.send();
    }

    @Scheduled(cron = "0 0 7 * * 1")
    public void sendWeeklyDigests() {
        log.info("Start weekly digest job");
        weeklyDigest.send();
    }
}
