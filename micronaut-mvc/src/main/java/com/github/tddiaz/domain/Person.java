package com.github.tddiaz.domain;

import lombok.Data;

@Data
public class Person {
    private String name;
    private Integer age;
    private Address address;
}
