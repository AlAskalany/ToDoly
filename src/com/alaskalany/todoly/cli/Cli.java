package com.alaskalany.todoly.cli;

import java.util.ArrayList;

public class Cli {

    private ArrayList<Screen> screens;

    public Cli() {

        screens = new ArrayList<>();
    }

    public void addScreen(Screen screen) {

        screens.add(screen);
    }

    public void start() {

        showScreen(screens.get(0));
    }

    private void showScreen(Screen screen) {

        System.out.println(screen.toString());
    }
}
