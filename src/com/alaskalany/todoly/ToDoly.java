package com.alaskalany.todoly;

import com.alaskalany.todoly.cli.view.Menu;

/**
 *
 */
public class ToDoly {

    /**
     * @param args Arguments
     */
    public static void main(String[] args) {

        Menu menu = new Menu("Main Menu", "Enter option");
        menu.add("Do stuff");
        menu.add("Make it happen");
        menu.print();
    }
}
