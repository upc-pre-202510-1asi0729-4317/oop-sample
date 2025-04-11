package com.acme.oop.shared.domain.model.valueobjects;

import java.util.UUID;

/**
 * Represents a unique identifier for a Customer across bounded contexts.
 *
 * @param value
 */
public record CustomerId(UUID value) {

    public CustomerId{
        if (value == null)
            throw new IllegalArgumentException("value cannot be null");
    }

    public CustomerId(){
        this(UUID.randomUUID());
    }

}
