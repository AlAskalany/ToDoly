package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;

public abstract class Command {

    protected final Ui ui;

    public Command(Ui ui) {

        this.ui = ui;
    }

    public void invoke() {

        invoke(null);
    }

    public abstract void invoke(Integer valueOf);

    public abstract void handleInput(Integer taskIndex);

    public abstract void handleInput(Integer taskIndex, Ui ui);

    public abstract void handleInput(String input);

    public abstract void handleInput(String input, Integer taskIndex, Ui ui);

    public abstract void handleInput(String input, Ui ui);
}
