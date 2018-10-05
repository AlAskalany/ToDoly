package com.alaskalany.todoly.cli;

import com.alaskalany.todoly.todo.TaskManager;

import java.util.ArrayList;

public class MainMenu extends Menu {

    private final AddTaskMenu addTaskMenu;
    private final ListTasksMenu listTasksMenu;

    @SuppressWarnings("unused")
    public MainMenu(TaskManager taskManager) {

        super("ToDoly");
        this.addTaskMenu = new AddTaskMenu(this, taskManager);
        this.listTasksMenu = new ListTasksMenu(this, taskManager);
    }

    @Override
    protected void setOptions(ArrayList<String> options) {

        options.add("Add a task");
        options.add("List all tasks");
        options.add("Save and quit");
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
                displayMenu(this);
                break;
            case "1":
                displayMenu(addTaskMenu);
                break;
            case "2":
                displayMenu(listTasksMenu);
                break;
        }
    }
}
