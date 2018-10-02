package com.alaskalany.todoly;

import java.util.ArrayList;

public class ListTasksMenu extends Menu {

    private final TaskManager taskManager;
    TaskListDueDateMenu taskListDueDateMenu;
    MainMenu mainMenu;

    public ListTasksMenu(MainMenu mainMenu, TaskManager taskManager) {

        super("List All Tasks by:");
        this.taskManager = taskManager;
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
    public void setActions() {

    }

    @Override
    public void onInput(String input) {

        if (input.equals("0")) {
            displayMenu(mainMenu);
        } else if (input.equals("1")) {
            taskListDueDateMenu.display();
        } else if (input.equals("2")) {
        }
    }
}
