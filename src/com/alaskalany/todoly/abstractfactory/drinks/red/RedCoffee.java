package com.alaskalany.todoly.abstractfactory.drinks.red;

import com.alaskalany.todoly.abstractfactory.drinks.Coffee;

public class RedCoffee implements Coffee {

  static final String DESCRIPTION = "RED COFFEE";

  @Override
  public String drink() {

    return DESCRIPTION;
  }
}
