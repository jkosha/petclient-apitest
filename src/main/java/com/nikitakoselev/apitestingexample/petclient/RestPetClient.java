package com.nikitakoselev.apitestingexample.petclient;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.IOException;

@Log4j2
public class RestPetClient {


    private WebClient webClient;

    public RestPetClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Pet> getPetsByStatus(PetStatus petStatus) {

        return webClient.get()
                .uri("https://petstore.swagger.io/v2/pet/findByStatus?status={status}", petStatus.getValue())
                .retrieve()
                .bodyToFlux(Pet.class)
                .doOnError(IOException.class, log::error);
    }


}
