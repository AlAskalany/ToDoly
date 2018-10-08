package com.alaskalany.todoly.abstractfactory.drinks.red;

import com.alaskalany.todoly.abstractfactory.drinks.Coffee;
import com.alaskalany.todoly.abstractfactory.drinks.Coke;
import com.alaskalany.todoly.abstractfactory.drinks.DrinkFactory;
import com.alaskalany.todoly.abstractfactory.drinks.Tea;

public class RedDrinkFactory implements DrinkFactory {

  @Override
  public Coffee createCoffee() {
    return new RedCoffee();
  }

  @Override
  public Coke createCoke() {
    return new RedCoke();
  }

  @Override
  public Tea createTea() {
    return new RedTea();
  }
}
