package com.alaskalany.todoly.abstractfactory.drinks.blue;

import com.alaskalany.todoly.abstractfactory.drinks.Coke;

public class BlueCoke implements Coke {

  static final String DESCRIPTION = "BLUE COKE";

  @Override
  public String drink() {

    return DESCRIPTION;
  }
}
