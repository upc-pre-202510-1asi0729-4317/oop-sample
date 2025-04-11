package com.acme.oop.sales.domain.model.aggregates;

import com.acme.oop.shared.domain.model.valueobjects.Money;

public class SalesOrderItem {

    private final int productId;
    private final int quantity;
    private final Money unitPrice;

    SalesOrderItem(int productId, int quantity, Money unitPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Money calculateSubTotal() {
        return unitPrice.multiply(quantity);
    }
}
