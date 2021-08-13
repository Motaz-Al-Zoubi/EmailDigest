package com.revinate.emaildigest.deal.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Deal {
    private String name;
    private String description;
    private int percentDiscount;
    private int originalPrice;
}
