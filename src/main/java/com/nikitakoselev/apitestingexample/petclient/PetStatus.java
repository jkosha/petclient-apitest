package com.nikitakoselev.apitestingexample.petclient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

public enum PetStatus {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold"),
    NONEXISTENT("nonexistent");

    private String value;

    PetStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static PetStatus fromValue(String text) {
        for (PetStatus b : PetStatus.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

}
