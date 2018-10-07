package com.alaskalany.todoly.todo.ui.commands;

public abstract class Command {

    public abstract void invoke();

    public abstract void handleInput(String input);
}
