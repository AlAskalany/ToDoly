package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;

public class SaveAndQuitCommand extends Command {

    public SaveAndQuitCommand(Ui ui) {

        super(ui);
    }

    public static SaveAndQuitCommand create(Ui ui) {

        return new SaveAndQuitCommand(ui);
    }

    public void invoke() {

        System.exit(0);
    }

    @Override
    public void invoke(Integer valueOf) {

    }

    @Override
    public void handleInput(Integer taskIndex) {

    }

    @Override
    public void handleInput(Integer taskIndex, Ui ui) {

    }

    @Override
    public void handleInput(String input) {

    }

    @Override
    public void handleInput(String input, Integer taskIndex, Ui ui) {

    }

    @Override
    public void handleInput(String input, Ui ui) {

    }
}
