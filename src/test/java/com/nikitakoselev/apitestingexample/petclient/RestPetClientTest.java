package com.nikitakoselev.apitestingexample.petclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Collection;
import java.util.List;

/**
 * This is a Unit test.
 * It is meant to test separate method, but cannot guarantee that application works as a whole.
 */
class RestPetClientTest {
    private List<Pet> getPetByStatus(String status) {
        RestPetClient restPetClient = new RestPetClient(webclient);
        Flux<Pet> pets = restPetClient.getPetsByStatus(status);

        return pets.collectList().block();
    }

    private WebClient webclient = WebClient.builder().build();

    private void assertPetsHadCorrectStatus(PetStatus petStatus, Collection<Pet> pets) {
        Assertions.assertTrue(pets.stream().allMatch(it -> petStatus.getValue().equals(it.getStatus())));
    }

    private void assertSomePetsWereReturned(List<Pet> resultingPets) {
        Assertions.assertNotNull(resultingPets);
        Assertions.assertTrue(resultingPets.size() > 0);
    }



    @Test
    void shouldRetrieveAvailablePets() {
        List<Pet> pets = getPetByStatus(PetStatus.AVAILABLE.name().toLowerCase());

        assertSomePetsWereReturned(pets);
        assertPetsHadCorrectStatus(PetStatus.AVAILABLE, pets);
    }

    @Test
    void shouldRetrievePendingPets() {
        List<Pet> pets = getPetByStatus(PetStatus.PENDING.name().toLowerCase());

        assertSomePetsWereReturned(pets);
        assertPetsHadCorrectStatus(PetStatus.PENDING, pets);
    }

    @Test
    void shouldRetrieveSoldPets() {
        List<Pet> pets = getPetByStatus(PetStatus.SOLD.name().toLowerCase());

        assertSomePetsWereReturned(pets);
        assertPetsHadCorrectStatus(PetStatus.SOLD, pets);
    }

    @Test
    void shouldNotRetrieveNonexistentPets() {
        List<Pet> pets = getPetByStatus(PetStatus.NONEXISTENT.name().toLowerCase());

        Assertions.assertEquals(0, pets.size());
    }


}
