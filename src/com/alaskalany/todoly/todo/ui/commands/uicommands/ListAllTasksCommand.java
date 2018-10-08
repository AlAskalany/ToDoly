package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;

import java.util.Scanner;

public class ListAllTasksCommand extends Command {

    public ListAllTasksCommand(Ui ui) {

        super(ui);
    }

    public static ListAllTasksCommand create(Ui ui) {

        return new ListAllTasksCommand(ui);
    }

    public void invoke() {

        System.out.println(ListAllTasksMenu.LIST_ALL_TASKS_BY.getValue());
        System.out.println(ListAllTasksMenu.DUE_DATE.getValue());
        System.out.println(ListAllTasksMenu.PROJECT.getValue());
        System.out.print(MainMenuCommand.MainMenu.ENTER_A_CHOICE.getValue());
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        handleInput(input);
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

    @Override
    public void handleInput(String input, Integer taskIndex, Ui ui) {

    }

    @Override
    public void handleInput(String input, Ui ui) {

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
