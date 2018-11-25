package com.github.tddiaz.domain;

import lombok.Value;

@Value(staticConstructor = "valueOf")
public class Address {
    private String line;
    private String city;
    private String country;
}
