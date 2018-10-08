package com.alaskalany.todoly.abstractfactory.drinks;

import com.alaskalany.todoly.abstractfactory.drinks.blue.BlueDrinkFactory;
import com.alaskalany.todoly.abstractfactory.drinks.red.RedDrinkFactory;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class FactoryMaker {

    @NotNull
    @Contract("_ -> new")
    public static DrinkFactory makeFactory(@NotNull DrinkType type) {

        switch (type) {
            case RED:
                return new RedDrinkFactory();
            case BLUE:
                return new BlueDrinkFactory();
            default:
                throw new IllegalArgumentException("DrinkType not supported.");
        }
    }

    public enum DrinkType {
        RED, BLUE
    }
}
