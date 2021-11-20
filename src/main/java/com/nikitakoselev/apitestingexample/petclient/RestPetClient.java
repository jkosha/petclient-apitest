package com.nikitakoselev.apitestingexample.petclient;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.IOException;

public class RestPetClient {

    Logger log = LoggerFactory.getLogger(RestPetClient.class);

    private WebClient webClient;

    public RestPetClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Pet> getPetsByStatus(String status) {
        return webClient.get()
                .uri("https://petstore.swagger.io/v2/pet/findByStatus?status={status}", status)
                .retrieve()
                .bodyToFlux(Pet.class)
                .doOnError(IOException.class, it -> log.error("an error has occured"));
    }


}
