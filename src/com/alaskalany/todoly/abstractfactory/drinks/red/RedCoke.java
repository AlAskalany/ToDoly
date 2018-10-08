package com.alaskalany.todoly.abstractfactory.drinks.red;

import com.alaskalany.todoly.abstractfactory.drinks.Coke;

public class RedCoke implements Coke {

  static final String DESCRIPTION = "RED COKE";

  @Override
  public String drink() {
    return DESCRIPTION;
  }
}
