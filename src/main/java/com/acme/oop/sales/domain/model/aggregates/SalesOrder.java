package com.acme.oop.sales.domain.model.aggregates;

import com.acme.oop.sales.domain.model.valueobjects.ProductId;
import com.acme.oop.shared.domain.model.valueobjects.CustomerId;
import com.acme.oop.shared.domain.model.valueobjects.Money;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class SalesOrder {

    private final UUID id;
    private final CustomerId customerId;
    private final LocalDateTime orderDate;
    private final List<SalesOrderItem> items;
    private Money totalAmount;

    public SalesOrder(CustomerId customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException("CustomerId cannot be null");
        }

        this.id = UUID.randomUUID();
        this.customerId = customerId;
        this.orderDate = LocalDateTime.now();
        this.items = new ArrayList<>();
        this.totalAmount = Money.zero();

    }

    public void addItem(ProductId productId, int quantity, Money unitPrice) {
        if (productId == null) {
            throw new IllegalArgumentException("ProductId cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (unitPrice.amount().compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("UnitPrice must be greater than zero");
        }
        SalesOrderItem item = new SalesOrderItem(productId, quantity, unitPrice);
        items.add(item);
        totalAmount = calculateTotalAmount();
    }

    private Money calculateTotalAmount() {
        return items.stream()
                .map(x -> {
                    return x.calculateSubTotal();
                })
                .reduce(Money.zero(), Money::add);
    }

}
