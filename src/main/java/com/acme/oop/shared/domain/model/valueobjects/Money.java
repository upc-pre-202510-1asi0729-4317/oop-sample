package com.acme.oop.shared.domain.model.valueobjects;

import java.math.BigDecimal;
import java.util.Currency;

public record Money(BigDecimal amount, Currency currency) {
    public Money multiply(int quantity) {
        return new Money(
                amount.multiply(BigDecimal.valueOf(quantity)),
                currency
        );
    }
}
