package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class AddTaskCommand extends Command {

    public static final String ENTER_TASK_NAME = "Enter task name:";

    public AddTaskCommand(Ui ui) {

        super(ui);
    }

    @NotNull
    @Contract("_ -> new")
    public static AddTaskCommand create(Ui ui) {

        return new AddTaskCommand(ui);
    }

    public void invoke() {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String input;
        System.out.print(ENTER_TASK_NAME);
        input = scanner.next();
        String taskTitle = ui.getTaskTitle(input);
        ui.getTaskManager().addTask(taskTitle);
        ui.mainMenu();
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
