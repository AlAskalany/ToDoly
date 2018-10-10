package com.alaskalany.todoly.abstractfactory.drinks.red;

import com.alaskalany.todoly.abstractfactory.drinks.Tea;

public class RedTea implements Tea {

  static final String DESCRIPTION = "RED TEA";

  @Override
  public String drink() {

    return DESCRIPTION;
  }
}
