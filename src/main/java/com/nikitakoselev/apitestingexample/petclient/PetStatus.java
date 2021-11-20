package com.nikitakoselev.apitestingexample.petclient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum PetStatus {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold"),
    NONEXISTENT("nonexistent");

    private String value;

    PetStatus(String value) {
        this.value = value.toLowerCase();
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
        Logger log = LoggerFactory.getLogger(PetStatus.class);
        log.debug("from value = " + text);
        for (PetStatus b : PetStatus.values()) {
            log.debug("pet status value = " + b.value);
            if (String.valueOf(b.value).equals(text.toLowerCase())) {
                return b;
            }
        }
        return null;
    }

}
