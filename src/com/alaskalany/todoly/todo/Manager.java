package com.alaskalany.todoly.todo;

public class Manager {

    private static Manager ourInstance = new Manager();

    public static Manager getInstance() {

        return ourInstance;
    }

    private Manager() {

    }
}
