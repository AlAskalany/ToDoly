package com.alaskalany.todoly.abstractfactory.drinks.blue;

import com.alaskalany.todoly.abstractfactory.drinks.Coffee;

public class BlueCoffee implements Coffee {

    static final String DESCRIPTION = "BLUE COFFEE";

    @Override
    public String drink() {

        return DESCRIPTION;
    }
}
