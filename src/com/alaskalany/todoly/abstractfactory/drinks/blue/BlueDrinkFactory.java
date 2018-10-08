package com.alaskalany.todoly.abstractfactory.drinks.blue;

import com.alaskalany.todoly.abstractfactory.drinks.Coffee;
import com.alaskalany.todoly.abstractfactory.drinks.Coke;
import com.alaskalany.todoly.abstractfactory.drinks.DrinkFactory;
import com.alaskalany.todoly.abstractfactory.drinks.Tea;

public class BlueDrinkFactory implements DrinkFactory {

  @Override
  public Coffee createCoffee() {
    return new BlueCoffee();
  }

  @Override
  public Coke createCoke() {
    return new BlueCoke();
  }

  @Override
  public Tea createTea() {
    return new BlueTea();
  }
}
