package com.nikitakoselev.apitestingexample.petclient;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class PetController {
    Logger log = LoggerFactory.getLogger(PetController.class);

    RestPetClient restPetClient;

    @GetMapping("/")
    public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }

    @GetMapping("/pets")
    public Flux<Pet> getPetsByStatus(@RequestParam(value = "status", defaultValue = "available") String status) {
        log.debug("status = " + status);
        return restPetClient.getPetsByStatus(status);
    }
}
