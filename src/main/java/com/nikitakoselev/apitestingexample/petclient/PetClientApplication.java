package com.nikitakoselev.apitestingexample.petclient;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetClientApplication.class, args);
    }
}
