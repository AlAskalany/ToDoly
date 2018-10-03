package com.alaskalany.todoly;

public class Manager {

    private static Manager ourInstance = new Manager();

    public static Manager getInstance() {

        return ourInstance;
    }

    private Manager() {

    }
}
