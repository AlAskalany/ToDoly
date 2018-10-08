package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;

import java.util.Scanner;

public class EditTaskTitleCommand extends Command {

    private EditTaskTitleCommand(Ui ui) {

        super(ui);
    }

    public static EditTaskTitleCommand create(Ui ui) {

        return new EditTaskTitleCommand(ui);
    }

    public void invoke(Integer taskIndex) {

        System.out.print("New title: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ui.getTaskManager().getTask(taskIndex).setTitle(input);
        System.out.println("Task title modified");
        ui.editSelectedTask(taskIndex);
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
