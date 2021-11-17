package com.nikitakoselev.apitestingexample.petclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestPetClientTest {


    private WebClient webclient = WebClient.builder().build();

    @Test
    void getPetsByStatus() {
        RestPetClient restPetClient = new RestPetClient(webclient);
        PetStatus petStatus = PetStatus.AVAILABLE;
        Flux<Pet> pets = restPetClient.getPetsByStatus(petStatus);

        Assertions.assertNotNull(pets.collectList().block().size());
        Assertions.assertTrue(pets.collectList().block().size() > 0);
    }

}
