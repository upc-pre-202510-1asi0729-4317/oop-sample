package com.acme.oop.shared.domain.model.valueobjects;

/**
 * Represents a physical address
 * This value objetc is immutable and shared across bounded contexts.
 *
 * @param street
 * @param city
 * @param postalCode
 * @param country
 */
public record Address(String street, String city, String postalCode, String country) {

    /**
     * Constructs and Address with the specified details.
     *
     * @param street        the street address, must not be null or empty
     * @param city          the city, must not be null or empty
     * @param postalCode    the postal code, must not be null or empty
     * @param country       the country, must not be null or empty
     */
    public Address {
        if (street == null || street.trim().isEmpty()) {
           throw new IllegalArgumentException("street cannot be null or empty");
        }
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("city cannot be null or empty");
        }
        if (postalCode == null || postalCode.trim().isEmpty()) {
            throw new IllegalArgumentException("postalCode cannot be null or empty");
        }
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("country cannot be null or empty");
        }
    }

}
