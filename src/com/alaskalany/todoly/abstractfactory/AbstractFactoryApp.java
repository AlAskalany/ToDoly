package com.alaskalany.todoly.abstractfactory;

import com.alaskalany.todoly.abstractfactory.drinks.Coffee;
import com.alaskalany.todoly.abstractfactory.drinks.DrinkFactory;
import com.alaskalany.todoly.abstractfactory.drinks.FactoryMaker;
import com.alaskalany.todoly.abstractfactory.drinks.FactoryMaker.DrinkType;
import com.alaskalany.todoly.abstractfactory.drinks.blue.BlueDrinkFactory;

public class AbstractFactoryApp {

  public static void main(String[] args) {

    DrinkFactory factory = new BlueDrinkFactory();
    Coffee coffee = factory.createCoffee();
    System.out.println(coffee.drink());

    System.out.println(FactoryMaker.makeFactory(DrinkType.RED).createCoffee().drink());
  }
}
