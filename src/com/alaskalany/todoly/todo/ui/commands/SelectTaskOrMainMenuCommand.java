package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.UiImpl;

import java.util.Scanner;

public class SelectTaskOrMainMenuCommand {

    private final UiImpl uiImpl;

    private SelectTaskOrMainMenuCommand(UiImpl uiImpl) {

        this.uiImpl = uiImpl;
    }

    public static SelectTaskOrMainMenuCommand create(UiImpl uiImpl) {

        return new SelectTaskOrMainMenuCommand(uiImpl);
    }

    public void invoke() {

        System.out.print(ListAllTasksByDueDateCommand.TaskListByDueDateMenu.EDIT_OR_0_FOR_MAIN_MENU.getValue());
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        handleSelectTaskOrMainMenu(input, uiImpl);
    }

    private void handleSelectTaskOrMainMenu(String input, UiImpl ui) {

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
