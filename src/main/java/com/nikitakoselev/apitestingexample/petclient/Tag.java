package com.nikitakoselev.apitestingexample.petclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
  private Long id = null;
  private String name = null;
}
