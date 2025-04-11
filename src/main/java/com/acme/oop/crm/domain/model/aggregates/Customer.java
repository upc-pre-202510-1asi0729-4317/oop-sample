package com.acme.oop.crm.domain.model.aggregates;

import com.acme.oop.shared.domain.model.valueobjects.Address;
import com.acme.oop.shared.domain.model.valueobjects.CustomerId;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Customer {

    private final CustomerId id;
    @Setter private String name;
    @Setter private String email;
    @Setter private Address address;

    public Customer(String name, String email, Address address) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        if (email == null || email.trim().isEmpty())
            throw new IllegalArgumentException("Customer email cannot be null or empty");
        if (address == null)
            throw new IllegalArgumentException("Customer address cannot be null");

        this.id = new CustomerId();
        this.name = name;
        this.email = email;
        this.address = address;

    }

}
