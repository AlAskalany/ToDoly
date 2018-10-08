package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.UiImpl;

import java.util.ArrayList;

public class ListAllTasksByDueDateCommand extends Command {

    private ListAllTasksByDueDateCommand(Ui ui) {

        super(ui);
    }

    public static ListAllTasksByDueDateCommand create(Ui ui) {

        return new ListAllTasksByDueDateCommand(ui);
    }

    public void invoke() {

        UiImpl.FROM_LIST_BY_DUE_DATE = true;
        System.out.println(TaskListByDueDateMenu.ALL_TASKS_LIST_BY_DUE_DATE.getValue());
        System.out.println();
        ArrayList<String> tasks = ui.getTaskManager().getAllTasksByDueDate();
        tasks.forEach(task -> System.out.println((tasks.indexOf(task) + 1) + "- " + task));
        System.out.println();
        ui.selectTaskOrMainMenu();
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

    public enum TaskListByDueDateMenu {
        ALL_TASKS_LIST_BY_DUE_DATE("All Tasks List - By Due Date"), EDIT_OR_0_FOR_MAIN_MENU(
                "Enter task number to edit or 0 for main menu: ");
        private String value;

        TaskListByDueDateMenu(String value) {

            this.value = value;
        }

        public String getValue() {

            return value;
        }
    }
}
