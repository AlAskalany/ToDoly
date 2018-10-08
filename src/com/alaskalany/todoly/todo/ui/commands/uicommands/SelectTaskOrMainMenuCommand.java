package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;

import java.util.Scanner;

public class SelectTaskOrMainMenuCommand extends Command {

    private SelectTaskOrMainMenuCommand(Ui ui) {

        super(ui);
    }

    public static SelectTaskOrMainMenuCommand create(Ui uiImpl) {

        return new SelectTaskOrMainMenuCommand(uiImpl);
    }

    public void invoke() {

        System.out.print(
                ListAllTasksByDueDateCommand.TaskListByDueDateMenu.EDIT_OR_0_FOR_MAIN_MENU.getValue());
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        handleInput(input, ui);
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

        switch (Integer.valueOf(input)) {
            case 0:
                ui.mainMenu();
                break;
            default:
                ui.editSelectedTask(Integer.valueOf(input));
                break;
        }
    }
}
