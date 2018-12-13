package com.github.tddiaz.application.controller;

import lombok.Data;

@Data
public class PersonDto {
    private String name;
    private Integer age;

    private AddressDto address;

    @Data
    public static class AddressDto {
        private String line;
        private String city;
        private String country;
    }
}
