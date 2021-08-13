package com.revinate.emaildigest.deal.service;

import com.revinate.emaildigest.deal.model.Deal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DealServiceTest {
    private static final String EMAIL = "email";

    @InjectMocks
    private DealService dealService;

    @Test
    void generateDailyDeals() {
        var deals = dealService.getDailyDealsByEmail(EMAIL);

        assertEquals(5, deals.size());
        assertDeals(deals);
    }

    @Test
    void generateWeeklyDeals() {
        var deals = dealService.getWeeklyDealsByEmail(EMAIL);

        assertEquals(15, deals.size());
        assertDeals(deals);
    }

    @Test
    void generateDeals() {
        var deals = DealService.getDeals(8);

        assertEquals(8, deals.size());
        assertDeals(deals);
    }

    private void assertDeals(List<Deal> deals) {
        deals.forEach(this::assertDeal);
    }

    private void assertDeal(Deal deal) {
        assertFalse(deal.getName().isEmpty());
        assertFalse(deal.getDescription().isEmpty());
        assertTrue(deal.getOriginalPrice() >= 10 && deal.getOriginalPrice() <= 1000);
        assertTrue(deal.getPercentDiscount() >= 5 && deal.getPercentDiscount() <= 80);
    }
}