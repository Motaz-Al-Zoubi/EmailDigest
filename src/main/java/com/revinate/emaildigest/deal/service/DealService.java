package com.revinate.emaildigest.deal.service;

import com.github.javafaker.Faker;
import com.revinate.emaildigest.deal.model.Deal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
@Slf4j
public class DealService {
    private static final int NB_DAILY_DEALS = 5;
    private static final int NB_WEEKLY_DEALS = 15;
    private static final Faker FAKER = new Faker();

    public List<Deal> getDailyDealsByEmail(String email) {
        log.info("Getting daily deals for [{}]", email);
        return getDeals(NB_DAILY_DEALS);
    }

    public List<Deal> getWeeklyDealsByEmail(String email) {
        log.info("Getting weekly deals for [{}]", email);
        return getDeals(NB_WEEKLY_DEALS);
    }

    protected static List<Deal> getDeals(int count) {
        var deals = new ArrayList<Deal>(count);
        IntStream.range(0, count).forEach(i -> deals.add(new Deal()
            .setName(FAKER.funnyName().name())
            .setDescription(FAKER.chuckNorris().fact())
            .setOriginalPrice(FAKER.number().numberBetween(10, 1000))
            .setPercentDiscount(FAKER.number().numberBetween(5, 80)))
        );
        return deals;
    }
}
