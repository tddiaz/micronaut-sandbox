package com.github.tddiaz.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String line;
    private String city;
    private String country;

    public Address() {
    }

    private Address(String line, String city, String country) {
        this.line = line;
        this.city = city;
        this.country = country;
    }

    public static Address valueOf(String line, String city, String country) {
        return new Address(line, city, country);
    }
}
