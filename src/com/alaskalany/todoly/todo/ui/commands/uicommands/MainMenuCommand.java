package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;
import org.jetbrains.annotations.Contract;

import java.util.Scanner;

public class MainMenuCommand extends Command {

    public static final String ENTER_A_VALID_INPUT = "Enter a valid input.";

    private MainMenuCommand(Ui ui) {

        super(ui);
    }

    public static MainMenuCommand create(Ui ui) {

        return new MainMenuCommand(ui);
    }

    public void invoke() {

        System.out.println(MainMenu.TO_DOLY.getValue());
        System.out.println(MainMenu.ADD_A_TASK.getValue());
        System.out.println(MainMenu.LIST_ALL_TASKS.getValue());
        System.out.println(MainMenu.SAVE_AND_QUIT.getValue());
        System.out.println();
        System.out.print(MainMenu.ENTER_A_CHOICE.getValue());
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
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
            case 1:
                ui.addTask();
                break;
            case 2:
                ui.listAllTasks();
                break;
            case 3:
                ui.saveAndQuit();
                break;
            default:
                System.out.println(ENTER_A_VALID_INPUT);
                System.out.print(MainMenu.ENTER_A_CHOICE.getValue());
                invoke();
                break;
        }
    }

    public enum MainMenu {
        ADD_A_TASK("1- Add a task"), LIST_ALL_TASKS("2- List all tasks"), SAVE_AND_QUIT(
                "3- Save and quit"), ENTER_A_CHOICE("Enter a choice: "), TO_DOLY("ToDoly");
        private String value;

        MainMenu(String value) {

            this.value = value;
        }

        @Contract(pure = true)
        public String getValue() {

            return value;
        }
    }
}
