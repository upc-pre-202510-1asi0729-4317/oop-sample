package com.acme.oop;

import com.acme.oop.crm.domain.model.aggregates.Customer;
import com.acme.oop.sales.domain.model.aggregates.SalesOrder;
import com.acme.oop.sales.domain.model.valueobjects.ProductId;
import com.acme.oop.shared.domain.model.valueobjects.Address;
import com.acme.oop.shared.domain.model.valueobjects.Money;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Main entry point for the OOP Saaple application
 *
 * @author Open Source Application Development
 */
public class Main {

    /**
     * Runs the sample applications, creating a customer and a sales order.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Address address = new Address("123 main st", "springfield", "12312", "USA");
        Customer customer = new Customer("John", "Smith", address);

        SalesOrder order = new SalesOrder(customer.getId());
        Money price = new Money(new BigDecimal("29.99"), Currency.getInstance("USD"));
        ProductId productId = new ProductId();
        order.addItem(productId, 3, price);

        System.out.println("Customer: " + customer.getName());
        System.out.println("Order Total: " + order.getTotalAmount().amount() + " " + order.getTotalAmount().currency());

    }
}
