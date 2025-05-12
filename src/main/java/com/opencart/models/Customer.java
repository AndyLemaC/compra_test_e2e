package com.opencart.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String telephone;
    private final String address;
    private final String city;
    private final String postcode;
    private final String country;
    private final String region;
}

