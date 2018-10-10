package com.alaskalany.todoly.abstractfactory.drinks;

public interface DrinkFactory {

  Coffee createCoffee();

  Coke createCoke();

  Tea createTea();
}
