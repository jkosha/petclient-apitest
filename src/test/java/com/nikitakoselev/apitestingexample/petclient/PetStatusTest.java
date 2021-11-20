package com.nikitakoselev.apitestingexample.petclient;

import org.junit.jupiter.api.Test;

public class PetStatusTest {
    @Test
    void testEnumCreation() {
        PetStatus.fromValue("available");
        PetStatus.fromValue("pending");
        PetStatus.fromValue("sold");
        PetStatus.fromValue("nonexistent");
    }
}
