package com.nikitakoselev.apitestingexample.petclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private Long id = null;
    private Category category = null;
    private String name = null;
    private String status = null;
    private List<String> photoUrls = new ArrayList<>();
    private List<Tag> tags = null;
}
