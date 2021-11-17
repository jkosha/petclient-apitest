package com.nikitakoselev.apitestingexample.petclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
  private Long id = null;
  private String name = null;
}
