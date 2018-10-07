package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.UiImpl;

import java.util.Scanner;

public class ListAllTasksCommand {

    private final UiImpl uiImpl;

    private ListAllTasksCommand(UiImpl uiImpl) {

        this.uiImpl = uiImpl;
    }

    public static ListAllTasksCommand create(UiImpl uiImpl) {

        return new ListAllTasksCommand(uiImpl);
    }

    public void invoke() {

        System.out.println(ListAllTasksMenu.LIST_ALL_TASKS_BY.getValue());
        System.out.println(ListAllTasksMenu.DUE_DATE.getValue());
        System.out.println(ListAllTasksMenu.PROJECT.getValue());
        System.out.print(MainMenuCommand.MainMenu.ENTER_A_CHOICE.getValue());
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        handleListAllTasksInput(input, uiImpl);
    }

    private void handleListAllTasksInput(String input, UiImpl ui) {

        switch (Integer.valueOf(input)) {
            case 1:
                ui.listAllTasksByDueDate();
                break;
            case 2:
                ui.listAllTasksByProject();
                break;
            default:
                break;
        }
    }

    public enum ListAllTasksMenu {
        DUE_DATE("1- Due date"), LIST_ALL_TASKS_BY("List all tasks by:"), PROJECT("2- Project");
        private String value;

        ListAllTasksMenu(String value) {

            this.value = value;
        }

        public String getValue() {

            return value;
        }
    }
}
