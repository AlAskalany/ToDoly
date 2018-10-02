package com.alaskalany.todoly;

import java.util.ArrayList;

public class MainMenu extends Menu {

    private TaskManager taskManager;
    private AddTaskMenu addTaskMenu;
    private ListTasksMenu listTasksMenu;

    public MainMenu(TaskManager taskManager) {

        super("ToDoly");
        this.taskManager = taskManager;
        this.addTaskMenu = new AddTaskMenu(this, taskManager);
        this.listTasksMenu = new ListTasksMenu(this, this.taskManager);
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
    public void setActions() {

    }

    @Override
    public void onInput(String input) {

        if (input.equals("0")) {
            displayMenu(this);
        } else if (input.equals("1")) {
            displayMenu(addTaskMenu);
        } else if (input.equals("2")) {
            displayMenu(listTasksMenu);
        }
    }
}
