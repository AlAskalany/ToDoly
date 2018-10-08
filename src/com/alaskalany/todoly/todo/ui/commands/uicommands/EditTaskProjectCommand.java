package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;

import java.util.Scanner;

public class EditTaskProjectCommand extends Command {

    public static final String TASK_PROJECT_MODIFIED = "Task Project modified";

    private EditTaskProjectCommand(Ui ui) {

        super(ui);
    }

    public static EditTaskProjectCommand create(Ui ui) {

        return new EditTaskProjectCommand(ui);
    }

    public void invoke(Integer taskIndex) {

        System.out.print("New Project: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (!ui.getTaskManager().doesProjectExist(input)) {
            ui.getTaskManager().createProject(input);
        }
        ui.getTaskManager().addTaskToProject(taskIndex, input);
        System.out.println(TASK_PROJECT_MODIFIED);
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
