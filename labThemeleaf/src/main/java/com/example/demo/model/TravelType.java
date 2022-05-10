package com.example.demo.model;

public enum TravelType {
    BASIC("Basic"),
    ECONOMY("Economy"),
    LUXURY("Luxury"),
    PREMIUM("Premium");

    private String value;

    TravelType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
