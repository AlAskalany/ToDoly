package com.alaskalany.todoly.cli;

import com.alaskalany.todoly.todo.TaskManager;

import java.util.ArrayList;

public class ListTasksMenu extends Menu {

    private final TaskListDueDateMenu taskListDueDateMenu;
    private final MainMenu mainMenu;

    ListTasksMenu(MainMenu mainMenu, TaskManager taskManager) {

        super("List All Tasks by:");
        this.taskListDueDateMenu = new TaskListDueDateMenu(mainMenu, taskManager);
        this.mainMenu = mainMenu;
    }

    @Override
    protected void setOptions(ArrayList<String> options) {

        options.add("By date");
        options.add("By project");
    }

    @Override
    protected void displayBody() {

    }

    @Override
    protected String setPrompt() {

        return "Enter choice";
    }

    @Override
    public void onInput(String input) {

        switch (input) {
            case "0":
                displayMenu(mainMenu);
                break;
            case "1":
                taskListDueDateMenu.display();
                break;
//noinspection StatementWithEmptyBody
            case "2":
                // TODO: 2018-10-05
                break;
        }
    }
}
