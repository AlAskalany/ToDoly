package com.alaskalany.todoly.abstractfactory.drinks.blue;

import com.alaskalany.todoly.abstractfactory.drinks.Tea;

public class BlueTea implements Tea {

  static final String DESCRIPTION = "BLUE TEA";

  @Override
  public String drink() {
    return DESCRIPTION;
  }
}
