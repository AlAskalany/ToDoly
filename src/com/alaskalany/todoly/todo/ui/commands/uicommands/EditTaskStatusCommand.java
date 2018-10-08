package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;

import java.util.Scanner;

public class EditTaskStatusCommand extends Command {

    public static final String TASK_STATUS_MODIFIED = "Task status modified";

    private EditTaskStatusCommand(Ui ui) {

        super(ui);
    }

    public static EditTaskStatusCommand create(Ui ui) {

        return new EditTaskStatusCommand(ui);
    }

    public void invoke(Integer taskIndex) {

        System.out.print("New Status: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ui.getTaskManager().getTask(taskIndex).setTitle(input);
        System.out.println(TASK_STATUS_MODIFIED);
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
