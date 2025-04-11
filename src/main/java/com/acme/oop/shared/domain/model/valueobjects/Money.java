package com.acme.oop.shared.domain.model.valueobjects;

import java.math.BigDecimal;
import java.util.Currency;

public record Money(BigDecimal amount, Currency currency) {

    public Money {
        if (amount == null) throw new IllegalArgumentException("amount cannot be null");
        if (currency == null) throw new IllegalArgumentException("currency cannot be null");
        if (amount.scale() > currency.getDefaultFractionDigits()) throw new IllegalArgumentException("amount cannot be greater than currency");
    }

    public static Money zero(){
        return new Money(BigDecimal.ZERO, Currency.getInstance("USD"));
    }

    public Money add(Money other) {
        if (!currency.equals(other.currency)){
            throw new IllegalArgumentException("Currency should be different than currency");
        }

        return new Money(amount.add(other.amount), currency);

    }

    public Money multiply(int quantity) {
        return new Money(
                amount.multiply(BigDecimal.valueOf(quantity)),
                currency
        );
    }
}
